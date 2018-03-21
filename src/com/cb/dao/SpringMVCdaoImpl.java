package com.cb.dao;

import java.io.Serializable;

import java.net.URL;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.spi.Configurator;
import org.apache.log4j.spi.LoggerRepository;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.cb.bean.City;
import com.cb.bean.Country;
import com.cb.bean.DailyRecordBean;
import com.cb.bean.LoginBean;
import com.cb.bean.PracticalInfoBean;
import com.cb.bean.RegistrationBean;
import com.cb.bean.State;
import com.cb.bean.StudentDayLogBean;
import com.cb.bean.StudentInfoBean;
import com.cb.bean.StudentLoginBean;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

@Repository
public class SpringMVCdaoImpl implements SpringMVCdao {
	private static Logger logger = Logger.getLogger(SpringMVCdaoImpl.class);
	@Autowired
	SessionFactory sessionFactory;
//	@Autowired
	HibernateTemplate hibernateTemplate;
	@Autowired
	JdbcTemplate jt;
	
	@SuppressWarnings("unused")
	private volatile Session session;
	List<Country> countryList;
	Map<Integer, List<State>> stateListMap;
	Map<Integer, List<City>> cityListMap;
	Map<String, StudentInfoBean> studentMap;
	Map<String, PracticalInfoBean> practicalMap;

	public SpringMVCdaoImpl() {
		// PropertyConfigurator.configure("com/cb/dao/log4j.properties");
		logger.info("SpringMVCdaoImpl.SpringMVCdaoImpl()");
		System.out.println("SpringMVCdaoImpl.SpringMVCdaoImpl()");
		// session = sessionFactory.openSession();
		stateListMap = new HashMap<>();
		cityListMap = new HashMap<>();
		studentMap = new HashMap<>();
		practicalMap = new HashMap<>();
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
		//countryList.add(0, new Country(0, "selected"));
		session.close();
		return countryList;
	}

	public List<State> getstateData(Integer c_id) {
		Session session = sessionFactory.openSession();
		SQLQuery query = session.createSQLQuery("select * from tbl_state where c_id=?").addEntity(State.class);
		query.setInteger(0, c_id);
		List<State> stateList = query.list();
		session.close();
		return stateList;
		/*
		 * synchronized (this) { if (!stateListMap.containsKey(c_id)) {
		 * System.out.println("State Key is not availabale");
		 * System.out.println("State List " + stateList); stateListMap.put(c_id,
		 * stateList); return stateList; } else {
		 * System.out.println("Key is availabale " + stateListMap.get(c_id));
		 * return stateListMap.get(c_id); } }
		 */
	}

	@Override
	public List<City> getCityData(int s_Id) {
		Session session = sessionFactory.openSession();
		SQLQuery query = session.createSQLQuery("select * from tbl_city where s_Id=?").addEntity(City.class);
		query.setInteger(0, s_Id);
		List<City> cityList = query.list();
		session.close();
		return cityList;
	}

	@Override
	public boolean isEmailExists(String email) {
		System.out.println("SpringMVCdaoImpl.isEmailExists()");
		Session session = sessionFactory.openSession();
		SQLQuery query = session.createSQLQuery("select * from tbl_studentinfo where email=?")
				.addEntity(StudentInfoBean.class);
		query.setString(0, email);
		List<StudentInfoBean> list = query.list();
		System.out.println("list " + list);
		StudentInfoBean bean = (StudentInfoBean) session.byNaturalId(StudentInfoBean.class).using("email", email)
				.load();
		System.out.println("if null user not exists :" + bean);
		if (bean == null) {
			return false;
		}
		return true;
	}

	@Override
	// @Transactional(value=TxType.SUPPORTS)
	public List<StudentInfoBean> isUserExists(String email) throws SQLException {
		System.out.println("SpringMVCdaoImpl.isUserExists()");
		Session session = sessionFactory.openSession();
		SQLQuery query = session.createSQLQuery("select * from tbl_studentinfo where email=?")
				.addEntity(StudentInfoBean.class);
		query.setString(0, email);
		List<StudentInfoBean> list = query.list();
		session.close();
		if (list.isEmpty()) {
			System.out.println(list.isEmpty());
			throw new SQLException("Student data is not exists");
		}
		return list;

	}

	@Override
	public List<PracticalInfoBean> getPracticalName(String className) {
		System.out.println("SpringMVCdaoImpl.getPracticalName() " + className);
		Session session = sessionFactory.openSession();
		SQLQuery query = session.createSQLQuery("SELECT * FROM practicalinfo WHERE className=?")
				.addEntity(PracticalInfoBean.class);
		query.setString(0, className);
		List<PracticalInfoBean> list = query.list();
		session.close();
		return list;
	}

	@Override
	public String insertStudentAttendace(StudentInfoBean infoBean, String stud_password) {
		System.out.println("SpringMVCdaoImpl.insertStudentAttendace()");
		String successMsg = "";
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		StudentLoginBean loginBean = new StudentLoginBean(infoBean, infoBean.getEmail(), stud_password);
		DailyRecordBean dailyRecordBean = new DailyRecordBean(infoBean);
		StudentDayLogBean dayLogBean = new StudentDayLogBean(infoBean, infoBean.getLast_name(), infoBean.getClassName(),
				new Date(), new Date(), null);

		// session.saveOrUpdate(infoBean);
		Map<String, String> map = new HashMap<>();
		map.put("password", stud_password);
		map.put("username", infoBean.getEmail());
		StudentLoginBean logon = studentLoginCommonMethod(map, session);

		System.out.println("logon\n" + logon);
		if (logon == null) {
			successMsg = "invalid login credentials";
		} else {
			Serializable s2 = session.save(dailyRecordBean);
			Serializable s3 = session.save(dayLogBean);
			System.out.println(s2 + " " + s3);
			successMsg = "you are logged in Successfully..!! ";
		}
		try {
			tx.commit();
		} catch (Exception e) {
			if (e instanceof org.hibernate.exception.ConstraintViolationException) {
				successMsg = "your already logged in please logout first, And then try again..!!";
			} else {
				System.out.println("bye1 " + e);
			}
		}
		infoBean = null;
		return successMsg;
	}

	public List<StudentInfoBean> m1() {

		System.out.println("SpringMVCdaoImpl.m1()");
		try {
			return isUserExists("a@gmail.com");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public StudentLoginBean studentLoginCommonMethod(Map<String, String> map, Session session) {
		System.out.println("SpringMVCdaoImpl.studentLoginCommonMethod()");
		StudentLoginBean logon = (StudentLoginBean) session.createCriteria(StudentLoginBean.class)
				.add(Restrictions.allEq(map)).uniqueResult();
		return logon;
	}

	@SuppressWarnings("unused")
	@Override
	public String logoutStudent(String email) {
		String successMsg = "";
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Map<String, String> map = new HashMap<>();
		map.put("username", email);
		StudentLoginBean logon = studentLoginCommonMethod(map, session);
		System.out.println("logout " + logon.getBean().getStud_id());

		if (logon == null) {
			successMsg = "invalid email";
		} else {

			SQLQuery queryDeleteDailybena = session.createSQLQuery("delete from tbl_dailyrecord where stud_id=?");
			SQLQuery queryUpdate = session
					.createSQLQuery("update tbl_student_day_log set logout_time=? where stud_id=? and todate=?");

			queryDeleteDailybena.setInteger(0, logon.getBean().getStud_id());
			long l = new Date().getTime();
			queryUpdate.setTime(0, new Time(l));
			queryUpdate.setInteger(1, logon.getBean().getStud_id());
			queryUpdate.setDate(2, new Date());
			int i = queryDeleteDailybena.executeUpdate();
			int c = queryUpdate.executeUpdate();
			System.out.println(i + " " + c);
			if (i == 0) {
				successMsg = "you are not logged in please login first..!!";
				tx.rollback();
				return successMsg;
			}
			if (c != 0)
				successMsg = "you are logged out successfully..!!";
			else
				successMsg = "Internal issue please try later, or refresh page..!!";
		}
		tx.commit();
		return successMsg;
	}

	@Override
	public String checkStudentData(StudentInfoBean bean, String stud_password) {
		// TODO Auto-generated method stub
		return null;
	}

}
