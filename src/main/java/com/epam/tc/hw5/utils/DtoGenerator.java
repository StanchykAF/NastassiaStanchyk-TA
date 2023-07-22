package com.epam.tc.hw5.utils;

import com.epam.tc.hw5.models.User;

public class DtoGenerator {

    public static User createUser(String username, String password) {
        return new User(
                PropertiesReader.readProperty(username),
                PropertiesReader.readProperty(password)
        );
    }
}
