package com.sandip.dynamo_rest.repository;

import com.sandip.dynamo_rest.entities.Book;
import com.sandip.dynamo_rest.entities.Lend;
import com.sandip.dynamo_rest.entities.LendStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LendRepository extends CrudRepository<Lend, String> {
    Optional<Lend> findByBookIdAndStatus(String bookId, LendStatus status);
}
