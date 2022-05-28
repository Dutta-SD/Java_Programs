package com.sandip.dynamo_rest.repository;

import com.sandip.dynamo_rest.entities.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, String> {
}
