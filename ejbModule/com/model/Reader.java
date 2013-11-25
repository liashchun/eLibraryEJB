package com.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "READER")
@NamedQueries({ 
	@NamedQuery(name = "Reader.findReaderByEmail", 
				query = "SELECT u FROM Reader u WHERE u.email = :email") 
})
public class Reader {
	public static final String FIND_BY_EMAIL = "Reader.findReaderByEmail";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String balance;
	private String email;
	
	public String getPassword() {
		return balance;
	}

	public void setPassword(String password) {
		this.balance = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "reader", cascade = CascadeType.ALL)
	private Set<Order> orders = new HashSet<Order>();
	
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
		if (obj instanceof Reader) {
			Reader reader = (Reader) obj;
			return reader.getId() == getId();
		}
		return false;
	}
}
