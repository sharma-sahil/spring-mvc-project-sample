<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flights Result</title>

<link rel="stylesheet" href="css/flights-result.css" />
<link rel="stylesheet" href="css/bootstrap.min.css" >
<link rel="stylesheet" href="css/bootsrap-theme.min.css" >
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

	<c:if test="${ empty flights }">
		<div id="noFlightFound">No Flights Found for your Query. Please
			Try again.</div>
	</c:if>
	<a href="flights.html" class="btn btn-primary btn-back">BACK</a>
	<a href="logout.html" class="btn btn-primary btn-logout" >Logout</a>
	<div class="divTable">
		<table class="table table-bordered">
			<tr>
				<th>Flight Number</th>
				<th>Departure Location</th>
				<th>Arrival Location</th>
				<th>Flight Duration</th>
				<th>Flight Time</th>
				<th>Valid Till</th>
				<th>Fare</th>
				<th>Flight Class</th>
				<th>Availability</th>
			</tr>

			<c:forEach items="${ flights }" var="flight">
				<tr>
					<td>${ flight.flightNumber }</td>
					<td>${ flight.departureLocation }</td>
					<td>${ flight.arrivalLocation }</td>
					<td>${ flight.flightDuration }</td>
					<td>${ flight.flightTime }</td>
					<td>${ flight.validTill }</td>
					<td>${ flight.fare }</td>
					<td>${ flight.flightClass }</td>
					<td>${ flight.seatAvailability }</td>
				</tr>

			</c:forEach>

		</table>
	</div>
	<div id="footer-wrapper"></div>

</body>
</html>