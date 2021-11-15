package com.heiwait.tripagency.pricer.driver.exposition.rest.api;

import com.heiwait.tripagency.pricer.application.TripPricerService;
import com.heiwait.tripagency.pricer.domain.Destination;
import com.heiwait.tripagency.pricer.domain.TravelClass;
import com.heiwait.tripagency.pricer.domain.error.BusinessErrors;
import com.heiwait.tripagency.pricer.driver.exposition.rest.error.ErrorMessage;
import com.heiwait.tripagency.pricer.driver.exposition.rest.error.PropertiesHttpCode;
import io.swagger.annotations.ApiOperation;
import io.vavr.control.Either;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;
import java.util.Objects;

@RestController
@RequestMapping(value = "/pricer")
public class PricerResource {
    private final TripPricerService tripPricer;
    private final MessageSource messageSource;
    private final PropertiesHttpCode propertiesHttpCode;

    public PricerResource(final TripPricerService tripPricer, final MessageSource messageSource, final PropertiesHttpCode propertiesHttpCode) {
        this.tripPricer = tripPricer;
        this.messageSource = messageSource;
        this.propertiesHttpCode = propertiesHttpCode;
    }

    @ApiOperation(value = "Compute travel fees", notes = "Returns the price of a trip")
    @GetMapping(value = {"/{destination}/travelClass/{travelClass}/priceTrip"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> priceTrip(
            @PathVariable(value = "destination") String destinationName,
            @PathVariable(value = "travelClass") TravelClass travelClass) {
        Destination destination = new Destination(destinationName);
        Either<BusinessErrors, Integer> travelPriceEither = tripPricer.priceTrip(destination, travelClass);

        if (travelPriceEither.isLeft()) {
            Locale usLocale = new Locale("en", "US");
            Locale.setDefault(usLocale);

            BusinessErrors error = travelPriceEither.getLeft();
            String[] params = null;

            String description = messageSource.getMessage(error.code(), params, error.code(), LocaleContextHolder.getLocale());
            HttpStatus httpStatus = HttpStatus.resolve(propertiesHttpCode.getHttpCodeFromErrorCode(error.code()));
            return new ResponseEntity<>(new ErrorMessage(error.code(), description), Objects.requireNonNullElse(httpStatus, HttpStatus.NOT_ACCEPTABLE));
        }

        return new ResponseEntity<>(travelPriceEither.get(), HttpStatus.OK);
    }
}