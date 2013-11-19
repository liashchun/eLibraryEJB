package com.dao;

import javax.ejb.Stateless;

import com.model.Librarian;

@Stateless
public class LibrarianDAO extends GenericDAO<Librarian> {

	public LibrarianDAO() {
		super(Librarian.class);
	}

	public void delete(Librarian librarian) {
		super.delete(librarian.getId(), Librarian.class);
	}
}
