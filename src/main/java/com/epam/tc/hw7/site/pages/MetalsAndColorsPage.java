package com.epam.tc.hw7.site.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.tc.hw7.site.sections.MetalsAndColorsForm;
import java.util.List;

@Url("/metals-colors.html")
@Title("Metal and Colors")
public class MetalsAndColorsPage extends WebPage {

    @UI("form.form")
    public static MetalsAndColorsForm metalsAndColorsForm;
    @UI(".results > li")
    public static List<Text> results;
}
