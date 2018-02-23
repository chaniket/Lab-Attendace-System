<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<%!
int a=10;
int b;
 int m1(int a){
 b=this.a;
 return b;
 }
%>
<%= m1(b) %>
<%=a+" "+b %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Simple</title>
</head>
<body>
	<c:url var="addAction" value="spring-mvc/simple"></c:url>
	<form:form action="spring-mvc/simple" method="POST"  commandName="simple">
		<input type="text" name="name" id="name">
		<input type="text" name="age" id="age">
		<input type="submit" value="<spring:message text="Add"/>" />
	</form:form>

</body>
</html>