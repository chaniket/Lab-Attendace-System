package com.cb.service;

import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import com.cb.bean.City;
import com.cb.bean.Country;
import com.cb.bean.LoginBean;
import com.cb.bean.RegistrationBean;
import com.cb.bean.State;
import com.cb.dao.SpringMVCdao;

@Service
public class SpringMVCserviceIMPL implements SpringMVCservice {
	private SpringMVCdao springMVCdao;
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void setSpringMVCdao(SpringMVCdao springMVCdao) {
		this.springMVCdao = springMVCdao;
	}

	@Transactional
	public LoginBean checkLoginData(LoginBean bean) throws SQLException {
		System.out.println("SpringMVCserviceIMPL.checkLoginData()");
		return springMVCdao.checkLoginData(bean, sessionFactory);
	}

	@Transactional
	public int insertUserDetails(RegistrationBean bean) throws Exception {
		System.out.println("SpringMVCserviceIMPL.insertUserDetails()");
		return springMVCdao.insertUserDetails(bean);
	}

	@Transactional
	public List<Country> getCountryData() {
		return springMVCdao.getCountryData();
	}

	
	public List<State> getstateData(Integer c_id) {
		return springMVCdao.getstateData(c_id);
	}

	@Override
	public List<City> getCityData(int s_Id) {
		// TODO Auto-generated method stub
		return springMVCdao.getCityData(s_Id);
	}

}
