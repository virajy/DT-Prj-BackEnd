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
public class Supplier implements Serializable {
	@Id
	private int s_id;
	@Column(nullable = false)
	private String s_name;
	@Column(nullable = false)
	private String s_email;
	@Column(nullable = false)
	private String s_phone;
	@Column(nullable = false)
	private int s_stateid;
	@Column(nullable = false)
	private int s_pincode;

	@OneToMany(targetEntity = Product.class, fetch = FetchType.EAGER, mappedBy = "supplier")
	private Set<Product> products = new HashSet<Product>(0);

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getS_email() {
		return s_email;
	}

	public void setS_email(String s_email) {
		this.s_email = s_email;
	}

	public String getS_phone() {
		return s_phone;
	}

	public void setS_phone(String string) {
		this.s_phone = string;
	}

	public int getS_stateid() {
		return s_stateid;
	}

	public void setS_stateid(int s_stateid) {
		this.s_stateid = s_stateid;
	}

	public int getS_pincode() {
		return s_pincode;
	}

	public void setS_pincode(int s_pincode) {
		this.s_pincode = s_pincode;
	}

}
