package com.omivan.spring_web_app.bootstrap;

import com.omivan.spring_web_app.domain.Author;
import com.omivan.spring_web_app.domain.Book;
import com.omivan.spring_web_app.domain.Publisher;
import com.omivan.spring_web_app.repositories.AuthorRepository;
import com.omivan.spring_web_app.repositories.BookRepository;
import com.omivan.spring_web_app.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author1 = new Author("Ivan", "Omelchenko");
        authorRepository.save(author1);
        Book book1 = new Book("Harry Poter1", "4567654");
        bookRepository.save(book1);
        Book book2 = new Book("Harry Poter2", "4567654");
        bookRepository.save(book2);
        Publisher publisher1 = new Publisher("ABDC", "8 Dean Ryle str");
        publisherRepository.save(publisher1);

        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);
        book1.setPublisher(publisher1);
        publisher1.getBooks().addAll(Arrays.asList(book1, book2));
        authorRepository.save(author1);
        bookRepository.save(book1);
        bookRepository.save(book2);
        publisherRepository.save(publisher1);

        System.out.println(("Number of books: " + publisher1.getBooks().size()));

    }
}
