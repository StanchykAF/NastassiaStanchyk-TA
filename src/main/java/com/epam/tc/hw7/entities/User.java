package com.epam.tc.hw7.entities;

import lombok.Value;

@Value
public class User {

    private String name;
    private String password;
    private String fullName;
}
