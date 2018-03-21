<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>SB Admin - Start Bootstrap Template</title>
  <!-- Bootstrap core CSS-->
  <link href="<%=application.getContextPath()%>/assests/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="<%=application.getContextPath()%>/assests/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="<%=application.getContextPath()%>/assests/css/sb-admin.css" rel="stylesheet">
</head>

<body class="bg-dark">
  <div class="container">
    <div class="card card-register mx-auto mt-5">
      <div class="card-header">Register an Account</div>
      <div class="card-body">
        
        <form:form commandName="studBean"  methodParam="post">      
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="exampleInputName">First name</label>
                <input class="form-control" id="exampleInputName" type="text" aria-describedby="nameHelp" placeholder="Enter first name">
              </div>
              <div class="col-md-6">
                <label for="exampleInputLastName">Last name</label>
                <input class="form-control" id="exampleInputLastName" type="text" aria-describedby="nameHelp" placeholder="Enter last name">
              </div>
            </div>
          </div>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="exampleInputName">Email </label>
                <input class="form-control" id="exampleInputName" type="text" aria-describedby="nameHelp" placeholder="Enter Email">
              </div>
              <div class="col-md-6">
                <label for="exampleInputLastName">Mobile Number</label>
                <input class="form-control" id="exampleInputLastName" type="text" aria-describedby="nameHelp" placeholder="Enter Mobile Number">
              </div>
            </div>
          </div>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="exampleInputPassword1">Password</label>
                <input class="form-control" id="exampleInputPassword1" type="password" placeholder="Password">
              </div>
              <div class="col-md-6">
                <label for="exampleConfirmPassword">Confirm password</label>
                <input class="form-control" id="exampleConfirmPassword" type="password" placeholder="Confirm password">
              </div>
            </div>
          </div>
          <a class="btn btn-primary btn-block" href="login.html">Register</a>
          </form:form>
      <div class="text-center">
          <a class="d-block small mt-3" href="login.jsp">Login Page</a>
          <a class="d-block small" href="forgot-password.jsp">Forgot Password?</a>
        </div>
      </div>
    </div>
  </div>
  <!-- Bootstrap core JavaScript-->
  <script src="<%=application.getContextPath()%>/assests/vendor/jquery/jquery.min.js"></script>
  <script src="<%=application.getContextPath()%>/assests/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <!-- Core plugin JavaScript-->
  <script src="<%=application.getContextPath()%>/assests/vendor/jquery-easing/jquery.easing.min.js"></script>
</body>

</html>