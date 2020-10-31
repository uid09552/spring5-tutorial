package de.mh.demo.bootstrap;

import de.mh.demo.domain.Author;
import de.mh.demo.domain.Book;
import de.mh.demo.domain.Publisher;
import de.mh.demo.repositories.AuthorRepository;
import de.mh.demo.repositories.BookRepository;
import de.mh.demo.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book book = new Book("DDD", "sadfasfd");
        eric.getBooks().add(book);
        book.getAuthors().add(eric);
        authorRepository.save(eric);

        Author rod = new Author("Rod", "Stevard");
        Book roodbook = new Book("microthings", "iopsls");
        eric.getBooks().add(roodbook);
        Publisher p = new Publisher();
        p.setName("myname");
        publisherRepository.save(p);
        roodbook.setPublisher(p);

        book.setPublisher(p);
        book.getAuthors().add(rod);
        authorRepository.save(rod);
        bookRepository.save(roodbook);
        bookRepository.save(book);

        System.out.println("bootstrap db");
        System.out.println(bookRepository.count());
        System.out.println(publisherRepository.count());
    }
}
