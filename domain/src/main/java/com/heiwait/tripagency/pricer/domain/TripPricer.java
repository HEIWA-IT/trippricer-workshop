package com.heiwait.tripagency.pricer.domain;

import com.heiwait.tripagency.pricer.domain.error.BusinessErrors;
import io.vavr.control.Either;

public class TripPricer implements PriceComputorDriverPort {

    protected TripRepositoryPort tripRepository;

    public TripPricer(final TripRepositoryPort tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    public Either<BusinessErrors, Integer> priceTrip(final Destination destination, final TravelClass travelClass) {
        Either<BusinessErrors, Trip> tripEither = tripRepository.findTripByDestination(destination);

        if(tripEither.isLeft()) {
            return Either.left(tripEither.getLeft());
        }

        return Either.right(priceTrip(travelClass, tripEither.get()));
    }

    private Integer priceTrip(TravelClass travelClass, Trip trip) {
        return (trip.ticketPrice() * travelClass.coefficient()) + trip.agencyFees() + trip.stayFees();
    }
}