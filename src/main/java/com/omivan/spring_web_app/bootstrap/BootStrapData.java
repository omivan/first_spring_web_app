package com.omivan.spring_web_app.bootstrap;

import com.omivan.spring_web_app.domain.Author;
import com.omivan.spring_web_app.domain.Book;
import com.omivan.spring_web_app.domain.Publisher;
import com.omivan.spring_web_app.repositories.AuthorRepository;
import com.omivan.spring_web_app.repositories.BookRepository;
import com.omivan.spring_web_app.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
        Book book1 = new Book("Harry Poter", "4567654");
        Publisher publisher1 = new Publisher("ABDC", "8 Dean Ryle str");
        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);
        publisherRepository.save(publisher1);

        authorRepository.save(author1);
        bookRepository.save(book1);

        System.out.println(("Number of publishes: " + publisherRepository.count()));

    }
}
