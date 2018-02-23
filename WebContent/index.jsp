<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html ng-app>
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
.btnsize{
width: 49%;
}
.btnsize1{
width: 32.5%;
}
.imgsize{
width:32.5%; 
}
body {
	background-origin:content-box;
	background-image: url("<%=application.getContextPath()%>/Image/dcslogo-1058x421.png"); 
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

<body class="bg-dark">
	<h2 style="text-align:right;margin-right: 15%;">Login Form</h2>
	<h3 style="text-align:right;margin-right: 10%;">${errorMsg }</h3>
<form action="<%=application.getContextPath() %>/spring-mvc/login" method="POST" id="loginForm">
		<div class="container">
			<div class="row" >
				<div class="col-md-4"></div>
			<div class="col-md-4">		</div>
			<div class="col-md-4" id="id01" style="border:5px solid cyan;padding: 20px;border-radius: 10px;">
	<!-- <label><b>UserName:</b></label> -->
    <input type="text" placeholder="Enter Username" class="form-control" name="username" id="username"/><br>
   	<!--  <label><b>Password:</b></label> -->
    <input type="password" placeholder="Enter Password" class="form-control" name="password" id="password"/><br>
    <button type="submit" class="btn btn-success btnsize">Login</button>
    <button type="reset" class="btn btn-primary btnsize">Reset</button> 
    <span class="reg" style="margin-left:10%;"><a href="<%=application.getContextPath() %>/registration.jsp">Register now</a></span>
   <span class="pswa" style="margin-left: 20%;"><a href="Forget.html">Forgot password</a></span>
             </div>
			</div>
		</div>
		</form>
		
		<div class="row" style="margin-top: 4%;">
		<div class="col-md-3">		</div>
		<div class="col-md-6" style="border:5px solid cyan;padding: 10px;border-radius: 10px;">
		<div>
			<img alt="Image not found" style="width: 35%;" ng-src="<%=application.getContextPath() %>/Image/Att.png">
			<img alt="Image not found"  style="width: 30%;" ng-src="<%=application.getContextPath() %>/Image/Office-Customer-Male-Dark-icon.png">
			<img alt="Image not found" style="width: 32%;" ng-src="<%=application.getContextPath() %>/Image/Secret-Caretaker.png">
		</div> <!-- For Images -->
		<div>
		<button type="button" class="btn btn-primary btnsize1" onclick="document.getElementById('studeModel').style.display='block';">Student Login..</button>
		 <button type="button" style="display: inline-block;" class="btn btn-primary btnsize1">Teacher Login..</button>
		 <button type="button" style="display: inline-block;" class="btn btn-primary btnsize1">Admin Login..</button>	
		</div><!-- For Button -->
		 </div>
		<div class="col-md-3">		</div>
		</div>
		
<div id="studeModel" class="modal" >
  <!-- Modal content -->
  <div class="modal-content">
    <div class="modal-header">
      <span class="close" onclick="document.getElementById('studeModel').style.display='none';">&times;</span>
      <h2>Student Login...</h2>
    </div>
    <div class="modal-body">
     <form action="<%=application.getContextPath() %>/spring-mvc/studentLogin" method="POST" id="studentLoginForm">
		<div id="id01" style="border:5px solid cyan;width:99%;padding: 20px;border-radius: 10px;">
			<!-- <label><b>UserName:</b></label> -->
		    <input type="text" placeholder="Enter your email id here" class="form-control" name="stud_username" id="stud_username" pattern="[a-zA-Z0-9._]{1,30}[@][a-z]{2,6}[.][a-z0-9]{2,5}" title="Enter your email id here" required="required"/><br>
		   	<!--  <label><b>Password:</b></label> -->
		    <input type="password" placeholder="Enter Password" class="form-control" name="stud_password" id="stud_password" title="Enter Password" required="required"/><br>
		    <input type="text" class="form-control" name="stud_name" readonly="readonly" ><br>
		    <input type="text" class="form-control" name="class_name" readonly="readonly"><br>
		    <select name="prac_name" id="prac_name">
		    </select>
		    <button type="submit" class="btn btn-success btnsize">Login1</button>
		    <button type="reset" class="btn btn-primary btnsize">Reset</button> 
		    <span class="reg" style="margin-left:10%;"><a href="<%=application.getContextPath() %>/registration.jsp">Register now</a></span>
		   	<span class="pswa" style="margin-left: 20%; display: inline-block;"><a href="Forget.html">Forgot password</a></span>
		 </div>
	 </form>
	</div>
    <div class="modal-footer" >
      &nbsp;
      &nbsp;
    </div>
  </div>
</div><!-- Student Model -->
<div id="teacherModel" class="modal" >
  <!-- Modal content -->
  <div class="modal-content">
    <div class="modal-header">
      <span class="close" onclick="document.getElementById('teacherModel').style.display='none';">&times;</span>
      <h2>Student Login...</h2>
    </div>
    <div class="modal-body">
    <form action="Loginform" method="POST" id="teacherLoginForm">
		<div class="container">
			<div class="row">
				<div class="col-md-4">	</div>
			<div class="col-md-4">	</div>
			<div class="col-md-4" style="border:5px solid cyan;padding: 20px;border-radius: 10px;">
	<!-- <label><b>UserName:</b></label> -->
	
   Role: <select id="roleId">
    </select>
	<input type="text" placeholder="Enter Username" class="form-control" name="uname" id="uname"/><br>
    <!--  <label><b>Password:</b></label> -->
    <input type="password" placeholder="Enter Password" class="form-control" name="psw" id="psw"/><br>
   	<input type="text">
   	
   	<button type="submit" class="btn btn-success btnsize">Login1</button>
    <button type="reset" class="btn btn-primary btnsize">Reset</button> 
   <span class="reg" style="margin-left:10%;"><a href="Registration.html">Register now</a><a href="Forget.html" style="">Forgot password</a></span>
   <span class="psw" style="margin-left: 25%;"><a href="Forget.html">Forgot password</a></span>
             </div>
			</div>
		</div>
		</form>
		    </div>
    <div class="modal-footer" >
      &nbsp;
      &nbsp;
    </div>
  </div>
</div>
		
		
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/jquery.validate.js"></script>
<script type="text/javascript"
		src="<%=application.getContextPath()%>/bower_components/angular/angular.min.js"></script>

<script>
function myFunction() {
	document.getElementById('studeModel').style.display='block';
}
//Get the modal
var modal = document.getElementById('studeModel');
// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
	if (event.target == modal) {
		modal.style.display = "none";
	}
}
$(document).ready(function(){
$("#loginForm").validate({
    rules: {
    	username: "required",
    	password: "required"
    },	
    messages: {
    	username: "Please enter your username..",
        password: "Please enter your password.."
    }
});
});

</script>
</body>
</html>