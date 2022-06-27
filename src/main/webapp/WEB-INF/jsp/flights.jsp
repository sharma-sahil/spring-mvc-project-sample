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
<title>Query</title>

<link rel="stylesheet" href="css/flights.css" />
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/footer.css">
<link rel="stylesheet" href="css/bootstrap.min.css" >
<link rel="stylesheet" href="css/bootstrap-theme.min.css" >
</head>
<body>

	<div id="header-wrapper">
		<div id="header-title">Flight Search</div>
		<div id="user-name-logout">
			<!-- <div id="logout">
				<a href="logout">logout</a>
			</div> -->
		</div>
	</div>
	<a href="logout.html" class="btn btn-primary btn-logout">Logout</a>
	
	<div class="divForm">

		<div id="errorBlock" class="divError alert alert-danger">
			<p id="errorMessage"></p>
		</div>

		<form method="post" name="queryForm">
			<div class="form-group">
				<label>Departure Location: </label> <select class="form-control"
					name="departureLocation">
					<option value="" selected>Select Departure Location</option>
					<c:forEach items="${ departureLocations }" var="depLoc">
						<option value="${ depLoc }">${ depLoc}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label>Arrival Location: </label> <select class="form-control"
					name="arrivalLocation">
					<option value="" selected>Select Arrival Location</option>
					<c:forEach items="${ arrivalLocations }" var="arrLoc">
						<option value="${ arrLoc }">${ arrLoc }</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label>Flight Date: </label> <input type="date" name="flightDate"
					class="form-control" />
			</div>
			<div class="form-group">
				<label>Flight Class: </label> <select class="form-control"
					name="flightClass">
					<option value="" selected>Select Class</option>
					<option value="B">Business</option>
					<option value="E">Economy</option>
				</select>
			</div>
			<div class="form-group">
				<label>Output Preference: </label> <select class="form-control"
					name="preference">
					<option value="" selected>Select Preference</option>
					<option value="F">Sort by fare</option>
					<option value="D">Sort by fare and duration</option>
				</select>
			</div>
			<div>
				<input id="querySubmit" type="Submit" value="Submit"
					class="btn btn-primary" />
			</div>
		</form>
	</div>
	<div id="footer-wrapper"></div>
	<script type="text/javascript" src="js/flights.js"></script>
</body>
</html>