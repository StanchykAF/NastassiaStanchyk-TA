package com.epam.tc.hw7.entities;

public enum HeaderMenuData {

    HOME("Home"),
    CONTACT_FORM("Contact form"),
    SERVICE("Servise"),
    SUPPORT("Support"),
    DATES("Dates"),
    SEARCH("Search"),
    COMPLEX_TABLE("Complex Table"),
    SIMPLE_TABLE("Simple Table"),
    USER_TABLE("User Table"),
    TABLE_WITH_PAGES("Table with pages"),
    DIFFERENT_ELEMENTS("Different elements"),
    PERFORMANCE("Performance"),
    METALS_AND_COLORS("Metals & Colors");

    public String value;

    HeaderMenuData(String value) {
        this.value = value;
    }
}
