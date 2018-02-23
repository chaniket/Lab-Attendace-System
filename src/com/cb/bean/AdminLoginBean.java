package com.cb.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="tbl_adminlogin")
public class AdminLoginBean implements Serializable {
	private static final long serialVersionUID = 7937721220299069891L;
	@Id
	private String username;
	private String password;

	public AdminLoginBean() {
	}

	public AdminLoginBean(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "AdminLoginBean [username=" + username + ", password=" + password + "]";
	}

}
