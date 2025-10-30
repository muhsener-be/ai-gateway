package com.github.muhsenerbe.aigateway.support.shared;

import com.github.javafaker.Faker;

public class TestData {
    private static final Faker FAKER = new Faker();


    public static String username() {
        return FAKER.name().username();
    }


    public static String randomText() {
        return FAKER.shakespeare().asYouLikeItQuote();
    }
}
