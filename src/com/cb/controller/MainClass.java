package com.cb.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.ConstraintViolationException;

import com.cb.bean.DailyRecordBean;
import com.cb.bean.StudentDayLogBean;
import com.cb.bean.StudentInfoBean;
import com.cb.bean.StudentLoginBean;
import com.cb.bean.TeacherSubject;
import com.cb.bean.Teacher_Info;

public class MainClass {

	private static void TeacherMethod() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<TeacherSubject> list = new ArrayList<>();
		Teacher_Info teacher_Info = null;
		list.add(new TeacherSubject("java"));
		list.add(new TeacherSubject("C"));
		teacher_Info = new Teacher_Info("Aniket", "Chavan", "a@gmail.com", "MCS", list);
		teacher_Info.setTeacherSubject(list);
		session.save(teacher_Info);
		
		session.save(teacher_Info.getTeacherSubject().get(0));
		session.save(list.get(1));
		tx.commit();
		session.close();
		sessionFactory.close();
	}

	public static void main(String[] args) throws InterruptedException {
		TeacherMethod();
		System.exit(0);
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		StudentInfoBean infoBean = new StudentInfoBean("Aniket", "Chavan", 9503764321l, "BCS TY", "a@gmail.com");
		StudentLoginBean loginBean = new StudentLoginBean(infoBean, infoBean.getEmail(), "12345");
		DailyRecordBean dailyRecordBean = new DailyRecordBean(infoBean);
		StudentDayLogBean dayLogBean = new StudentDayLogBean(infoBean, "C", "Bcs", new Date(), new Date(), null);
		try {
			Serializable s = session.save(infoBean);
			Serializable s1 = session.save(loginBean);
			Serializable s2 = session.save(dailyRecordBean);
			Serializable s3 = session.save(dayLogBean);
			System.out.println(s);
			System.out.println(s1);
			System.out.println(s2);
			System.out.println(s3);
		} catch (HibernateException e) {
			System.out.println("Exception Caught");
			if (e instanceof ConstraintViolationException) {
				System.out.println("MainClass.main()");
			}
		}
		tx.commit();
		Thread.sleep(5000);
		tx = session.beginTransaction();
		// session.delete(loginBean);
		session.delete(infoBean);
		// session.delete(dailyRecordBean);
		tx.commit();
		session.clear();
		session.close();
		sessionFactory.close();
		System.out.println("MainClass.main()");

	}
}
