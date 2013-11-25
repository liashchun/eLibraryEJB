package com.facade;

import javax.ejb.*;
import com.dao.*;


@Stateless
public class LibrarianFacadeImp implements LibrarianFacade {
	@EJB 
	private LibrarianDAO librarianDAO;	
}
