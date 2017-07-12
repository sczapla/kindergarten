package com.scw.kindergarten.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "uzytkownik")
public class Uzytkownik implements Serializable {
	private static final long serialVersionUID = 1L;

	private String haslo;
	private String imie;
	private String nazwisko;
	private String email;
	private String opis;
	private Boolean odblokowany;
	private Date czasRejestracji;
	private Organizacja organizacja;
	private Grupa grupa;
	private Set<Rola> rola = new HashSet<>(0);

	@Column(name = "haslo", nullable = false, length = 64)
	public String getHaslo() {
		return this.haslo;
	}

	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}

	@Column(name = "imie", nullable = false, length = 64)
	public String getImie() {
		return this.imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	@Id
	@Column(name = "email", nullable = false, unique = true, length = 64)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "opis", length = 512)
	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	@Column(name = "odblokowany")
	public Boolean getOdblokowany() {
		return this.odblokowany;
	}

	public void setOdblokowany(Boolean odblokowany) {
		this.odblokowany = odblokowany;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "czas_rejestracji", nullable = false)
	public Date getCzasRejestracji() {
		return this.czasRejestracji;
	}

	public void setCzasRejestracji(Date czasRejestracji) {
		this.czasRejestracji = czasRejestracji;
	}

	@Column(name = "nazwisko", length = 64)
	public String getNazwisko() {
		return this.nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "organizacja_id")
	public Organizacja getOrganizacja() {
		return organizacja;
	}

	public void setOrganizacja(Organizacja organizacja) {
		this.organizacja = organizacja;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "grupa_id")
	public Grupa getGrupa() {
		return grupa;
	}

	public void setGrupa(Grupa grupa) {
		this.grupa = grupa;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "rola_uzytkownika", joinColumns = { @JoinColumn(name = "id_uzytkownika") }, inverseJoinColumns = {
			@JoinColumn(name = "id_roli") })
	public Set<Rola> getRola() {
		return rola;
	}

	public void setRola(Set<Rola> rola) {
		this.rola = rola;
	}

}
