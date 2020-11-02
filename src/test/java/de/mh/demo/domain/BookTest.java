package de.mh.demo.domain;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    Book book;
    @BeforeEach
    public void setUp() {
        this.book = new Book();
    }

    @Test
    void getId() {
        this.book.setId(4L);
        assertEquals(4L, book.getId());
    }

    @Test
    void getTitle() {
    }

    @Test
    void setTitle() {
    }
}