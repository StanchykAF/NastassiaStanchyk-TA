package com.epam.tc.hw7.entities;

import com.jdiai.tools.DataClass;

public class Contacts extends DataClass<Contacts> {

    public String firstName, lastName, acceptConditions, position, passportNumber,
            passportSeria, description, gender, weather;
    public boolean passport;
}
