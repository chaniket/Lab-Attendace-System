package com.cb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cb.bean.Teacher_Info;
import com.cb.delegete.SpringMVCTeacherDelegate;
import com.google.gson.Gson;

@Controller
public class TeacherController {
	@Autowired(required = true)
	SpringMVCTeacherDelegate teacherDelegate;

	@RequestMapping(value = "isTeacherExists", method = RequestMethod.GET)
	public @ResponseBody String isTeacherExists(@RequestParam String teacher_mail) {
		System.out.println("TeacherController.isTeacherExists() " + teacher_mail);
		List<Teacher_Info> list = teacherDelegate.isTeacherExists(teacher_mail);
	
		System.out.println(" 0 "+list.get(0));
		System.out.println(" 1 "+list.get(1));
		String responseText =null;
		if (list.isEmpty()) {
			responseText = "Data not present..!!";
		} else {
			Gson gson = new Gson();
			responseText = gson.toJson(list);
			System.out.println(responseText);
			return responseText;
		}
		return "Data not present..!!";
	}
}
