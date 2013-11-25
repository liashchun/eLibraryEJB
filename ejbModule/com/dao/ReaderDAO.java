package com.dao;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;

import com.model.Reader;
import com.model.User;

@Stateless
public class ReaderDAO extends GenericDAO<Reader> {

	public ReaderDAO() {
		super(Reader.class);
	}
	
	public void delete(Reader reader) {
		super.delete(reader.getId(), Reader.class);
	}
	
	public Reader findReaderByEmail(String email) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("email", email);

		return super.findOneResult(Reader.FIND_BY_EMAIL, parameters);
	}
}
