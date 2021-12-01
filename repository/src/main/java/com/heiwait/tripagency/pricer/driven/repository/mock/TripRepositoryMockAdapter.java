package com.heiwait.tripagency.pricer.driven.repository.mock;

import com.heiwait.tripagency.pricer.domain.Destination;
import com.heiwait.tripagency.pricer.domain.Trip;
import com.heiwait.tripagency.pricer.domain.TripRepositoryPort;
import com.heiwait.tripagency.pricer.domain.error.BusinessErrors;
import io.vavr.control.Either;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Objects;

@Repository
@Qualifier("TripRepositoryMockAdapter")
public class TripRepositoryMockAdapter implements TripRepositoryPort {

    final Trip lilleTrip = new Trip(0,0, 0);
    final Trip parisTrip = new Trip(50, 800, 100);
    final Trip beijingTrip = new Trip (100, 1000,1000);
    final Trip newyorkTrip = new Trip(100,1000,800);
    final Trip tokyoTrip = new Trip(100, 1000,1200);

    final Map<String, Trip> trips = Map.ofEntries(
            Map.entry("paris", parisTrip),
            Map.entry("lille", lilleTrip),
            Map.entry("new-york", newyorkTrip),
            Map.entry("tokyo", tokyoTrip),
            Map.entry("beijing", beijingTrip)
    );

    @Override
    public Either<BusinessErrors, Trip> findTripByDestination(final Destination destination) {
        Trip findedTrip = trips.get(destination.name().toLowerCase());

        if(findedTrip == null)
            return Either.left(BusinessErrors.MISSING_DESTINATION);

        return Either.right(findedTrip);
    }
}