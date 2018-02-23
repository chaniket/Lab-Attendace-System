package com.cb.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name="tbl_state")
@Immutable
public class State implements Serializable{
	@Id
	@GenericGenerator(name = "c", strategy = "increment")
	@GeneratedValue(generator = "c")
	private int s_Id;
	private String s_Name;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "c_Id")
	private Country country;

	public void setCountry(Country country) {
		this.country = country;
	}

	public Country getCountry() {
		return country;
	}

	public int getS_ID() {
		return s_Id;
	}

	public void setS_ID(int s_ID) {
		this.s_Id = s_ID;
	}

	public String getS_Name() {
		return s_Name;
	}

	public void setS_Name(String s_Name) {
		this.s_Name = s_Name;
	}

	@Override
	public String toString() {
		return "State [s_Id=" + s_Id + ", s_Name=" + s_Name + ", country=" + country + "]";
	}

}
