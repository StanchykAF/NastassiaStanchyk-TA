package com.epam.tc.hw7.site.sections;

import static com.jdiai.tools.ReflectionUtils.isInterface;

import com.epam.jdi.light.elements.complex.dropdown.DropdownSelect;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.ui.html.elements.common.TextArea;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import com.epam.jdi.light.ui.html.elements.complex.MultiDropdown;
import com.epam.tc.hw7.entities.Contacts;
import java.lang.reflect.Field;

public class ContactForm extends Form<Contacts> {

    TextField firstName, lastName, position, passportNumber, passportSeria;

    DropdownSelect gender;
    MultiDropdown weather;

    Checkbox passport, acceptConditions;
    TextArea description;

    //jdi will find [type=submit] element in this context automatically
    //@UI("['Submit']") public Button submit;

    @Override
    public void fillAction(Field field, Object element, Object parent, String setValue) {
        if (isInterface(field, TextField.class))
            ((TextField)element).highlight();
        super.fillAction(field, element, parent, setValue);
    }
}
