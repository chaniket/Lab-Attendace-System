<%@ page language="java"  isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html ng-app='MyApp' ng-clock>
<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body ng-controller="my_ctrl">
<noscript style="color: red;background-color: black;">
<h1>Please enable your javascript to enjoy this application features</h1>

</noscript>

	
	<div class="container">
		<div class="row">
		
		<h3>${succesMsg} ${errorMsg}</h3>
</div>		
	<div class="row">
	<%-- <c:url var="addAction" value="<%=application.getContextPath() %>/spring-mvc/registration" ></c:url>--%>		
			<form:form action="../spring-mvc/registration" methodParam="POST" 
				id="userFrom" commandName="commandcascade" 
				onSubmit="return validation();">
				enctype="multipart/form-data"
		<div class="col-md-4">

	<label>First Name:</label><br>
	<input type="text" class="form-control" name="register.firstName"id="firstName" /><br> 
	<label>Last Name:</label><br>
	<input type="text" class="form-control" name="register.lastName"id="lastName" /><br> 
	<label>Gender:</label><br>
	 <select class="form-control" name="register.gender" id="gender">
	<option selected="selected" value="0">Select gender</option>
	<option value="Male">Male</option>
	<option value="Female">Female</option>
	</select><br>
	 <label>Email:</label>&emsp;&emsp;<span style="color: red;">{{emailMsg}}</span> <br>
	<input type="text" class="form-control" name="register.email" ng-model="email" title="Enter Correct Email eg.jhon@gmail.com" ng-pattern="isValidEmail" id="email" ng-blur="isEmailExists({'email':email})"/><br>
	 <label>Password:</label><br>
	<input type="password" class="form-control"name="register.password" id="password" /><br> 
	<label>Confirm Password:</label><br>
	<input type="password" class="form-control" name="confirm_password" id="confirm_password" /><br>
</div>
<div class="col-md-4">
	<label>Mobile no:</label><br>
	<input type="text" class="form-control" name="register.mobileNo" id="mobileNo" /><br> 

	
	
	<!--<label>Country:</label><br>
	 <select class="form-control" name="country.c_Id" id="c_Id" ng-model="c_Id"	ng-change="getStateData({'c_id':c_Id})">
		<option  ng-repeat="x in country_data"  ng-value={{x.c_Id}}>{{x.c_Name}}</option>
	</select><br>
	  <label>State:</label><br> 
		<select class="form-control" name="state.s_Id" ng-model="s_Id" id="s_Id" ng-change="getCityData({'s_Id':s_Id})">
		<option ng-repeat="x in state_data" ng-value={{x.s_Id}}>{{x.s_Name}}</option>
	</select><br> 
	 
	<label>City:</label><br>
	 <select class="form-control" name="city.city_Id" id="city_Id">
	<option ng-repeat="x in city_data" value="{{x.city_Id}}">{{x.city_Name}}</option>
	</select><br>
	-->
	
	<label>Pincode:</label><br>
	<input type="number" class="form-control" name="address.zipcode" id="zipcode" /><br> 
	<label>Address:</label><br>
	<input type="text" class="form-control" name="address.address" id="address" /><br>
	
	
	<input type="submit" style="width: 176px;" class="btn btn-success"
						name="submit" onClick="return validates();" value="submit">
		<input type="reset" style="width: 176px;" class="btn btn-primary"
						name="reset" value="Reset">
	
				</div>
				<div class="col-md-4">
				<label>User Image</label>
				<input type="file" onchange="loadFile(event)" ng-model="userImage" id="userImage" name="userImage1">
				<img id="output" class="img-thumbnail" height="200px" width="200px" style="display: none"/>
				</div>
			</form:form>
			<!-- row -->
		</div>
		<!-- container -->
	</div>
	{{5*5}}

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/jquery.validate.js"></script>

	<script type="text/javascript"
		src="<%=application.getContextPath()%>/bower_components/angular/angular.min.js"></script>

	<script type="text/javascript">
	var loadFile = function(event) {
	    var output = document.getElementById('output');
	    document.getElementById('output').style.display="block";
	    output.src = URL.createObjectURL(event.target.files[0]);    
	  };

	var app=angular.module('MyApp',[]);

app.service('country_service',function($http,$q){
	var getDifer=$q.defer();
	this.getcountryData=function(){
	return $http.get("<%=application.getContextPath()%>/spring-mvc/getCountry's")
	.then(function success(posRes) {
		alert('country_service'+posRes.data[0].c_Name);
		getDifer.resolve(posRes.data);
		return getDifer.promise;
	},function erroe(errRes){
		getDifer.reject(errRes);
		return getDifer.promise;
	});
	}//getDataService
});

app.service('state_service',function($http,$q){
	var getDifer=$q.defer();
	this.getStateData=function(data){
		return $http.get("<%=application.getContextPath()%>/spring-mvc/getState's?c_Id="+data+"",data)
		.then(function(posRes){
			alert('state_service'+posRes.data[0].s_Name);
			return posRes.data;
		},function(errRes){
			alert("error");
			alert("service statustext "+errRes.data);
			alert("service status "+errRes.status);
			return errRes;
		});	
	}//getStataeData
});

app.service('city_service',function($http,$q){
	var getDifer=$q.defer();
	this.getCityData=function(s_Id){
	return $http.get("<%=application.getContextPath()%>/spring-mvc/getCity's?s_Id="+ s_Id + "", s_Id)
	.then(function success(posRes) {
		alert(posRes.data[0].city_Name + " "+ posRes.data[0].city_Id);
		getDifer.resolve(posRes.data);
		return getDifer.promise;
	}, function erroe(errRes) {
		getDifer.reject(errRes);
		return getDifer.promise;
		});
	}//getCityData
});

app.service("email_checking_service",function($http,$q){
	var getDifer=$q.defer();
	this.isEmailExists=function(email){
	return $http.get("<%=application.getContextPath()%>/spring-mvc/isEmailExists?email="+ email + "", email)
	.then(function success(posRes) {
		alert("email_checking_service "+posRes.data);
		getDifer.resolve(posRes.data);
		return getDifer.promise;
	}, function erroe(errRes) {
		getDifer.reject(errRes);
		return getDifer.promise;
	});
	}//isEmailExists
});

		app.controller('my_ctrl', function($scope, country_service,
				state_service, city_service,email_checking_service) {
		$scope.emailRegex=/^[a-zA-z0-9._]{1,25}[@][a-z]{2,6}[.][a-z0-9]{2,5}$/; 
		/* 	$scope.isValidEmail="/^[^\s@]+@[^\s@]+\.[^\s@]{2,}$/" */ 
		$scope.emailMsg="";
		$scope.filterCondition = {
        operator: '0'
    }
		$scope.check=0;
		
		
		country_service.getcountryData().then(function(res) {
				$scope.country_data = res;
				});
			$scope.getStateData = function(data) {
				if(data.c_id=="0"){
					alert("Please Select Country..!!");
					return false;
					
				}
				alert(data.c_id + " getStateData()");
				state_service.getStateData(data.c_id).then(function(res) {
					$scope.state_data = res;
				});
			}
			$scope.getCityData = function(data) {
				alert(data.s_Id + " getCityData()");
				city_service.getCityData(data.s_Id).then(function(res) {
					$scope.city_data = res;
				});
			}
			$scope.isEmailExists=function(data){
				alert(data.email+" "+"isEmailExists"+" "+$scope.email);
				/*if($scope.email==null){
					$scope.emailMsg="Please Enter email";
					return false;
				} */
				 if($scope.email!=null)
				 if($scope.emailRegex.test($scope.email)){
					 //$scope.emailMsg="email is  valid"+$scope.email.match($scope.emailRegex);
					}  else{
				//		$scope.emailMsg="email is not valid";
						return false;
					} 
				if($scope.email!=null){
					email_checking_service.isEmailExists(data.email).then(function(res){
					$scope.emailMsg=res;
				});
			}else{
				alert(data.email+" "+"isEmailExists");
			}
		}
			
});
	</script>
	<script>
		function validation() {
			var password = $("#Password").val();
			var confirmPassword = $("#confirm_password").val();
			if (password != confirmPassword) {
			}
		}
		$(document).ready(function() {
	$("#userFrom")
	.validate({rules : {	"register.firstName" : "required",
"register.lastName" : "required",
"register.gender" : "required",
"country.c_Id" : {
			required : true
			},
	"state.s_Id" : "required",
"city.city_Id" : "required",
	"address.address" : "required",
"address.zipcode" : {
		required : true,
					minlength : 3,
			number : true
},
	"register.mobileNo" : {
			required : true,
			minlength : 10,
			maxlength : 10,
		number : true
			},
		"register.email" : {
		required : true,
		email : true
		},
		password : {
		required : true,
		minlength : 6
		},
		confirm_password : {
	required : true,
	minlength : 6,
		equalTo : "#password"
		},
		"address.pincode" : "required",
	},
	messages : {
	"register.firstName" : "Please enter your name",
	"register.lastName" : "Please enter your last name",
	"register.gender" : "Please select your Gender ",
	"country.c_Id" : {
		required : "Select your Country "
		},
		"state.s_Id" : "Select your State ",
	"city.city_Id" : "Select your City",
		"address.zipcode" : {
		required : "Please enter pincode",
	minlength : "Please enter correct pincode",
	number : "Please enter only numeric value"
	},
	"address.address" : "Enter your address",
		"register.mobileNo" : {
	required : "Please enter your phone number",
	minlength : "Please enter 10 digit number",
	maxlength : "Don't enter more than 10 number.",
	number : "Please enter only numeric value"
		},
		"register.email" : "Please enter a valid email address",
					"register.password" : {
			required : "Please provide a password",
	minlength : "Your password must be at least 6 characters long"
				},
					confirm_password : {
			required : "Please provide a password",
		minlength : "Your password must be at least 6 characters long",
equalTo : "Please enter the same password as above"
}
}
});
});
	</script>

</body>
</html>