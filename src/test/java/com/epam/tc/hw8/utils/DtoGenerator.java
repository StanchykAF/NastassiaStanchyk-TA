package com.epam.tc.hw8.utils;

import com.epam.tc.hw8.dto.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DtoGenerator {

    public static User generateDefaultUser() {
        return User.builder()
                .userId(0)
                .userStatus(1)
                .username("TestUserFull")
                .firstName("TestFirstName")
                .lastName("TestLastName")
                .email("test@example.com")
                .password("TestPassword")
                .phone("1234567890")
                .build();
    }

    public static User generateUserWithOnlyMandatoryFields() {
        return User.builder()
                .username("TestUserMinimal")
                .email("test@example.com")
                .build();
    }
}
