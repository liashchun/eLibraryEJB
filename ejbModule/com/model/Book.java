package com.model;

import javax.persistence.*;

import java.math.*;
import java.util.*;
import java.io.*;

@Entity
@Table(name = "BOOK")
@NamedQueries({ 
	@NamedQuery(name = "Book.findBookByCriterias", 
				query = "SELECT b FROM Book b WHERE b.name LIKE :name AND" +
								" b.authors LIKE :authors AND" + 
								" b.keywords LIKE :keywords AND" +
								" b.isbn LIKE :isbn AND" + 
								" b.genre LIKE :genre") 
})
public class Book implements Serializable {
	public static final String FIND_BY_CRITERIAS = "Book.findBookByCriterias";
	private static final long serialVersionUID = -3344824610577302398L;

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
	private Set<Order> orders = new HashSet<Order>(); 
	
	private String name;
	private String authors;
	private String isbn;
	private BigDecimal price;
	private Integer amount;
	private String keywords;
	private String genre;
	private String description;
	
	public Book() {
	}
	
	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public String getISBN() {
		return isbn;
	}

	public void setISBN(String iSBN) {
		isbn = iSBN;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
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
