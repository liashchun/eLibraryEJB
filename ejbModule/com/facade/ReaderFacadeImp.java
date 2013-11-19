package com.facade;

import java.util.*;
import javax.ejb.*;
import com.dao.*;
import com.model.*;

@Stateless
public class ReaderFacadeImp implements ReaderFacade {
	@EJB
	private ReaderDAO readerDAO;

	@Override
	public void save(Reader reader) {
		readerDAO.save(reader);
	}

	@Override
	public Reader update(Reader reader) {
		return readerDAO.update(reader);
	}

	@Override
	public void delete(Reader reader) {
		readerDAO.delete(reader);
	}

	@Override
	public Reader find(int entityID) {
		return readerDAO.find(entityID);
	}

	@Override
	public List<Reader> findAll() {
		return readerDAO.findAll();
	}
}
