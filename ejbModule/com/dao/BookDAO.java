package com.dao;

import javax.ejb.Stateless;

import com.model.Book;

@Stateless
public class BookDAO extends GenericDAO<Book> {

	public BookDAO() {
		super(Book.class);
	}

	public void delete(Book book) {
		super.delete(book.getId(), Book.class);
	}
}
