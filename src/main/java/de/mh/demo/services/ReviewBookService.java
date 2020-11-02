package de.mh.demo.services;

import de.mh.demo.domain.Book;
import de.mh.demo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewBookService {
    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public boolean reviewBooks() {
        int counter = 0;
       var books = bookRepository.findAll();
        for (Book book : books) {
            counter = counter +1;
        }
      if ( counter>-1) {
            return true;
        }
        return false;
    }
}
