package com.cb.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@Table(name = "tbl_country")
@Immutable
@SelectBeforeUpdate
@DynamicUpdate
public class Country implements Serializable {
	@Id
	@GenericGenerator(name = "c", strategy = "increment")
	@GeneratedValue(generator = "c")
	private int c_Id;
	private String c_Name;

	public Country() {
		// TODO Auto-generated constructor stub
	}

	public Country(int c_Id, String c_Name) {
		super();
		this.c_Id = c_Id;
		this.c_Name = c_Name;
	}

	public int getC_Id() {
		return c_Id;
	}

	public void setC_Id(int c_Id) {
		this.c_Id = c_Id;
	}

	public String getC_Name() {
		return c_Name;
	}

	public void setC_Name(String c_Name) {
		this.c_Name = c_Name;
	}

	@Override
	public String toString() {
		return "Country [c_Id=" + c_Id + ", c_Name=" + c_Name + "]";
	}
}
