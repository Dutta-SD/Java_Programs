package com.sandip.firstrest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sandip.firstrest.entities.Book;
import com.sandip.firstrest.services.BookService;

/*For REST API, we have RESTController. @ResponseBody not needed
 * ****************************************************************************
 * Get single book Path variable add
 *
 *
 * @GetMapping("/books") public Book getBookById(@RequestParam int id) { return
 * bookService.getBookById(id);
 * 
 * }
 * ****************************************************************************
 * For URL handler method, write with following annotations and Map the Method
 * and API Endpoint
 * 
 * @RequestMapping(value = "/books", method = RequestMethod.GET)
 * 
 * @ResponseBody Usually returns view. To return as string, @ResponseBody
 * 
 * @RestController - Automatically converted to JSON. Jackson automatic turned
 * on. Is automatic. @Controller does not do this
 * 
 * *************************************************************************
 * POST Mapping, create new Book object POST object created in Request Body
 * So @RequestBody Annotation
 * 
 * *************************************************************************
 * @DeleteMapping -- Used for deleting stuff. Can return void or the deleted object
 * 
 * *************************************************************************
 * @PutMapping -- Update any entry.
 * 
 * **************************************************************************
 * 
 * Full CRUD functionality implemented here.
 * 
 * No need to change anything for the controller, whether fake service or actual DB 
 * 
 */

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/books")
	public List<Book> getBooks() {
		return bookService.getAllBooks();

	}

	@GetMapping("/books/{id}")
	public Book getOneBook(@PathVariable("id") int id) {
		return bookService.getBookById(id);
	}

	@PostMapping("/books")
	public Book addBook(@RequestBody Book b) {
		bookService.addBook(b);
		return b;
	}

	@DeleteMapping("/books/{id}")
	public void deleteBook(@PathVariable("id") int bookId) {
		bookService.deleteBook(bookId);
	}

	@PutMapping("/books/{id}")
	public void updateBook(@PathVariable("id") int bookId, @RequestBody Book book) {
		bookService.updateBook(book, bookId);

	}

}
