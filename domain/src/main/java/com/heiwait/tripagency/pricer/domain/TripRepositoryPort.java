package com.heiwait.tripagency.pricer.domain;

import com.heiwait.tripagency.pricer.domain.error.BusinessErrors;
import io.vavr.control.Either;

public interface TripRepositoryPort {
    Either<BusinessErrors, Trip> findTripByDestination(final Destination destination);
}