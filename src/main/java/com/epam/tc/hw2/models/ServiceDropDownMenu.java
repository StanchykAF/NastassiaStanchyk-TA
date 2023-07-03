package com.epam.tc.hw2.models;

public enum ServiceDropDownMenu {

    SUPPORT("Support"),
    DATES("Dates"),
    SEARCH("Search"),
    COMPLEX_TABLE("Complex Table "),
    SIMPLE_TABLE("Simple Table "),
    USER_TABLE("User Table "),
    TABLE_WITH_PAGES("Table with pages"),
    DIFFERENT_ELEMENTS("Different elements"),
    PERFORMANCE("Performance");

    private final String text;

    ServiceDropDownMenu(String text) {
        this.text = text;
    }
}
