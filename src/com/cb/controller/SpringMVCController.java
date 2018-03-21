package com.cb.controller;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.cb.bean.City;
import com.cb.bean.CommandCascade;
import com.cb.bean.Country;
import com.cb.bean.LoginBean;
import com.cb.bean.PracticalInfoBean;
import com.cb.bean.State;
import com.cb.bean.StudentInfoBean;
import com.cb.delegete.SpringMVCDelegete;
import com.google.gson.Gson;

@Controller
public class SpringMVCController {
	String message = "Welcome to Spring MVC!";
	@Autowired(required = true)
	SpringMVCDelegete delegete;// =new SpringMVCDelegete();;\
	@Autowired(required = true)
	ServletContext application;

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
	private String storeImagesInWebContent(HttpServletRequest request){
		
		String appPath = application.getRealPath("");
		// constructs path of the directory to save uploaded file
		String savePath = appPath + File.separator + SAVE_DIR;
		return savePath;
	}
	
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

	/**
	 * 
	 * @param bean
	 * @param stud_password
	 * @param practical_name
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/studentLogin", method = RequestMethod.POST)
	public @ResponseBody String studLogin(@ModelAttribute("student") StudentInfoBean bean,
			@RequestParam String stud_password, String practical_name) throws IOException {
		System.out.println("SpringMVCController.studLogin()");
		System.out.println(stud_password);
		System.out.println(bean);
		bean.setLast_name(practical_name);
		String msg = delegete.insertStudentAttendace(bean, stud_password);
		return msg;
	}
	@RequestMapping(value = "/studentLogout", method = RequestMethod.GET)
	public @ResponseBody String studentLogout(@RequestParam String email) {
		System.out.println("SpringMVCController.studentLogout()");
		String msg = delegete.logoutStudent(email);
		System.out.println(msg);
		return msg;
	}

	/**
	 * 
	 * @param data
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	
	public ModelAndView registerUser(@ModelAttribute("commandcascade") CommandCascade data, HttpServletRequest request)
			throws Exception {
		
	System.out.println(data.getRegister());
	System.out.println(data.getAddress());
	System.out.println(data.getCountry());
	System.out.println(data.getState());
	System.out.println(data.getCity());
	System.out.println(application.getContextPath());
	String savePath =storeImagesInWebContent(request);
	// gets absolute path of the web application
	//	String appPath = request.getServletContext().getRealPath("");
		// constructs path of the directory to save uploaded file
		//String savePath = appPath + File.separator + SAVE_DIR;

		// creates the save directory if it does not exists
		File fileSaveDir = new File(savePath);
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
			System.out.println("Folder Created done" + fileSaveDir.getAbsolutePath());
		} else {
			System.out.println("Folder Created already" + fileSaveDir.getAbsolutePath());
		}
		
		System.out.println(request.getClass().getName());
		com.oreilly.servlet.MultipartRequest mr=new com.oreilly.servlet.MultipartRequest(request, savePath); 
		//MultipartRequest mr=(MultipartRequest) request;
MultipartHttpServletRequest mr1 = new  DefaultMultipartHttpServletRequest(request);

		File userImage = mr.getFile("userImage1");
		String imageName = userImage.getName();
		InputStream is = new FileInputStream(userImage);
		byte buffer[] = new byte[(int) userImage.length()];
		is.read(buffer);
		FileOutputStream fos = new FileOutputStream("d:\\"+imageName+".jpg");
		fos.write(buffer);
		fos.flush();
		fos.close();
	
		/*System.out.println();
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
		System.out.println("SpringMVCController.registerUser()");
		//System.exit(0);
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
	*/	int result=0;
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

	@RequestMapping(value = "/isEmailExists", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody String isEmailExists(@RequestParam String email) {
		System.out.println("SpringMVCController.isEmailExists()");
		boolean flag = delegete.isEmailExists(email);
		String requestStatus="";
		Gson gson=new Gson();
		
		if(flag){
			requestStatus="Email already exists, Please use another email";
		}else{
			requestStatus="Email";
		}
		return gson.toJson(requestStatus);
	}

	@RequestMapping(value = "/isUserExists", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody String isUserExists(@RequestParam String userName, HttpServletResponse response) {
		System.out.println("SpringMVCController.isEmailExists() \t" + userName);
		response.setContentType("application/json");
		List<StudentInfoBean> data = null;
		String responseText = "";
		try {
			data = delegete.isUserExists(userName);
			System.out.println("data in " + data);
			if (data.isEmpty()) {
				System.out.println("Record not available");
			} else {
				Gson gson = new Gson();
				responseText = gson.toJson(data);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			responseText = e.getMessage();
		}
		System.out.println(responseText+" contro");
		return responseText;
	}

	@RequestMapping(value = "/getPracticalName", method = RequestMethod.GET)
	public @ResponseBody String getPracticalName(@RequestParam String className) {
		System.out.println("SpringMVCController.getPracticalName() "+className);
		List<PracticalInfoBean> beans = delegete.getPracticalName(className);
		Gson json = new Gson();
		String responseText = json.toJson(beans);
		return responseText;
	}
}
