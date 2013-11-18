package com.dao;

import javax.ejb.Stateless;
import com.model.Reader;

@Stateless
public class ReaderDAO extends GenericDAO<Reader> {

	public ReaderDAO() {
		super(Reader.class);
	}
}
