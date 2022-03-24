package com.sandip.firstrest.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * Rename Table Name - Use @Table(name = "new-table-name") annotation above entity class
 * 
 * Whenever Table created, we need a Primary Key
 * Primary Key -- Use @Id annotation with primary key attribute
 * For Setting it to auto-increment, use @GeneratedValue(strategy=.....)
 * 
 * Change Column name database -- @Columa(name="....") annotation above attribute
 * 
 * CONFIGURATION SHOULD BE DONE CORRECTLY
 */

@Entity
@Table(name = "books")
public class Book {
	private String author;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "book_id")
	private int id;

	private String title;

	public Book() {
		super();
	}

	public Book(int id, String title, String author) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + "]";
	}

}
