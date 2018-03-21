<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Login Page</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>	
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<noscript style="color: red;background-color: black;">
<h1>Please enable your java script to enjoy this application features</h1>
</noscript>
<span style="color: red;font-size: 15px;"  id="errorMsg"></span>
    <span style="color: red;" id="successMsg"></span>
<form action="<%=application.getContextPath() %>/spring-mvc/studentLogin" method="POST" id="studentLoginForm">
		<div id="id01" style="border:5px solid cyan;width:99%;padding: 20px;border-radius: 10px;">
			<!-- <label><b>UserName:</b></label> -->
		    <input type="text" placeholder="Enter your email id here"   ng-model="email" class="form-control" name="email" id="email" pattern="[a-zA-Z0-9._]{1,30}[@][a-z]{2,6}[.][a-z0-9]{2,5}" title="Enter your email id here" required="required"/><br>
		   	<!--  <label><b>Password:</b></label> -->
		   	<input type="hidden" id="stud_id" name="stud_id">
		    <input type="password"   placeholder="Enter Password" class="form-control" ng-model="stud_password" name="stud_password" id="stud_password" title="Enter Password" required="required"/><br>
		    <input type="text" class="form-control" ng-model="first_name" name="first_name"  id="first_name" readonly="readonly"><br>
		    <input type="text" class="form-control" ng-model="className" name="className" id="className" readonly="readonly"><br>
		    <select name="pracOne" ng-model="pracOne" class="form-control" id="pracOne">
		    </select><br>
		    <button type="button" id="studentLogin" class="btn btn-success btnsize" ng-click="studentLogin({'stud':email,'stud_password':stud_password,'first_name':first_name,'className':className,'pracOne':pracOne})">Login</button>
		    <button type="button" class="btn btn-primary btnsize" id="studentLogout">Logout</button> 
		    <span class="reg" style="margin-left:10%;"><a href="<%=application.getContextPath() %>/registration.jsp">Register now</a></span>
		   	<span class="pswa" style="margin-left: 20%; display: inline-block;"><a href="Forget.html">Forgot password</a></span>
		   	
		 </div>
	 </form>
	

<script type="text/javascript">

$(document).ready(function() {
	 function cleanAllData(){
		 //alert("cleanData");
		$("#first_name").val("");
	      $("#className").val("");
	      $("#stud_id").val("");
	      $("#stud_password").val("");
		  //   $("#email").val("");
	      $("#pracOne option").remove();
	      //$("#errorMsg").text("");
	}
	 function getPracticalNames(temp) {
alert(temp+" Temp");
  	  $.ajax({
      	  url:"<%=application.getContextPath()%>/spring-mvc/getPracticalName",
      	  type:"get",
      	  data:{
      		  className : temp 
      	  },
      	  datatype:"json",
      	  success: function(responseText){
      		  var data1=JSON.parse(responseText);
      		  var temp1=data1[0];
      		  $("#pracOne option").remove();
      		  var str=" <option selected='selected' value='0' >Select Practical Name</option>";
       $.each(data1,function(key,value){
               	 str+="<option value='1'>"+value.pracOne+"</option>"+
               	 "<option value='2'>"+value.pracTwo+"</option>"+
        			"<option value='3'>"+value.pracThree+"</option>"+
        			"<option value='4'>"+value.pracFour+"</option>"+
        			"<option value='5'>"+value.pracFive+"</option>";
                });
               $("#pracOne").append(str);   
      	  }
        }); //ajax call
	}
	 $("#studentLogout").click(function(event){
		 $("#errorMsg").text(" ");
		 var stud=$("#email").val();
	        $.ajax({
	        	url:"<%=application.getContextPath() %>/spring-mvc/studentLogout",
	        	type:"get",
	        	datatype:"json",
		        data:{
		        	email:stud
		        },
		        success:function(response){
		        	
		 		   $("#errorMsg").text(response);
		 		},
		 	   error:function(errorResponse){
		 		   alert("errorResponse "+errorResponse);
		 	   }
	        }); 
	        return false;
	 });
	 
	 $("#studentLogin").click(function(event){
		var first_name= $("#first_name").val();
       var className= $("#className").val();
        var practical_name=$("#pracOne option:selected").text();
        var stud_password=$("#stud_password").val();
        var stud=$("#email").val();
        var stud_id=$("#stud_id").val();
        if($("#pracOne").val()=="0" ){
       	 alert("you did not selected Practical name..plz select it and proceed..");
       	 return false;
        }
        if(stud_password==""){
			 $("#errorMsg").text("Your password is missing..!!");
		   	 return false;
		 }
	    
        if(className==""){
       	 
       	 return false;
        }
		if(stud==""){
			 $("#errorMsg").text("Enter Your email..!!");
		   return false;
		 }
		if(first_name==""){
      	 $("#errorMsg").text("Not a valid email");
      		 return false;
        }
        alert(first_name+" "+className+" "+practical_name+" "+stud_password+" "+stud);
  $.ajax({
	   url:"<%=application.getContextPath() %>/spring-mvc/studentLogin",
	   type:"post",
	   datatype:"json",
	   data:{
		   first_name:first_name,
		   className:className,
		   practical_name:practical_name,
		   stud_password:stud_password,
		   email:stud,
		   stud_id:stud_id
	   },
	   success:function(response){
		   $("#errorMsg").text(response);
		   setTimeout(function(){
			   cleanAllData();
		}, 3000);
	   },
	   error:function(errorResponse){
		   alert("errorResponse "+errorResponse.data);
	   }
  });      
   return false;
}); 
    $('#email').blur(function(event) {
   		$("#errorMsg").text(" ");
   	 var emailRegex=/^[a-zA-z0-9._]{1,25}[@][a-z]{2,6}[.][a-z0-9]{2,5}$/;
   	 var name = $('#email').val();
   	 cleanAllData();
         if(!emailRegex.test(name)){
       	  $("#errorMsg").text("Not a valid email");
       	  return false;
         }
         $.ajax({
       	  url:"<%=application.getContextPath()%>/spring-mvc/isUserExists",
       	  type:"get",
       	  data:{
       		  userName : name 
       	  },
       	  datatype:"json",
       	  success: function(responseText){
       		//  alert(responseText);
       		  if(responseText=="" || responseText=="Student data is not exists"){
       		$("#errorMsg").text("Your data is not present...");
       		  return false; 
       		  }
       		  var temp=responseText[0];
       		  alert(temp.first_name);
       		/*   var data=JSON.parse(responseText);
       		  var temp=data[0]; */
       		  $("#first_name").val(temp.first_name+" "+temp.last_name);
       		  $("#className").val(temp.className);
       		  $("#stud_id").val(temp.stud_id);
       		  if(temp.className==""){
       			  alert("class is null");
       			  return false;
       		  }
       		  getPracticalNames(temp.className);
             }
         });   
    });
});
//Get the modal

</script>

</body>
</html>