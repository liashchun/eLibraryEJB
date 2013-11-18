package com.dao;

import javax.ejb.Stateless;
import com.model.Abonement;

@Stateless
public class AbonementDAO extends GenericDAO<Abonement> {

	public AbonementDAO() {
		super(Abonement.class);
	}
}
