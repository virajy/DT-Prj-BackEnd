package com.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
@Entity
@Table
public class Category implements Serializable {

	@Id
	private int c_id;
	@Column(nullable=false)
	private String c_name;
	@Column(nullable=false)
	private String c_discription;

	@OneToMany(targetEntity = Product.class, fetch = FetchType.EAGER, mappedBy = "category") // While
																								// mapping
																								// two
																								// entities
																								// we
																								// can
																								// define
																								// the
																								// FetchType
																								// for
																								// the
																								// mapping
																								// property.
																								// ...
																								// If
																								// we
																								// set
																								// FetchType.EAGER,
																								// then
																								// collection
																								// will
																								// be
																								// loaded
																								// at
																								// the
																								// same
																								// time
																								// when
																								// the
																								// parent
																								// entity
																								// is
																								// loaded.
																								// FetchType
																								// is
																								// useful
																								// for
																								// the
																								// performance
																								// of
																								// system.
	private Set<Product> products = new HashSet<Product>(0);

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_discription() {
		return c_discription;
	}

	public void setC_discription(String c_discription) {
		this.c_discription = c_discription;
	}

}
