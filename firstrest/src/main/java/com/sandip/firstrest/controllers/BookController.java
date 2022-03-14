package com.sandip.firstrest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sandip.firstrest.entities.Book;
import com.sandip.firstrest.services.BookService;

/*For REST Api, we have RESTController. @ResponseBody not needed*/

@RestController
public class BookController {

	/**
	 * @see Autowiring
	 */
	@Autowired
	private BookService bookService;

	/*
	 * For url handler method, write with following annotations and Map the Method
	 * and API Endpoint
	 * 
	 * @RequestMapping(value = "/books", method = RequestMethod.GET)
	 * 
	 * @ResponseBody Usually returns view. To return as string, @ResponseBody
	 * 
	 * @RestController - Automatically converted to JSON. Jackson automatic turned
	 * on. Is automatic
	 */
	@GetMapping("/books")
	public List<Book> getBooks(@RequestParam(required = false) Integer id) {
		if (id == null) {

			return bookService.getAllBooks();
		}
		return List.of(bookService.getBookById(id));
	}

	/*
	 * Get single book Path variable add
	 *
	 *
	 * @GetMapping("/books") public Book getBookById(@RequestParam int id) { return
	 * bookService.getBookById(id);
	 * 
	 * }
	 */

}
