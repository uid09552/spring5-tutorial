package de.mh.demo.services;

import de.mh.demo.repositories.BookRepository;
import de.mh.demo.domain.Book;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ReviewBookServiceTest {
    ReviewBookService reviewBookService;

    @Mock
    BookRepository bookRepository;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        reviewBookService = new ReviewBookService();
        reviewBookService.setBookRepository(bookRepository);
        Book book = new Book();
        book.setId(6L);
        book.setTitle("mytitle");
        bookRepository.save(book);
        when(bookRepository.count()).thenReturn(1L);
    }
    @Test
    void reviewBooks() {
        assertEquals(1L, bookRepository.count());
        assertTrue(reviewBookService.reviewBooks());
        verify(bookRepository, times(1)).findAll();
    }
}