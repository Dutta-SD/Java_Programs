package com.sandip.firstrest.dao;

import org.springframework.data.repository.CrudRepository;

import com.sandip.firstrest.entities.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
	public Book findById(int id);

}
