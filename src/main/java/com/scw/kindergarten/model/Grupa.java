package com.scw.kindergarten.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "grupa")
@SequenceGenerator(name = "grupa_seq", initialValue = 1, allocationSize = 1)
public class Grupa {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nazwa;
	private String opis;
	private TypGrupy typ;
	private Organizacja organizacja;
	private Set<Uzytkownik> uzytkownicy;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "grupa_seq")
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "typ_id")
	public TypGrupy getTyp() {
		return typ;
	}

	public void setTyp(TypGrupy typ) {
		this.typ = typ;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "organizacja_id")
	public Organizacja getOrganizacja() {
		return organizacja;
	}

	public void setOrganizacja(Organizacja organizacja) {
		this.organizacja = organizacja;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "grupa")
	public Set<Uzytkownik> getUzytkownicy() {
		return uzytkownicy;
	}

	public void setUzytkownicy(Set<Uzytkownik> uzytkownicy) {
		this.uzytkownicy = uzytkownicy;
	}

}
