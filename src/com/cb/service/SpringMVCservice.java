package com.cb.service;

import java.sql.SQLException;
import java.util.List;

import com.cb.bean.City;
import com.cb.bean.Country;
import com.cb.bean.LoginBean;
import com.cb.bean.RegistrationBean;
import com.cb.bean.State;

public interface SpringMVCservice {
	public LoginBean checkLoginData(LoginBean bean) throws SQLException;

	public int insertUserDetails(RegistrationBean bean) throws Exception;

	public List<Country> getCountryData();

	public List<State> getstateData(Integer c_id);

	public List<City> getCityData(int s_Id);
}