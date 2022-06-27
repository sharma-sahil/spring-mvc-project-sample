(function() {
	var username, password,confirmPassword;
	var registerSubmit = document.getElementById("registerSubmit");
	var errorOutput = document.getElementById("errorOutput");
	var errorBlock = document.getElementById("errorBlock");

	function showDiv() {
		errorBlock.style.display = "block";
	}

	function submitClick() {
		username = document.forms["registerForm"]["username"].value;
		password = document.forms["registerForm"]["password"].value;
		confirmPassword = document.forms["registerForm"]["password"].value;

		if (username == "") {
			showDiv();
			event.preventDefault();
			errorOutput.innerHTML = "Username can not be empty.";
		} else if (password == "") {
			showDiv();
			event.preventDefault();
			errorOutput.innerHTML = "Password can not be empty.";
		}else if(confirmPassword == ""){
			showDiv();
			event.preventDefault();
			errorOutput.innerHTMl = "Confirm Password can not be empty.";
		}
	}

	function init() {
		registerSubmit.addEventListener('click', submitClick);
	}

	init();
})();