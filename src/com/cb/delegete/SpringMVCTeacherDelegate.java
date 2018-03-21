package com.cb.delegete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.cb.bean.Teacher_Info;
import com.cb.service.SpringMVCTeacherService;

@Scope(value = "request")
public class SpringMVCTeacherDelegate implements Runnable {
	@Autowired
	SpringMVCTeacherService teacherService;

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}

	public List<Teacher_Info> isTeacherExists(String string) {
		System.out.println("SpringMVCTeacherDelegate.isTeacherExists()");
		List<Teacher_Info> responseText = teacherService.isTeacherExists(string);
		return responseText;
	}

	public static void main(String[] args) {
		Runnable delegate = new SpringMVCTeacherDelegate();
		Runnable delegate1 = new SpringMVCTeacherDelegate();
		Thread t = new Thread(delegate);

		Thread t1 = new Thread(delegate1);
		t.start();
		t1.start();
		t.start();
	}
}
