package com.heiwait.tripagency.pricer.domain;

import com.heiwait.tripagency.pricer.domain.error.BusinessErrors;
import io.vavr.control.Either;

public interface PriceComputorDriverPort {
    Either<BusinessErrors, Integer> priceTrip(final Destination destination, final TravelClass travelClass);
}
