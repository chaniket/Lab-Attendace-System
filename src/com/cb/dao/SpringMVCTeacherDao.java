package com.cb.dao;

import java.util.List;

import com.cb.bean.Teacher_Info;

public interface SpringMVCTeacherDao {

	List<Teacher_Info> isTeacherExists(String t_mail);

}
