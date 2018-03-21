package com.cb.delegete;

import java.sql.SQLException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextListener;

import com.cb.bean.City;
import com.cb.bean.Country;
import com.cb.bean.LoginBean;
import com.cb.bean.PracticalInfoBean;
import com.cb.bean.RegistrationBean;
import com.cb.bean.State;
import com.cb.bean.StudentInfoBean;
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

	public List<StudentInfoBean> isUserExists(String userName) throws SQLException {
	//System.out.println("M1 Dele "+serviceIMPL.m1());
		List<StudentInfoBean> studentInfoBeans=	serviceIMPL.isUserExists(userName);
		System.out.println("Delegate student info..."+studentInfoBeans);
		return studentInfoBeans;
	}

	public boolean isEmailExists(String email) {
		// TODO Auto-generated method stub
		return serviceIMPL.isEmailExists(email);
	}

	public List<PracticalInfoBean> getPracticalName(String className) {
		// TODO Auto-generated method stub
		return serviceIMPL.getPracticalName(className);
	}

	public String checkStudentData(StudentInfoBean bean, String stud_password) {
		// TODO Auto-generated method stub
		return serviceIMPL.checkStudentData(bean, stud_password);
	}

	public String logoutStudent(String email) {
		// TODO Auto-generated method stub
		return serviceIMPL.logoutStudent(email);
	}

	public String insertStudentAttendace(StudentInfoBean bean, String stud_password) {
		// TODO Auto-generated method stub
		return serviceIMPL.insertStudentAttendace(bean, stud_password);
	}

}
