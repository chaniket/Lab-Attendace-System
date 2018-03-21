package com.cb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cb.bean.Teacher_Info;
import com.cb.dao.SpringMVCTeacherDao;
@Service
public class SpringMVCTeacherServiceImpl implements SpringMVCTeacherService {
	@Autowired
	SpringMVCTeacherDao teacherDao;

	@Override
	public List<Teacher_Info> isTeacherExists(String t_mail) {
		List<Teacher_Info> responseText=teacherDao.isTeacherExists(t_mail);
		return responseText;
	}

}
