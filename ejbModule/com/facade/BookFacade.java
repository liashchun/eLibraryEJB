package com.facade;

import java.util.List;
import javax.ejb.Local;
import com.model.Book;

@Local
public interface BookFacade {

	public abstract void save(Book book);

	public abstract Book update(Book book);

	public abstract void delete(Book book);

	public abstract Book find(int entityID);

	public abstract List<Book> findAll();
	
	List<Book> findByCriterias(String name, String authors, String isbn, 
			String keywords, String genre);
}