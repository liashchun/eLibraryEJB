package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.*;

@Entity
@Table(name = "ABONEMENTS")
public class Abonement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private BigDecimal balance;

	public Abonement() {
	}

	@Override
	public int hashCode() {
		return getId();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Abonement) {
			Abonement abonement = (Abonement) obj;
			return abonement.getId() == getId();
		}
		return false;
	}
}
