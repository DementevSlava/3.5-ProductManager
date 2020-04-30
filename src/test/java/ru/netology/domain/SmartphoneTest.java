package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    Smartphone smartphone = new Smartphone(1, "Samsung Galaxy S20", 69990, "Samsung");

    @Test
    void matchesByName() {
        boolean actual = smartphone.matches("Samsung Galaxy S20");
        assertTrue(actual);
    }

    @Test
    void matchesByBrand() {
        boolean actual = smartphone.matches("Samsung");
        assertTrue(actual);
    }

    @Test
    void matchesByNotName() {
        boolean actual = smartphone.matches("Apple");
        assertFalse(actual);
    }

    @Test
    void matchesByNotBrand() {
        boolean actual = smartphone.matches("Xiaomi");
        assertFalse(actual);
    }
}