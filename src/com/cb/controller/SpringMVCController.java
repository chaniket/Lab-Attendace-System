package com.cb.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.cb.bean.Address;
import com.cb.bean.City;
import com.cb.bean.CommandCascade;
import com.cb.bean.Country;
import com.cb.bean.LoginBean;
import com.cb.bean.RegistrationBean;
import com.cb.bean.State;
import com.cb.delegete.SpringMVCDelegete;
import com.google.gson.Gson;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

@Controller
public class SpringMVCController {
	String message = "Welcome to Spring MVC!";
	@Autowired(required = true)
	SpringMVCDelegete delegete;// =new SpringMVCDelegete();;
	static String location = "";

	/*
	 * static{ ApplicationContext beanFactory=new
	 * ClassPathXmlApplicationContext(); PropertyPlaceholderConfigurer ppc=new
	 * PropertyPlaceholderConfigurer(); ppc.setLocation(new
	 * ClassPathResource("MyPropertiesFile.properties"));
	 * ppc.postProcessBeanFactory((ConfigurableListableBeanFactory)
	 * beanFactory); }
	 */
	/**
	 * Name of the directory where uploaded files will be saved, relative to the
	 * web application directory.
	 */
	private static final String SAVE_DIR = "uploadFiles";

	/**
	 * handles file upload
	 */
	@RequestMapping("/login")
	public ModelAndView showMessage(
			@RequestParam(value = "username", required = false, defaultValue = "World") String username,
			String password, ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		System.out.println("in controller");
		System.out.println(username);
		System.out.println("Password :: " + password);
		LoginBean bean = new LoginBean(username, password);
		LoginBean bean1;
		try {
			bean1 = delegete.checkLoginData(bean);
			System.out.println("After Login..!!" + bean);
			if (bean1.getUser_id() != null) {
				return new ModelAndView("homepage", "loginsuccess", bean1.toString() + "home");
			}
		} catch (SQLException e) {
			return new ModelAndView("index", "errorMsg", e.getMessage());
		}
		// model.put("errorMsg", "invalid Credintinals");
		return new ModelAndView("index", "errorMsg", "Login Failed");
	}

	@RequestMapping("/studentLogin")
	public ModelAndView studLogin(@RequestParam String stud_username, String stud_password, String password,
			String prac_name,String class_name,ModelMap model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(stud_password + " " + stud_username);
		return new ModelAndView("index", "errorMsg", "Login Failed");
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("commandcascade") CommandCascade data, HttpServletRequest request)
			throws Exception {
		// gets absolute path of the web application
		String appPath = request.getServletContext().getRealPath("");
		// constructs path of the directory to save uploaded file
		String savePath = appPath + File.separator + SAVE_DIR;

		// creates the save directory if it does not exists
		File fileSaveDir = new File(savePath);
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
			System.out.println("Folder Created" + fileSaveDir.getAbsolutePath());
		} else {
			System.out.println("Folder Created" + fileSaveDir.getAbsolutePath());
		}

		MultipartHttpServletRequest mr = (MultipartHttpServletRequest) request;
		MultipartFile userImage = mr.getFile("userImage");
		String imageName = userImage.getName();
		InputStream is = userImage.getInputStream();
		byte buffer[] = new byte[is.read()];
		is.read(buffer);
		FileOutputStream fos = new FileOutputStream("d:\\vc.jpg");
		fos.write(buffer);
		fos.flush();
		fos.close();

		System.out.println("SpringMVCController.registerUser()");
		System.out.println();
		String insertStatus = null;
		Country country = data.getCountry();
		State state = data.getState();
		state.setCountry(country);
		City city = data.getCity();
		city.setState(state);
		Address address = data.getAddress();
		address.setCity(city);
		RegistrationBean bean = data.getRegister();
		bean.setAddress(address);
		System.out.println(bean);
		int result = 0;
		try {
			result = delegete.insertUserDetails(bean);
		} catch (Exception e) {
			e.printStackTrace();
			if (e instanceof MySQLIntegrityConstraintViolationException) {
				System.out.println("SpringMVCController.registerUser() Exception");
				System.out.println(e.toString() + "\n\n");
				System.out.println(e.getStackTrace());
				return new ModelAndView("registration", "errorMsg",
						"Failes to Insered Insert Record Duplicate entry!!");
			}
		}
		if (result != 0)
			return new ModelAndView("registration", "succesMsg", "Record Insered Successfully..!!");
		else
			return new ModelAndView("registration", "errorMsg", "Failes to Insered Insert Record Try Again later..!!");
	}

	@RequestMapping(value = "/getCountry's", method = RequestMethod.GET, produces = {})
	public @ResponseBody String getCountryData(ModelMap modelMap) {
		System.out.println("SpringMVCController.getCountryData()");
		List<Country> list = delegete.getCountryData();
		Gson gson = new Gson();
		return gson.toJson(list);
	}

	@RequestMapping(value = "/getState's", method = RequestMethod.GET)
	public @ResponseBody String getstateData(Country c, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("SpringMVCController.getstateData()");
		List<State> list = delegete.getstateData(c.getC_Id());
		Gson gson = new Gson();
		return gson.toJson(list);
	}

	@RequestMapping(value = "/getCity's", method = RequestMethod.GET)
	public @ResponseBody String getCityData(State s, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("SpringMVCController.getCityData()" + s);
		String sid = request.getParameter("s_Id");
		List<City> list = delegete.getCityData(Integer.valueOf(sid));
		Gson gson = new Gson();
		return gson.toJson(list);
	}

	@RequestMapping(value = "/isEmailExists", method = RequestMethod.GET)
	public @ResponseBody String isEmailExists(@RequestParam String email) {
		System.out.println("SpringMVCController.isEmailExists()");
		return null;
	}

}
