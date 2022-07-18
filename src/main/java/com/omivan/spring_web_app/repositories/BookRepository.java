package com.omivan.spring_web_app.repositories;

import com.omivan.spring_web_app.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
