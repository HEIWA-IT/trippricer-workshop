package com.heiwait.tripagency.pricer.domain;

public class TripPricer {
    public Integer priceTrip(Integer ticketPrice, Integer coefficient, Integer stayFees, Integer agencyFees) {
        return (ticketPrice * coefficient) + stayFees + agencyFees;
    }
}
