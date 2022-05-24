package com.heiwait.tripagency.pricer.driver.exposition.rest.api;

import com.heiwait.tripagency.pricer.application.TripPricerService;
import com.heiwait.tripagency.pricer.domain.Destination;
import com.heiwait.tripagency.pricer.domain.TravelClass;
import com.heiwait.tripagency.pricer.domain.error.BusinessErrors;
import com.heiwait.tripagency.pricer.driver.exposition.rest.error.ErrorMessage;
import com.heiwait.tripagency.pricer.driver.exposition.rest.error.PropertiesHttpCode;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Compute travel fees", description = "Returns the price of a trip")
    @GetMapping(value = {"/{destination}/travelClass/{travelClass}/priceTrip"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> priceTrip(
            @PathVariable(value = "destination") String destinationName,
            @PathVariable(value = "travelClass") TravelClass travelClass) {
       return null;
    }

    private ResponseEntity<ErrorMessage> processErrorMessage(BusinessErrors error) {
        String[] params = null;
        String description = messageSource.getMessage(error.code(), params, error.code(), LocaleContextHolder.getLocale());
        HttpStatus httpStatus = HttpStatus.resolve(propertiesHttpCode.getHttpCodeFromErrorCode(error.code()));
        return new ResponseEntity<>(new ErrorMessage(error.code(), description), Objects.requireNonNullElse(httpStatus, HttpStatus.NOT_ACCEPTABLE));
    }
}