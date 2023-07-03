package com.epam.tc.hw3.utils;

import com.epam.tc.hw3.models.User;

public class DtoGenerator {

    public static User createUser(String username, String password) {
        return new User(
                PropertiesReader.readProperty(username),
                PropertiesReader.readProperty(password)
        );
    }
}
