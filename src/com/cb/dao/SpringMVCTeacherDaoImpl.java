package com.cb.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.cb.bean.PracticalInfoBean;
import com.cb.bean.Teacher_Info;

@Repository
public class SpringMVCTeacherDaoImpl implements SpringMVCTeacherDao {
	private static Logger logger = Logger.getLogger(SpringMVCdaoImpl.class);
	@Autowired
	SessionFactory sessionFactory;
	// @Autowired
	HibernateTemplate hibernateTemplate;
	@Autowired
	JdbcTemplate jt;

	public SpringMVCTeacherDaoImpl() {

	}

	@Override
	public List<Teacher_Info> isTeacherExists(String t_mail) {
		System.out.println("SpringMVCTeacherDaoImpl.isTeacherExists() " + sessionFactory.getClass().getName());
		if (sessionFactory == null)
			System.out.println("session null");
		Session session = sessionFactory.openSession();
		SQLQuery sqlQuery = session.createSQLQuery("select * from practicalinfo ")
				.addEntity(PracticalInfoBean.class);
		List pracList=sqlQuery.list();
		
		SQLQuery query = session.createSQLQuery("select * from tbl_teacher_info where email=?")
				.addEntity(Teacher_Info.class);
		query.setString(0, t_mail);
		List<Teacher_Info> list = query.list();
		List l=new ArrayList();
		l.add(0,list.get(0));
		l.add(1,pracList);
		session.close();
		return l;
	}

}
