package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductManager manager = new ProductManager();
    Product product1 = new Book(1, "Гарри Поттер и философский камень", 249, "Дж. К. Роулинг");
    Product product99 = new Book(1, "Гарри Поттер и тайная комната", 249, "Дж. К. Роулинг");
    Product product2 = new Book(2, "Унесенные ветром", 119, "Маргарет Митчелл");
    Product product3 = new Book(3, "Игра престолов", 369, "Джордж Р. Р. Мартин");

    Product product4 = new Smartphone(1, "Samsung Galaxy S20", 69990, "Samsung");
    Product product5 = new Smartphone(2, "Samsung Galaxy A51", 19990, "Samsung");
    Product product6 = new Smartphone(3, "Huawei P40 Pro", 62990, "Huawei");
    Product product7 = new Smartphone(4, "Apple iPhone 11 Pro", 89990, "Apple");
    Product product8 = new Smartphone(5, "Apple iPhone 11", 64990, "Apple");

    @BeforeEach
    void setup() {
        manager.addProduct(product1);
        manager.addProduct(product2);
        manager.addProduct(product3);
        manager.addProduct(product4);
        manager.addProduct(product5);
        manager.addProduct(product6);
        manager.addProduct(product7);
        manager.addProduct(product8);
        manager.addProduct(product99);
    }

    @Test
    void searchByManufacturer() {
        Product[] actual = manager.searchBy("Samsung");
        Product[] expected = {
                new Smartphone(1, "Samsung Galaxy S20", 69990, "Samsung"),
                new Smartphone(2, "Samsung Galaxy A51", 19990, "Samsung")
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBySmartphoneName() {
        Product[] actual = manager.searchBy("Huawei P40 Pro");
        Product[] expected = {
                new Smartphone(3, "Huawei P40 Pro", 62990, "Huawei")
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByBookName() {
        Product[] actual = manager.searchBy("Унесенные ветром");
        Product[] expected = {
                new Book(2, "Унесенные ветром", 119, "Маргарет Митчелл")
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByAuthor() {
        Product[] actual = manager.searchBy("Дж. К. Роулинг");
        Product[] expected = {
                new Book(1, "Гарри Поттер и философский камень", 249, "Дж. К. Роулинг"),
                new Book(1, "Гарри Поттер и тайная комната", 249, "Дж. К. Роулинг")
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByUnknownType() {
        Product[] actual = manager.searchBy("Траляля");
        Product[] expected = {};
        assertArrayEquals(expected, actual);
    }
}