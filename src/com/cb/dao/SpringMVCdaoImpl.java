package com.cb.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.cb.bean.City;
import com.cb.bean.Country;
import com.cb.bean.LoginBean;
import com.cb.bean.RegistrationBean;
import com.cb.bean.State;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

public class SpringMVCdaoImpl implements SpringMVCdao {
	SessionFactory sessionFactory;
	HibernateTemplate hibernateTemplate;
	JdbcTemplate jt;
	Session session;
	List<Country> countryList;
	Map<Integer, List<State>> stateListMap;
	Map<Integer, List<City>> cityListMap;

	public SpringMVCdaoImpl() {
		System.out.println("SpringMVCdaoImpl.SpringMVCdaoImpl()");
		// session = sessionFactory.openSession();
		stateListMap = new HashMap<>();
		cityListMap = new HashMap<>();
	}

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unused")
	public LoginBean checkLoginData(LoginBean bean, SessionFactory sessionFactory) throws SQLException {
		System.out.println("SpringMVCdaoImpl.checkLoginData()");
		Session session = sessionFactory.openSession();
		if (sessionFactory == null)
			System.out.println("SpringMVCdaoImpl.checkLoginData() SessionFactory in not injected");
		Transaction tx = session.beginTransaction();

		// without this is not working
		SQLQuery query = session.createSQLQuery("select * from login where username=?").addEntity(LoginBean.class);
		query.setString(0, bean.getUsername());
		List<LoginBean> list = query.list();
		System.out.println("list " + list);
		LoginBean bean2 = (LoginBean) session.byNaturalId(LoginBean.class).using("username", bean.getUsername()).load();
		System.out.println(" checking " + bean2);

		/*
		 * LoginBean bean2 = (LoginBean)
		 * session.bySimpleNaturalId(LoginBean.class).load(bean.getUsername());
		 * System.out.println("bean2 " + bean2);
		 */ if (bean2 != null) {
			if (bean.getUsername().equals(((LoginBean) bean2).getUsername())
					&& bean.getPassword().equals(((LoginBean) bean2).getPassword())) {
				bean.setUser_id(((LoginBean) bean2).getUser_id());
				bean.setUserType(((LoginBean) bean2).getUserType());
				bean = (LoginBean) bean2;
				System.out.println("valid credintinals");
				return (LoginBean) bean2;
			}
		} else {
			throw new SQLException("invalid credintinals");
		}
		tx.commit();
		return bean;

	}

	@SuppressWarnings("unused")
	public int insertUserDetails(RegistrationBean bean) throws Exception {
		int i = 0;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Serializable obj1 = session.save(bean);
		LoginBean bean2 = new LoginBean();
		bean2.setUser_id(bean);
		bean2.setUsername(bean.getEmail());
		bean2.setPassword(bean.getPassword());
		bean2.setUserType("User");
		Serializable obj2 = session.save(bean2);
		tx.commit();
		if (obj1 != null || obj1 != "0" || !bean.equals("0") && obj2 != null) {
			return 1;
		} else {
			return i;
		}

	}

	public List<Country> getCountryData() {
		Session session = sessionFactory.openSession();
		SQLQuery query = session.createSQLQuery("select * from tbl_country").addEntity(Country.class);
		countryList = query.list();
		countryList.add(0, new Country(0, "selected"));
		session.clear();
		return countryList;
	}

	public List<State> getstateData(Integer c_id) {
		Session session = sessionFactory.openSession();
		SQLQuery query = session.createSQLQuery("select * from tbl_state where c_id=?").addEntity(State.class);
		query.setInteger(0, c_id);

		synchronized (this) {
			if (!stateListMap.containsKey(c_id)) {
				System.out.println("State Key is not availabale");
				List<State> stateList = query.list();
				System.out.println("State List " + stateList);
				stateListMap.put(c_id, stateList);
				return stateList;
			} else {
				System.out.println("Key is availabale " + stateListMap.get(c_id));
				return stateListMap.get(c_id);
			}
		}

	}

	@Override
	public List<City> getCityData(int s_Id) {
		Session session = sessionFactory.openSession();
		SQLQuery query = session.createSQLQuery("select * from tbl_city where s_Id=?").addEntity(City.class);
		query.setInteger(0, s_Id);
		
		synchronized (Thread.currentThread()) {
			if (!cityListMap.containsKey(s_Id)) {
				System.out.println("City Key is not availabale");
				List<City> cityList = query.list();
				this.cityListMap.put(s_Id, cityList);
				return cityList;
			} else {
				System.out.println("City Key is availabale " + cityListMap.get(s_Id));
				return cityListMap.get(s_Id);
			}

		}
	}

}
