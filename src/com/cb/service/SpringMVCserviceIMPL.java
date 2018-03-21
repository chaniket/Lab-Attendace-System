package com.cb.service;

import java.sql.SQLException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cb.bean.City;
import com.cb.bean.Country;
import com.cb.bean.LoginBean;
import com.cb.bean.PracticalInfoBean;
import com.cb.bean.RegistrationBean;
import com.cb.bean.State;
import com.cb.bean.StudentInfoBean;
import com.cb.dao.SpringMVCdao;

@Service
public class SpringMVCserviceIMPL implements SpringMVCservice {
	@Autowired
	private SpringMVCdao springMVCdao;
	@Autowired
	private SessionFactory sessionFactory;

	List<Country> countryList;
	private static Map<Integer, List<State>> stateListMap;
	private static Map<Integer, List<City>> cityListMap;
	private static Map<String, List<StudentInfoBean>> studentInfoMap;
	private static Map<String, List<PracticalInfoBean>> practicalMap;

	public SpringMVCserviceIMPL() {
		stateListMap = new HashMap<>();
		cityListMap = new HashMap<>();
		studentInfoMap = new HashMap<>();
		practicalMap = new HashMap<>();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void setSpringMVCdao(SpringMVCdao springMVCdao) {
		this.springMVCdao = springMVCdao;
	}

	@Transactional
	public LoginBean checkLoginData(LoginBean bean) throws SQLException {
		System.out.println("SpringMVCserviceIMPL.checkLoginData() "+sessionFactory.getClass().getName());
		return springMVCdao.checkLoginData(bean, sessionFactory);
	}

	@Transactional
	public int insertUserDetails(RegistrationBean bean) throws Exception {
		System.out.println("SpringMVCserviceIMPL.insertUserDetails()");
		int i = springMVCdao.insertUserDetails(bean);
		return i;
	}

	@Transactional
	public List<Country> getCountryData() {

		List<Country> list = springMVCdao.getCountryData();

		return list;
	}

	@Transactional
	public List<State> getstateData(Integer c_id) {
		synchronized (this) {
			if (!stateListMap.containsKey(c_id)) {
				System.out.println("State Key is not availabale in service");
				List<State> stateList = springMVCdao.getstateData(c_id);
				System.out.println("State List " + stateList);
				stateListMap.put(c_id, stateList);
				return stateList;
			} else {
				System.out.println("Key is availabale in Service" + stateListMap.get(c_id));
				return stateListMap.get(c_id);
			}
		}
	}

	@SuppressWarnings("static-access")
	@Override
	@Transactional
	public List<City> getCityData(int s_Id) {
		// TODO Auto-generated method stub

		synchronized (Thread.currentThread()) {
			if (!cityListMap.containsKey(s_Id)) {
				System.out.println("City Key is not availabale in Service");
				
				
				List<City> cityList = springMVCdao.getCityData(s_Id);
				
				
				this.cityListMap.put(s_Id, cityList);
				return cityList;
			} else {
				System.out.println("City Key is availabale in Service" + cityListMap.get(s_Id));
				return cityListMap.get(s_Id);
			}

		}

	}

	@SuppressWarnings("static-access")
	@Override
	@Transactional(value = TxType.SUPPORTS)
	public List<StudentInfoBean> isUserExists(String userName) throws SQLException {
		synchronized (Thread.currentThread()) {
			if (!studentInfoMap.containsKey(userName)) {
				System.out.println("isUserExists Key is not availabale in Service ");
				List<StudentInfoBean> list = springMVCdao.isUserExists(userName);
				this.studentInfoMap.put(userName, list);
				return list;
			} else {
				System.out.println("isUserExists Key is availabale in Service" + studentInfoMap.get(userName));
				return studentInfoMap.get(userName);
			} // else
		} // synchronized block
	}

	@Override
	@Transactional
	public boolean isEmailExists(String email) {
		// TODO Auto-generated method stub
		return springMVCdao.isEmailExists(email);
	}

	@SuppressWarnings("static-access")
	@Override
	@Transactional
	public List<PracticalInfoBean> getPracticalName(String className) {

		synchronized (Thread.currentThread()) {
			if (!practicalMap.containsKey(className)) {
				System.out.println("getPracticalName Key is not availabale in Service");
				List<PracticalInfoBean> list = springMVCdao.getPracticalName(className);
				this.practicalMap.put(className, list);
				return list;
			} else {
				System.out.println("getPracticalName Key is availabale in Service" + practicalMap.get(className));
				return practicalMap.get(className);
			} // else

		} // synchronized block
		// return list;
	}

	@Override
	@Transactional
	public String checkStudentData(StudentInfoBean bean, String stud_password) {
		// TODO Auto-generated method stub
		return springMVCdao.checkStudentData(bean, stud_password);
	}

	@Override
	public List<StudentInfoBean> m1() {
		return springMVCdao.m1();
	}

	@Override
	public String logoutStudent(String email) {
		// TODO Auto-generated method stub
		return springMVCdao.logoutStudent(email);
	}

	@Override
	@Transactional
	public String insertStudentAttendace(StudentInfoBean bean, String stud_password) {

		return springMVCdao.insertStudentAttendace(bean, stud_password);
	}
}
