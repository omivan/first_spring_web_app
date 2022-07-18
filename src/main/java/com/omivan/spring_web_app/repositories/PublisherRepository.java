package com.omivan.spring_web_app.repositories;

import com.omivan.spring_web_app.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
