package com.scw.kindergarten.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "typ_grupy")
@SequenceGenerator(name = "typ_grupy_seq", initialValue = 1, allocationSize = 1)
public class TypGrupy implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nazwa;
	private String opis;
	private Organizacja organizacja;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "typ_grupy_seq")
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "nazwa", nullable = false, length = 64)
	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	@Column(name = "opis", nullable = false, length = 256)
	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "organizacja_id")
	public Organizacja getOrganizacja() {
		return organizacja;
	}

	public void setOrganizacja(Organizacja organizacja) {
		this.organizacja = organizacja;
	}

}
