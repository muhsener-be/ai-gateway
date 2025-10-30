package com.github.muhsenerbe.aigateway.support.shared;

import com.github.javafaker.Faker;

import java.net.URI;
import java.util.UUID;

public class TestData {
    private static final Faker FAKER = new Faker();


    public static String username() {
        return FAKER.name().username();
    }


    public static String randomText() {
        return FAKER.shakespeare().asYouLikeItQuote();
    }

    public static URI randomURI() {
        return URI.create("http://localhost:8080/example/random-" + UUID.randomUUID());
    }
}
