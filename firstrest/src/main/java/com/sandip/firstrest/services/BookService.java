package com.sandip.firstrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.sandip.firstrest.entities.Book;

/*
 * @Component - Spring Manages
 * We can also use @Service
 */
@Component
public class BookService {
	static private List<Book> list = new ArrayList<Book>();
	static {
		list.add(new Book(12, "Python guide", "ABC"));
		list.add(new Book(13, "PHP guide", "ABC"));
		list.add(new Book(14, "C guide", "ABC"));
		list.add(new Book(15, "Go guide", "ABC"));
		list.add(new Book(16, "Docker guide", "ABC"));
	}

//	methods for get all books
	public List<Book> getAllBooks() {
		return list;
	}

// get single book by id
	public Book getBookById(int id) {
//		Stream API one liner
//		Exception may occur, handle it later...
		Book book = null;
		book = list.stream().filter(e -> e.getId() == id).findFirst().get();

		return book;

	}

	public void addBook(Book b) {
		list.add(b);
	}

//	Delete a book Via Stream API
	public void deleteBook(int bId) {
		list = list.stream().filter(book -> book.getId() != bId).collect(Collectors.toList());
	}

//	Update book
	public void updateBook(Book book, int bookId) {
//		Pass a book and book id
		list = list.stream().map(bk -> {
			if (book.getId() == bookId) {
				return book;
			}
			return bk;
		}).collect(Collectors.toList());
	}

}
