<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/footer.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
</head>
<body>

	<div id="header-wrapper">
		<div id="header-title">Flight Search</div>
	</div>

	<div class="divContainer">
		<p id="redirect-msg">
			Not a registered user. Click here to <a href="register.html">Register</a>
		</p>

		<!-- For Server Side Error -->
		<c:if test="${ not empty loginError }">
			<div class="divError alert alert-danger">
				<c:out value="${ loginError }"></c:out>
			</div>
		</c:if>
		<!-- For js errors -->
		<div id="errorBlock" class="divError alert alert-danger">
			<p id="errorOutput"></p>
		</div>

		<form:form commandName="user" cssClass="form-signin" name="loginForm">
			<div class="divInput">
				<label class="formLabel">User Id: </label>
				<form:input path="username" name="username" cssClass="form-control" />
			</div>
			<div class="divInput">
				<label class="formLabel">Password: </label>
				<form:input type="password" path="password" name="password"
					cssClass="form-control" />
			</div>
			<div class="divInput">
				<input id="loginSubmit" class="btn btn-lg btn-primary btn-block"
					type="Submit" value="Login" />
			</div>
		</form:form>
	</div>
	<div id="footer-wrapper"></div>
	<script type="text/javascript" src="js/login.js"></script>

</body>
</html>