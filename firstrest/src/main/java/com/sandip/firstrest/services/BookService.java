package com.sandip.firstrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sandip.firstrest.dao.BookRepository;
import com.sandip.firstrest.entities.Book;

/*
 * OLD CODE 
 * ************************************************************
 * @Component - Spring Manages
 * We can also use @Service
 * 
 * 	static private List<Book> list = new ArrayList<Book>();
	static {
		list.add(new Book(12, "Python guide", "ABC"));
		list.add(new Book(13, "PHP guide", "ABC"));
		list.add(new Book(14, "C guide", "ABC"));
		list.add(new Book(15, "Go guide", "ABC"));
		list.add(new Book(16, "Docker guide", "ABC"));
	}
	
 * ************************************************************
 * Save and UPDATE does same functionality. If book exists and we again save it, 
 * it will just update the entry. We do not need to do anything else
 */
@Component
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	// methods for get all books
	public List<Book> getAllBooks() {
		List<Book> listOfBooks = (List<Book>) bookRepository.findAll();
		return listOfBooks;
	}

	// get single book by id
	public Book getBookById(int id) {
		return bookRepository.findById(id);
	}

	// Assumption -- id is same for both previous and updated book
	public void addBook(Book b) {
		bookRepository.save(b);
	}

	// Delete a book Via Stream API
	public void deleteBook(int bookId) {
		bookRepository.deleteById(bookId);
	}

	// Update book
	public void updateBook(Book book, int bookId) {
		// Shady
		book.setId(bookId);
		bookRepository.save(book);
	}
}
