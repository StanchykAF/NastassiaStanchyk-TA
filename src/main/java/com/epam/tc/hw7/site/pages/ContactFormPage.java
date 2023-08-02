package com.epam.tc.hw7.site.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.tc.hw7.site.sections.ContactForm;

@Url("/contacts.html") @Title("Contact Form")
public class ContactFormPage extends WebPage {

    @UI("form#contact-form") public static ContactForm contactForm;
}
