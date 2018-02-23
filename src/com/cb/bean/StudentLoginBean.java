package com.cb.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_studentLogin")
public class StudentLoginBean implements Serializable{
	private static final long serialVersionUID = 2140097085987834807L;
	@Id
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "stud_id")
	private StudentInfoBean bean;
	//@Id
	private String username;
	private String password;

	public StudentLoginBean() {
		// TODO Auto-generated constructor stub
	}

	public StudentLoginBean(StudentInfoBean bean, String username, String password) {
		super();
		this.bean = bean;
		this.username = username;
		this.password = password;
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

	@Override
	public String toString() {
		return "StudentLoginBean [bean=" + bean + ", username=" + username + ", password=" + password + "]";
	}

}
