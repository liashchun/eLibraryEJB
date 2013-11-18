package com.dao;

import javax.ejb.Stateless;
import com.model.Catalogue;

@Stateless
public class CatalogueDAO extends GenericDAO<Catalogue> {

	public CatalogueDAO() {
		super(Catalogue.class);
	}
}
