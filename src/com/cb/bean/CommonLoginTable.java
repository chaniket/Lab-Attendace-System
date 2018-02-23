package com.cb.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="tbl_common_login")
public class CommonLoginTable implements Serializable {
	private static final long serialVersionUID = -7676201896590447091L;
	@OneToOne
	@JoinColumn(name = "stud_id")
	private StudentInfoBean bean;
	@Id
	private String username;
	private String password;
	private String userType;

	public CommonLoginTable() {
		
	}

	public CommonLoginTable(StudentInfoBean bean, String username, String password, String userType) {
		super();
		this.bean = bean;
		this.username = username;
		this.password = password;
		this.userType = userType;
	}

	public StudentInfoBean getBean() {
		return bean;
	}

	public void setBean(StudentInfoBean bean) {
		this.bean = bean;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "CommonLoginTable [bean=" + bean + ", username=" + username + ", password=" + password + ", userType="
				+ userType + "]";
	}

}
