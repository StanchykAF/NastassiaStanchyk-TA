package com.epam.tc.hw7.site.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.tc.hw7.site.sections.MetalsAndColorsForm;

@Url("/metals-colors.html")
@Title("Metal and Colors")
public class MetalsAndColorsFormPage extends WebPage {

//    @Css(".form")
//    public static MetalsAndColorsForm metalsAndColorsForm;

    @UI("form.form")
    public static MetalsAndColorsForm metalsAndColorsForm;

//    public void fillForm(MetalsAndColors metalsAndColors) {
//        System.out.println(metalsAndColorsForm.colors.is().displayed());
////        metalsAndColorsForm.select(metalsAndColors);
//        metalsAndColorsForm.submit(metalsAndColors);
//    }
}
