package com.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import com.model.Book;
import com.model.User;

@Stateless
public class BookDAO extends GenericDAO<Book> {
	private static final String anySymbol = "%";

	public BookDAO() {
		super(Book.class);
	}

	public void delete(Book book) {
		super.delete(book.getId(), Book.class);
	}
	
	public List<Book> findBooksByCriterias(String name, String authors, String isbn, 
			String keywords, String genre) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("name", forSQL(name));
		parameters.put("authors", forSQL(authors));
		parameters.put("isbn", forSQL(isbn));
		parameters.put("keywords", forSQL(keywords));
		parameters.put("genre", forSQL(genre));

		return super.findAllResults(Book.FIND_BY_CRITERIAS, parameters);
	}
	
	private String forSQL(String str) {
		if (null == str) {
			return anySymbol;
		} else {
			return String.format("%s%s%s", anySymbol, str, anySymbol);
		}
	}
}
