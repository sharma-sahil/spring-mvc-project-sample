<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
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
			Already an existing user. Click here to <a href="login.html">Login</a>
		</p>
		<!-- For Server Side Error -->
		<c:if test="${ not empty registerError }">
			<div class="divError alert alert-danger">
				<c:out value="${ registerError }"></c:out>
			</div>
		</c:if>
		<!-- For js errors -->
		<div id="errorBlock" class="divError alert alert-danger">
			<p id="errorOutput"></p>
		</div>

		<form action="register.html" method="post" class="form-signin"
			name="registerForm">
			<div class="divInput">
				<label class="formLabel">User Id: </label> <input type="text"
					name="username" class="form-control">
			</div>
			<div class="divInput">
				<label class="formLabel">Password: </label> <input type="password"
					name="password" class="form-control">
			</div>
			<div class="divInput">
				<label class="formLabel">Confirm Password: </label> <input
					type="password" name="confirmPassword" class="form-control">
			</div>
			<div class="divInput">
				<input type="submit" value="Register" id="registerSubmit"
					class="btn btn-lg btn-primary btn-block">
			</div>
		</form>

	</div>
	<div id="footer-wrapper"></div>
	<script type="text/javascript" src="js/register.js"></script>
</body>
</html>