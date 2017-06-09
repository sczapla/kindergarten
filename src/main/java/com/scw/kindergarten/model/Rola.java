package com.scw.kindergarten.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "rola", uniqueConstraints = @UniqueConstraint(columnNames = "nazwa_roli"))
public class Rola implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nazwaRoli;
	private Set<Uprawnienie> uprawnienie = new HashSet<>(0);

	@Id
	@Column(name = "nazwa_roli", unique = true, nullable = false, length = 64)
	public String getNazwaRoli() {
		return this.nazwaRoli;
	}

	public void setNazwaRoli(String nazwaRoli) {
		this.nazwaRoli = nazwaRoli;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "uprawnienie_roli", joinColumns = { @JoinColumn(name = "id_roli") }, inverseJoinColumns = {
			@JoinColumn(name = "id_uprawnienia") })
	public Set<Uprawnienie> getUprawnienie() {
		return uprawnienie;
	}

	public void setUprawnienie(Set<Uprawnienie> uprawnienie) {
		this.uprawnienie = uprawnienie;
	}

}
