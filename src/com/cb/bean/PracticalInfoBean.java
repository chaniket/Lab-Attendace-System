package com.cb.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="practicalInfo")
public class PracticalInfoBean implements Serializable {
	private static final long serialVersionUID = 4460603615167216127L;
	@Id
	private String className;
	private String pracOne;
	private String pracTwo;
	private String pracThree;
	private String pracFour;
	private String pracFive;

	public PracticalInfoBean() {
		// TODO Auto-generated constructor stub
	}

	public PracticalInfoBean(String className, String pracOne, String pracTwo, String pracThree, String pracFour,
			String pracFive) {
		super();
		this.className = className;
		this.pracOne = pracOne;
		this.pracTwo = pracTwo;
		this.pracThree = pracThree;
		this.pracFour = pracFour;
		this.pracFive = pracFive;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getPracOne() {
		return pracOne;
	}

	public void setPracOne(String pracOne) {
		this.pracOne = pracOne;
	}

	public String getPracTwo() {
		return pracTwo;
	}

	public void setPracTwo(String pracTwo) {
		this.pracTwo = pracTwo;
	}

	public String getPracThree() {
		return pracThree;
	}

	public void setPracThree(String pracThree) {
		this.pracThree = pracThree;
	}

	public String getPracFour() {
		return pracFour;
	}

	public void setPracFour(String pracFour) {
		this.pracFour = pracFour;
	}

	public String getPracFive() {
		return pracFive;
	}

	public void setPracFive(String pracFive) {
		this.pracFive = pracFive;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "PracticalInfoBean [className=" + className + ", pracOne=" + pracOne + ", pracTwo=" + pracTwo
				+ ", pracThree=" + pracThree + ", pracFour=" + pracFour + ", pracFive=" + pracFive + "]";
	}

}
