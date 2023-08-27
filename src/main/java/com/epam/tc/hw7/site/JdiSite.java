package com.epam.tc.hw7.site;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.tc.hw7.site.pages.HomePage;
import com.epam.tc.hw7.site.pages.MetalsAndColorsPage;

public class JdiSite {

    public static HomePage homePage;
    public static MetalsAndColorsPage metalsAndColorsPage;

    @Css(".uui-navigation.nav > li")
    public static Menu headerMenu;

    public static void open() {
        homePage.open();
    }
}
