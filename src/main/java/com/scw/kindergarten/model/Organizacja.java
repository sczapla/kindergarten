package com.scw.kindergarten.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "organizacja")
@SequenceGenerator(name = "organizacja_seq", initialValue = 1, allocationSize = 1)
public class Organizacja implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nazwa;
	private String nip;
	private Set<Grupa> grupy;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "organizacja_seq")
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

	public void setNazwa(String name) {
		this.nazwa = name;
	}

	@Column(name = "nip", nullable = false, length = 16)
	public String getNip() {
		return nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "organizacja")
	public Set<Grupa> getGrupy() {
		return grupy;
	}

	public void setGrupy(Set<Grupa> grupy) {
		this.grupy = grupy;
	}

}
