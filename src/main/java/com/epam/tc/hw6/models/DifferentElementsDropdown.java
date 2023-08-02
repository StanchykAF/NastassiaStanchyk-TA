package com.epam.tc.hw6.models;

import lombok.Getter;

@Getter
public enum DifferentElementsDropdown {

    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow");

    private final String text;

    DifferentElementsDropdown(String text) {
        this.text = text;
    }
}
