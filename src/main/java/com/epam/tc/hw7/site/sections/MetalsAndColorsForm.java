package com.epam.tc.hw7.site.sections;

import static com.jdiai.tools.ReflectionUtils.isInterface;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import com.epam.jdi.light.ui.html.elements.complex.MultiDropdown;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import com.epam.tc.hw7.entities.MetalsAndColors;
import java.lang.reflect.Field;

public class MetalsAndColorsForm extends Form<MetalsAndColors> {
    @JDropdown(root = ".colors", value = ".dropdown-value", list = "li", expand = ".caret")
    public Dropdown colors;
    @JDropdown(root = ".metals", value = ".dropdown-value", list = "li", expand = ".caret")
    public Dropdown metals;
    public MultiDropdown vegetables;
    @UI("#elements-block input[type=checkbox]")
    public Checklist elements;
    @UI("[name=custom_radio_odd]")
    public RadioButtons odds;
    @UI("[name=custom_radio_even]")
    public RadioButtons evens;
    Button submitButton;

    @Override
    public void fillAction(Field field, Object element, Object parent, String setValue) {
        if (isInterface(field, TextField.class)) {
            ((TextField) element).highlight();
        }
        super.fillAction(field, element, parent, setValue);
    }
}
