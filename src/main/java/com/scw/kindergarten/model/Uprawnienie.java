package com.scw.kindergarten.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "uprawnienie")
public class Uprawnienie implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nazwaUprawnienia;
	private String komponent;

	@Id
	@Column(name = "nazwa_uprawnienia", nullable = false, length = 64, unique = true)
	public String getNazwaUprawnienia() {
		return this.nazwaUprawnienia;
	}

	public void setNazwaUprawnienia(String nazwaUprawnienia) {
		this.nazwaUprawnienia = nazwaUprawnienia;
	}

	@Column(name = "komponent", length = 64)
	public String getKomponent() {
		return this.komponent;
	}

	public void setKomponent(String komponent) {
		this.komponent = komponent;
	}

}
