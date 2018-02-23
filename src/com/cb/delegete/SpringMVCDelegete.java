package com.cb.delegete;

import java.sql.SQLException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextListener;

import com.cb.bean.City;
import com.cb.bean.Country;
import com.cb.bean.LoginBean;
import com.cb.bean.RegistrationBean;
import com.cb.bean.State;
import com.cb.service.SpringMVCservice;

public class SpringMVCDelegete {
	@Autowired
	SpringMVCservice serviceIMPL;

	public LoginBean checkLoginData(LoginBean bean) throws SQLException {
		System.out.println("SpringMVCDelegete.checkLoginData()");
		return serviceIMPL.checkLoginData(bean);
	}

	public int insertUserDetails(RegistrationBean bean) throws Exception {
		System.out.println("SpringMVCDelegete.insertUserDetails()");
		return serviceIMPL.insertUserDetails(bean);
	}

	public List<Country> getCountryData() {
		
		return serviceIMPL.getCountryData();
	}

	public List<State> getstateData(Integer c_id) {

		return serviceIMPL.getstateData(c_id);
	}

	public List<City> getCityData(int s_Id) {
		// TODO Auto-generated method stub
		return serviceIMPL.getCityData(s_Id);
	}
}
