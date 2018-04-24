package com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
@Component
@Entity
@Table(name="userdetails")
public class UserDetails implements Serializable
{
	@Id
	private	int u_id;
	
	@Column(nullable=false,unique=true)
	private	String  u_email;
	
	@Column(nullable=false,unique=true)
	private String u_phone;
	
	@Column(nullable=false)
	private String u_Address;
	
	@Column(nullable=false)
	private String u_firstname;
	
	@Column(nullable=false)
	private String u_lastname;
	
	@Column(nullable=false)
	private String u_role;
	
	@Column(nullable=false)
	private String u_password;
	
	
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	public String getU_phone() {
		return u_phone;
	}
	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}
	public String getU_Address() {
		return u_Address;
	}
	public void setU_Address(String u_Address) {
		this.u_Address = u_Address;
	}
	public String getU_firstname() {
		return u_firstname;
	}
	public void setU_firstname(String u_firstname) {
		this.u_firstname = u_firstname;
	}
	public String getU_lastname() {
		return u_lastname;
	}
	public void setU_lastname(String u_lastname) {
		this.u_lastname = u_lastname;
	}
	public String getU_role() {
		return u_role;
	}
	public void setU_role(String u_role) {
		this.u_role = u_role;
	}
	public String getU_password() {
		return u_password;
	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
	

}
