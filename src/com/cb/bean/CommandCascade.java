package com.cb.bean;

import java.io.Serializable;

public class CommandCascade implements Serializable {

	private RegistrationBean register;
	private Address address;
	private Country country;
	private State state;
	private City city;
//	private 

	public void setRegister(RegistrationBean register) {
		this.register = register;
	}

	public RegistrationBean getRegister() {
		return register;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "CommandCascade [address=" + address + ", register=" + register + ", country=" + country + ", state="
				+ state + ", city=" + city + "]";
	}

}
