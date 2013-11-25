package com.facade;

import java.util.*;

import javax.ejb.*;

import com.model.*;

@Local
public interface ReaderFacade {
	void save(Reader reader);

	Reader update(Reader reader);

	void delete(Reader reader);

	Reader find(int entityID);

	List<Reader> findAll();
	
	public Reader findReaderByEmail(String email);
}
