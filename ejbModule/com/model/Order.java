package com.model;

import javax.persistence.*;

import java.sql.Date;
import java.util.*;

@Entity
@Table(name = "ORDERS")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable
	(name = "ORDER_has_BOOK",
	joinColumns = 
		{@JoinColumn(name="ORDER_ID")},
	inverseJoinColumns=
		{@JoinColumn(name="BOOK_ID")}
	)
	private Set<Book> books;	
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "READER_ID", nullable = false)
	private Reader reader;
	
	private Date date;
	private String status;
	private String type;
	
	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Order() {
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return getId();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Order) {
			Order order = (Order) obj;
			return order.getId() == getId();
		}
		
		return false;
	}
}
