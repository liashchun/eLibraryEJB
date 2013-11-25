package com.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.BookDAO;
import com.model.Book;

@Stateless
public class BookFacadeImp implements BookFacade {

	@EJB
	private BookDAO bookDAO;

	@Override
	public void save(Book book) {
		isBookWithAllData(book);

		bookDAO.save(book);
	}

	@Override
	public Book update(Book book) {
		return bookDAO.update(book);
	}

	@Override
	public void delete(Book book) {
		bookDAO.delete(book);
	}

	@Override
	public Book find(int entityID) {
		return bookDAO.find(entityID);
	}

	@Override
	public List<Book> findAll() {
		return bookDAO.findAll();
	}
	
	@Override
	public List<Book> findByCriterias(String name, String authors, String isbn, 
			String keywords, String genre) {
		return bookDAO.findBooksByCriterias(name, authors, isbn, keywords, genre);
	}

	private void isBookWithAllData(Book book) {
		boolean hasError = false;

		if (book == null) {
			hasError = true;
		}

		if (book.getName() == null || "".equals(book.getName().trim())) {
			hasError = true;
		}

		if (hasError) {
			throw new IllegalArgumentException(String.format("%s%s",
					"The book is missing data. ",
					"Check the attributes, they should have value."));
		}
	}
}