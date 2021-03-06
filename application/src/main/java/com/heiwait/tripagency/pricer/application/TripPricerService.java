package com.heiwait.tripagency.pricer.application;

import com.heiwait.tripagency.pricer.domain.TripPricer;
import com.heiwait.tripagency.pricer.domain.TripRepositoryPort;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TripPricerService extends TripPricer {
    public TripPricerService(@Qualifier("TripRepositoryJpaAdapter") final TripRepositoryPort tripRepository) {
        super(tripRepository);
    }
}