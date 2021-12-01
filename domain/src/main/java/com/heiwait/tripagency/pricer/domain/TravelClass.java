package com.heiwait.tripagency.pricer.domain;

public enum TravelClass {
    ECONOMIC(1), FIRST(2), BUSINESS(5);

    private final Integer coefficient;

    TravelClass(Integer coefficient) {
        this.coefficient = coefficient;
    }

    public Integer coefficient() {
        return coefficient;
    }
}