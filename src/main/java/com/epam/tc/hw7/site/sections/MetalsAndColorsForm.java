package com.epam.tc.hw7.site.sections;

import static com.jdiai.tools.ReflectionUtils.isInterface;

import com.epam.jdi.light.elements.complex.Combobox;
import com.epam.jdi.light.elements.complex.Selector;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.complex.dropdown.DropdownSelect;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import com.epam.jdi.light.ui.html.elements.complex.MultiDropdown;
import com.epam.tc.hw7.entities.MetalsAndColors;
import java.lang.reflect.Field;

public class MetalsAndColorsForm extends Form<MetalsAndColors> {
// TODO: посмотри, блин, внимательно на пример. Сравни. Аккуратно. Возможно я что-то упускаю
    @UI("#colors")
    public Dropdown colors;
    private Combobox metals;
    private MultiDropdown vegetables;
    Section elementsChecklist;
    private Section summary;
    Button submitButton;

    @Override
    public void fillAction(Field field, Object element, Object parent, String setValue) {
        if (isInterface(field, TextField.class))
            ((TextField)element).highlight();
        super.fillAction(field, element, parent, setValue);
    }
}
