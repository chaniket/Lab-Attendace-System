package com.cb.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.SelectBeforeUpdate;;

@Entity
@Table(name="tbl_city")
@Immutable
@SelectBeforeUpdate
@DynamicUpdate
@DynamicInsert
public class City implements Serializable{
	@Id
	@GenericGenerator(name="c",strategy="increment")
	@GeneratedValue(generator="c")
	private int city_Id;
	private String city_Name;
	@OneToOne//(fetch=FetchType.LAZY,cascade=CascadeType.DETACH)
	@JoinColumn(name = "s_Id")
	private State state;

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public int getCity_Id() {
		return city_Id;
	}

	public void setCity_Id(int city_Id) {
		this.city_Id = city_Id;
	}

	public String getCity_Name() {
		return city_Name;
	}

	public void setCity_Name(String city_Name) {
		this.city_Name = city_Name;
	}

	@Override
	public String toString() {
		return "City [city_Id=" + city_Id + ", city_Name=" + city_Name + ", state=" + state + "]";
	}

}
