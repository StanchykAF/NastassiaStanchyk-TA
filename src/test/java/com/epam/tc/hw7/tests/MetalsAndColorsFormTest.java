package com.epam.tc.hw7.tests;

import static com.epam.tc.hw7.entities.HeaderMenuData.CONTACT_FORM;
import static com.epam.tc.hw7.entities.HeaderMenuData.METALS_AND_COLORS;
import static com.epam.tc.hw7.site.pages.ContactFormPage.contactForm;
import static com.epam.tc.hw7.site.pages.MetalsAndColorsFormPage.metalsAndColorsForm;
import static com.epam.tc.hw7.utils.PropertiesReader.readProperty;
import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw7.TestsInit;
import com.epam.tc.hw7.entities.Contacts;
import com.epam.tc.hw7.entities.MetalsAndColors;
import com.epam.tc.hw7.entities.User;
import com.epam.tc.hw7.site.JdiSite;
import com.epam.tc.hw7.utils.TestNGListener;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNGListener.class)
public class MetalsAndColorsFormTest implements TestsInit {

    @Test
    public void loginTest() throws InterruptedException {
        User user = new User(
                readProperty("user.name"),
                readProperty("user.password"),
                readProperty("user.profile.name"));
        JdiSite.homePage.login(user);
//        String actualUserName = JdiSite.homePage.getUserName();
//        assertThat(actualUserName).isEqualTo(user.getFullName());

        JdiSite.headerMenu.select(METALS_AND_COLORS);
//        JdiSite.metalsAndColorsPage.checkOpened();

        MetalsAndColors metalsAndColors = new MetalsAndColors().set(c -> {
//            c.metals = "Gold";
            c.colors = "Red";
            c.elementsChecklist = "Water, Earth";
            c.summary = 3;
            c.vegetables = "Cucumber, Onion";
        });

        System.out.println(metalsAndColors);
        System.out.println(metalsAndColorsForm.colors.is().displayed());


        metalsAndColorsForm.colors.select("Blue");
        metalsAndColorsForm.submit(metalsAndColors);
        Thread.sleep(5000);
        metalsAndColorsForm.check(metalsAndColors);

    }

    @Test
    public void fillContactFormTest() {
        User user = new User(
                readProperty("user.name"),
                readProperty("user.password"),
                readProperty("user.profile.name"));
        JdiSite.homePage.login(user);

        JdiSite.headerMenu.select(CONTACT_FORM);

        Contacts DEFAULT_CONTACT = new Contacts().set(c-> {
            c.firstName = "Roman"; c.lastName = "Iovlev"; c.position = "ChiefQA";
            c.passport = true; c.passportNumber = "4321"; c.passportSeria = "123456";
            c.description = "JDI - awesome UI automation tool"; c.acceptConditions = "true";
            c.gender = "Female"; c.weather = "Sun, Rain";
        });

        contactForm.submit(DEFAULT_CONTACT);
        contactForm.check(DEFAULT_CONTACT);
    }
}
