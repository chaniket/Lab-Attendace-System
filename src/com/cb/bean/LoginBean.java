package com.cb.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@Table(name = "login")
@SelectBeforeUpdate
@DynamicUpdate
public class LoginBean implements Serializable {
	@Id
	@OneToOne//(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private RegistrationBean User_id;
	@NaturalId
	private String username;
	// @Column(unique = false, nullable = false, length = 40)
	private String password;
	private String userType;

	public LoginBean() {

	}

	public LoginBean(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public LoginBean(RegistrationBean user_id, String username, String password, String userType) {
		super();
		User_id = user_id;
		this.username = username;
		this.password = password;
		this.userType = userType;
	}

	public RegistrationBean getUser_id() {
		return User_id;
	}

	public void setUser_id(RegistrationBean user_id) {
		User_id = user_id;
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

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "LoginBean [User_id=" + User_id + ", username=" + username + ", password=" + password + ", userType="
				+ userType + "]";
	}

}
