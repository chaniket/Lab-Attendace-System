<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
.btnsize {
	width: 49%;
}

.btnsize1 {
	width: 32.5%;
}

.imgsize {
	width: 32.5%;
}

body {
	background-origin: content-box;
	background-image:
		url("<%=application.getContextPath()%>/Image/dcslogo-1058x421.png");
	background-repeat: no-repeat;
	background-attachment: local;

	/*	background-size: cover;
 	background-size:100%; */
}
</style>
<style type="text/css">
.modal-header {
	padding: 2px 16px;
	background-color: #5cb85c;
	color: white;
}

.modal-body {
	padding: 2px 16px;
}

.modal-footer {
	padding: 2px 16px;
	background-color: #5cb85c;
	color: white;
}

/* Extra styles for the cancel button */
.cancelbtn {
	width: auto;
	padding: 10px 18px;
	background-color: #f44336;
}
/* Center the image and position the close button */
.imgcontainer {
	text-align: center;
	margin: 24px 0 12px 0;
	position: relative;
}

img.avatar {
	width: 40%;
	border-radius: 50%;
}

.container {
	padding: 16px;
}

span.psw {
	float: right;
	padding-top: 16px;
}

/* The Modal (background) */
.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
	padding-top: 60px;
}

/* Modal Content/Box */
.modal-content {
	background-color: #fefefe;
	margin: 5% auto 15% auto;
	/* 5% from the top, 15% from the bottom and centered */
	border: 1px solid #888;
	width: 30%; /* Could be more or less, depending on screen size */
}

/* The Close Button (x) */
.close {
	position: absolute;
	right: 25px;
	top: 0;
	color: #000;
	font-size: 35px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: red;
	cursor: pointer;
}

/* Add Zoom Animation */
.animate {
	-webkit-animation: animatezoom 0.6s;
	animation: animatezoom 0.6s
}

@
-webkit-keyframes animatezoom {
	from {-webkit-transform: scale(0)
}

to {
	-webkit-transform: scale(1)
}

}
@
keyframes animatezoom {
	from {transform: scale(0)
}

to {
	transform: scale(1)
}

}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
	span.psw {
		display: block;
		float: none;
	}
	.cancelbtn {
		width: 100%;
	}
}
</style>

<title>Spring MVC Application</title>
</head>

<body class="bg-dark" ng-app="MyApp" ng-controller="ctrl">
	<noscript style="color: red; background-color: black;">
		<h1>Please enable your javascript to enjoy this application
			features</h1>
	</noscript>

	<h2 style="text-align: right; margin-right: 15%;">Login Form</h2>
	<h3 style="text-align: right; margin-right: 10%;">${errorMsg }</h3>
	<form action="<%=application.getContextPath()%>/spring-mvc/login"
		method="POST" id="loginForm">
		<div class="container">
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-4"></div>
				<div class="col-md-4" id="id01"
					style="border: 5px solid cyan; padding: 20px; border-radius: 10px;">
					<!-- <label><b>UserName:</b></label> -->
					<input type="text" placeholder="Enter Username"
						class="form-control" name="username" id="username" /><br>
					<!--  <label><b>Password:</b></label> -->
					<input type="password" placeholder="Enter Password"
						class="form-control" name="password" id="password" /><br>
					<button type="submit" class="btn btn-success btnsize">Login</button>
					<button type="reset" class="btn btn-primary btnsize">Reset</button>
					<span class="reg" style="margin-left: 10%;"><a
						href="<%=application.getContextPath()%>/registration.jsp">Register
							now</a></span> <span class="pswa" style="margin-left: 20%;"><a
						href="Forget.html">Forgot password</a></span>
				</div>
			</div>
		</div>
	</form>

	<div class="row" style="margin-top: 4%;">
		<div class="col-md-3"></div>
		<div class="col-md-6"
			style="border: 5px solid cyan; padding: 10px; border-radius: 10px;">
			<div>
				<img alt="Image not found" style="width: 35%;"
					ng-src="<%=application.getContextPath()%>/Image/Att.png"> <img
					alt="Image not found" style="width: 30%;"
					ng-src="<%=application.getContextPath()%>/Image/Office-Customer-Male-Dark-icon.png">
				<img alt="Image not found" style="width: 32%;"
					ng-src="<%=application.getContextPath()%>/Image/Secret-Caretaker.png">
			</div>
			<!-- For Images -->
			<div>
				<button type="button" class="btn btn-primary btnsize1"
					onclick="document.getElementById('studeModel').style.display='block';studentLoginFun();">Student
					Login..</button>
				<button type="button" style="display: inline-block;"
					onclick="document.getElementById('teacherModel').style.display='block';teacherLoginFun();"
					class="btn btn-primary btnsize1">Teacher Login..</button>
				<button type="button" style="display: inline-block;"
					class="btn btn-primary btnsize1">Admin Login..</button>
			</div>
			<!-- For Button -->
		</div>
		<div class="col-md-3"></div>
	</div>

	<div id="studeModel" class="modal">
		<!-- Modal content -->
		<div class="modal-content">
			<div class="modal-header">
				<span class="close"
					onclick="document.getElementById('studeModel').style.display='none';location.reload();">&times;</span>
				<h2>Student Login...</h2>
			</div>
			<div class="modal-body">
				<span style="color: red; font-size: 15px;" id="errorMsg"></span> <span
					style="color: red;" id="successMsg"></span>
				<form
					action="<%=application.getContextPath()%>/spring-mvc/studentLogin"
					method="POST" id="studentLoginForm">
					<div id="id01"
						style="border: 5px solid cyan; width: 99%; padding: 20px; border-radius: 10px;">
						<!-- <label><b>UserName:</b></label> -->
						<input type="text" placeholder="Enter your email id here"
							autofocus="autofocus" ng-model="email" class="form-control"
							name="email" id="email"
							pattern="[a-zA-Z0-9._]{1,30}[@][a-z]{2,6}[.][a-z0-9]{2,5}"
							title="Enter your email id here" required="required" /><br>
						<!--  <label><b>Password:</b></label> -->
						<input type="hidden" id="stud_id" name="stud_id"> <input
							type="password" placeholder="Enter Password" class="form-control"
							ng-model="stud_password" name="stud_password" id="stud_password"
							title="Enter Password" required="required" /><br> <input
							type="text" class="form-control" ng-model="first_name"
							name="first_name" id="first_name" readonly="readonly"><br>
						<input type="text" class="form-control" ng-model="className"
							name="className" id="className" readonly="readonly"><br>
						<select name="pracOne" ng-model="pracOne" class="form-control"
							id="pracOne">
						</select><br>
						<button type="button" id="studentLogin"
							class="btn btn-success btnsize"
							ng-click="studentLogin({'stud':email,'stud_password':stud_password,'first_name':first_name,'className':className,'pracOne':pracOne})">Login</button>
						<button type="button" class="btn btn-primary btnsize"
							id="studentLogout">Logout</button>
						<span class="reg" style="margin-left: 10%;"><a
							href="<%=application.getContextPath()%>/registration.jsp">Register
								now</a></span> <span class="pswa"
							style="margin-left: 20%; display: inline-block;"><a
							href="Forget.html">Forgot password</a></span>

					</div>
				</form>

			</div>
			<div class="modal-footer">&nbsp; &nbsp;</div>
		</div>
	</div>
	<!-- Student Model -->

	<div id="teacherModel" class="modal">
		<!-- Modal content -->
		<div class="modal-content">
			<div class="modal-header">
				<span class="close"
					onclick="document.getElementById('teacherModel').style.display='none';location.reload();">&times;</span>
				<h2>Teacher Login...</h2>
			</div>
			<div class="modal-body">
				<span id="tError" style="color: red;"></span>
				<form
					action="<%=application.getContextPath()%>/spring-mvc/teacherLogin"
					method="POST" id="teacherLoginForm">
					<!-- <label><b>UserName:</b></label> -->
					<div id="id02"
						style="border: 5px solid cyan; width: 99%; padding: 20px; border-radius: 10px;">
						<input type="text" placeholder="Enter Username"
							class="form-control" name="teacher_mail" id="teacher_mail" /><br>
						<input type="password" placeholder="Enter Password"
							class="form-control" name="teacher_pass" id="teacher_pass" /><br>
							<input type="text" name="teacher_Name" class="form-control" id="teacher_Name" readonly="readonly"/><br>
						<select id="teacher_classname" class="form-control"
							name="teacher_classname">
						</select><br> <select id="teacher_prac_name" class="form-control"
							name="teacher_prac_name">
						</select><br>
						<button type="button" class="btn btn-success btnsize"
							id="teacher_login">Login</button>
						<button type="reset" class="btn btn-primary btnsize">Reset</button>
						<span class="reg" style="margin-left: 10%;"><a
							href="<%=application.getContextPath()%>/registration.jsp">Register
								now</a></span> <span class="pswa"
							style="margin-left: 20%; display: inline-block;"><a
							href="Forget.html">Forgot password</a></span>
					</div>
				</form>
			</div>
			<div class="modal-footer">&nbsp; &nbsp;</div>
		</div>
	</div>
	<ol>
		<li ng-repeat="x in userExists">{{x.email}}&emsp;</li>
	</ol>
	<script type="text/javascript"
		src="<%=application.getContextPath()%>/Js/studentJs.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/jquery.validate.js"></script>
	<script type="text/javascript"
		src="<%=application.getContextPath()%>/bower_components/angular/angular.min.js"></script>

	<script>
		var app = angular.module('MyApp', []);
		app.controller('ctrl', function($scope) {
		});
		function myFunction() {
			document.getElementById('studeModel').style.display = 'block';
		}
		//studenet Js

		//student Js
		//teacher js
		$(document).ready(function() {
		var emailRegex = /^[a-zA-z0-9._]{1,25}[@][a-z]{2,6}[.][a-z0-9]{2,5}$/;

	$("#teacher_mail").blur(function() {
			teacher_mail = $(this).val();
			alert(teacher_mail);
			if (teacher_mail == "") {
			$("tError").text("Plese enter email..!!");
		}
		if (!emailRegex.test(teacher_mail)) {
			$("#errorMsg").text("Not a valid email");
			return false;
			}
		var pracName="<option selected='selected' value='0'>Select Practical Name</option>";
		var className="<option selected='selected' value='0'>Select Class</option>";
		$.ajax({
			url : "spring-mvc/isTeacherExists",
			type : "get",
			datatype:"json",
			data : {
				teacher_mail : teacher_mail
			},
			success : function(responseText) {
			var data=JSON.parse(responseText);
			var temp=data[0];
			var prac=data[1];
			///alert(prac.pracOne);
			$.each(data[1],function(key,value){
				className+="<option value="+value.className+">"+value.className+"</option>";
				alert(value);
				//pracName+=="<option value="+value.+">"+value.className+"</option>";
			});
			
			
		 	$("#teacher_Name").val(temp.firstName+" "+temp.lastName);
		
		 	$("#teacher_prac_name").html(pracName);
		 	$("#teacher_classname").html(className);
			},
			error : function(responceText) {
				alert("Problem accured");
			}
	 });
	});
});
		//teacher js
		var modal = document.getElementById('studeModel');
		function studentLoginFun() {
			alert("studentLoginFun()");
			modal = document.getElementById('studeModel');
		}
		function teacherLoginFun() {
			alert("teacherLoginFun()");
			modal = document.getElementById('teacherModel');
		}
		function adminLoginFun() {
			alert("adminLoginFun()");
		}

		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
			if (event.target == modal) {
				modal.style.display = "none";
			}
		}
		$(document).ready(function() {
			$("#loginForm").validate({
				rules : {
					username : "required",
					password : "required"
				},
				messages : {
					username : "Please enter your username..",
					password : "Please enter your password.."
				}
			});
		});
	</script>
</body>
</html>