(function() {
	var querySubmit = document.getElementById("querySubmit");
	var errorMessage = document.getElementById("errorMessage");
	var errorBlock = document.getElementById("errorBlock");
	var departureLocation, arrivalLocation, flightDate, flightClass, preference;

	function submitClick() {
		departureLocation = document.forms["queryForm"]["departureLocation"].value;
		arrivalLocation = document.forms["queryForm"]["arrivalLocation"].value;
		flightDate = document.forms["queryForm"]["flightDate"].value;
		flightClass = document.forms["queryForm"]["flightClass"].value;
		preference = document.forms["queryForm"]["preference"].value;

		if (departureLocation == "") {
			showDiv();
			event.preventDefault();
			errorMessage.innerHTML = "Please Select Departure Location.";
		} else if (arrivalLocation == "") {
			showDiv();
			event.preventDefault();
			errorMessage.innerHTML = "Please Select Arrival Location";
		} else if (flightDate == "") {
			showDiv();
			event.preventDefault();
			errorMessage.innerHTML = "Please Select Travel Date.";
		} else if (flightClass == "") {
			showDiv();
			event.preventDefault();
			errorMessage.innerHTML = "Please Select Flight Class.";
		} else if (preference == "") {
			showDiv();
			event.preventDefault();
			errorMessage.innerHTML = "Please Select Output Preference.";
		}
	}

	function showDiv() {
		errorBlock.style.display = "block";
	}

	function init() {
		querySubmit.addEventListener('click', submitClick);
	}

	init();
})();