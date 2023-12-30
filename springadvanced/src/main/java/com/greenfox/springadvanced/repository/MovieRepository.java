package com.greenfox.springadvanced.repository;

import com.greenfox.springadvanced.model.Movie;
import org.springframework.data.repository.ListCrudRepository;

public interface MovieRepository extends ListCrudRepository<Movie, Long> {
}
