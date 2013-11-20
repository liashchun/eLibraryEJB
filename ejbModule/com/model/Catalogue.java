package com.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "CATALOGUES")
public class Catalogue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "catalogue", cascade = CascadeType.ALL)
	private Set<Book> books = new HashSet<Book>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return getId();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Catalogue) {
			Catalogue catalogue = (Catalogue) obj;
			return catalogue.getId() == getId();
		}
		
		return false;
	}
}
