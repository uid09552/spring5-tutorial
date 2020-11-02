package de.mh.demo.controllers;

import de.mh.demo.domain.Book;
import de.mh.demo.repositories.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;
import java.util.HashSet;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@SpringBootTest
class BookControllerTest {
    BookController bookController;
    @Mock
    BookRepository bookRepository;
    @Resource
    private WebApplicationContext webApplicationContext;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        bookController = new BookController(bookRepository);
    }

    @Test
    void getBooks() throws Exception {
        HashSet<Book> books = new HashSet<>();
        var book = new Book();
        book.setTitle("mybook");
        book.setId(1L);
        book.setIsbn("myisbm");
        books.add(book);
        when(bookRepository.findAll()).thenReturn(books);
        //MockMvc mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        var result = mockMvc.perform(get("/books"))
                .andExpect(status().isOk())
        .andExpect(view().name("books/list"))
                .andExpect(model().attribute("books", hasSize(1)))
                .andExpect(content().string(containsString("mybook")))
        .andDo(print()).andReturn();

        HashSet<Book> resultBookModel = (HashSet<Book>)result.getModelAndView().getModel().get("books");
        assertEquals(1,resultBookModel.size());
       System.out.println(result);
    }
}