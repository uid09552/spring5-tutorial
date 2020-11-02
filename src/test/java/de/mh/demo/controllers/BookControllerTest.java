package de.mh.demo.controllers;

import de.mh.demo.repositories.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class BookControllerTest {
    BookController bookController;
    @Mock
    BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        bookController = new BookController(bookRepository);
    }

    @Test
    void getBooks() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
        mockMvc.perform(get("/books"))
                .andExpect(status().isOk())
        .andExpect(view().name("books/list"));

    }
}