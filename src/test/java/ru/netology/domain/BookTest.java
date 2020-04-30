package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    Book book = new Book(2, "Унесенные ветром", 119, "Маргарет Митчелл");

    @Test
    void matchesByName() {
        boolean actual = book.matches("Унесенные ветром");
        assertTrue(actual);
    }

    @Test
    void matchesByAuthor() {
        boolean actual = book.matches("Маргарет Митчелл");
        assertTrue(actual);
    }

    @Test
    void matchesByNotName() {
        boolean actual = book.matches("Дж. К. Роулинг");
        assertFalse(actual);
    }

    @Test
    void matchesByNotAuthor() {
        boolean actual = book.matches("Гарри Поттер и философский камень");
        assertFalse(actual);
    }
}