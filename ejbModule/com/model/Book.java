package com.model;

import javax.persistence.*;
import java.math.*;
import java.util.*;
import java.io.*;

@Entity
@Table(name = "BOOKS")
public class Book implements Serializable {
	private static final long serialVersionUID = -3344824610577302398L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy="books")
	private Set<Order> orders = new HashSet<Order>(); 
	
	private String name;
	private String authors;
	private String ISBN;
	private BigDecimal price;
	private int amount;
	private String keywords;
	private String genre;
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "CATALOGUE_ID", nullable = false)
	private Catalogue catalogue;
	
	public Book() {
	}
	
	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

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
		if (obj instanceof Book) {
			Book book = (Book) obj;
			return book.getId() == getId();
		}
		return false;
	}
}
