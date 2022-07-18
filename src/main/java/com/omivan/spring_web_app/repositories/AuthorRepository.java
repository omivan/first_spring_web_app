package com.omivan.spring_web_app.repositories;

import com.omivan.spring_web_app.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
