package com.dao;

import javax.ejb.Stateless;
import com.model.Librarian;

@Stateless
public class LibrarianDAO extends GenericDAO<Librarian> {

	public LibrarianDAO() {
		super(Librarian.class);
	}
}
