package com.cb.bean;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@Table(name="tbl_studentInfo")
//@DynamicInsert
@SelectBeforeUpdate
@DynamicUpdate

public class StudentInfoBean implements Serializable{
	
	private static final long serialVersionUID = -108766680433591186L;
	@Id
	@GenericGenerator(name="incre",strategy="increment")
	@GeneratedValue(generator="incre")
	private Integer stud_id;
	private String first_name;
	private String last_name;
	private Long mobile_no;
	private String className;
	@NaturalId
	private String email;

	public StudentInfoBean() {
		// TODO Auto-generated constructor stub
	}

	public StudentInfoBean(String first_name, String last_name, Long mobile_no, String className,
			String email) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.mobile_no = mobile_no;
		this.className = className;
		this.email = email;
	}

	public Integer getStud_id() {
		return stud_id;

	}

	public void setStud_id(Integer stud_id) {
		this.stud_id = stud_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Long getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(Long mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "StudentInfoBean [stud_id=" + stud_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", mobile_no=" + mobile_no + ", className=" + className + ", email=" + email + "]";
	}
}
