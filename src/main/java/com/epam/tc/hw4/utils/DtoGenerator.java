package com.epam.tc.hw4.utils;

import com.epam.tc.hw4.models.User;

public class DtoGenerator {

    public static User createUser(String username, String password) {
        return new User(
                PropertiesReader.readProperty(username),
                PropertiesReader.readProperty(password)
        );
    }
}
