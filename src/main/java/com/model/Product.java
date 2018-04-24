package com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javassist.SerialVersionUID;

@Service
@Component
@Entity    //Creates table directly from here if name is not specified it will take the class name as your table name
public class Product implements Serializable
{
	private static final Long SerialVersionUID=1L;//The serialVersionUID is a universal version identifier for a Serializable class. Deserialization uses this number to ensure that a loaded class corresponds exactly to a serialized object. If no match is found, then an InvalidClassException is thrown.
	
	@Id
	private int p_id;
	@Column(nullable=true)
	private String p_brand;
	@Column(nullable=true)
	private double p_price;
	@Column(nullable=true)
	private String p_discription;
	@Column(nullable=true)
	private int p_quantity;
	

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="s_id",nullable=false)
	private Supplier supplier;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="c_id",nullable=false)
	private Category category;


	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getP_brand() {
		return p_brand;
	}

	public void setP_brand(String p_brand) {
		this.p_brand = p_brand;
	}

	public double getP_price() {
		return p_price;
	}

	public void setP_price(double p_price) {
		this.p_price = p_price;
	}

	public String getP_discription() {
		return p_discription;
	}

	public void setP_discription(String p_discription) {
		this.p_discription = p_discription;
	}

	public int getP_quantity() {
		return p_quantity;
	}

	public void setP_quantity(int p_quantity) {
		this.p_quantity = p_quantity;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}
