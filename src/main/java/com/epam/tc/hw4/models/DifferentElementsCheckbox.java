package com.epam.tc.hw4.models;

public enum DifferentElementsCheckbox {

    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire");

    private final String text;

    DifferentElementsCheckbox(String text) {
        this.text = text;
    }
}
