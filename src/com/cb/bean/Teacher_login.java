package com.cb.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_teacher_login")
public class Teacher_login implements Serializable {
	private static final long serialVersionUID = -8670741408823199975L;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "staff_id")
	private Teacher_Info stud_id;
	@Id
	private String username;
	private String password;

	public Teacher_login() {
		
	}

	public Teacher_login(Teacher_Info stud_id, String username, String password) {
		super();
		this.stud_id = stud_id;
		this.username = username;
		this.password = password;
	}

	public Teacher_Info getStud_id() {
		return stud_id;
	}

	public void setStud_id(Teacher_Info stud_id) {
		this.stud_id = stud_id;
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
		return "Teacher_login [stud_id=" + stud_id + ", username=" + username + ", password=" + password + "]";
	}

}
