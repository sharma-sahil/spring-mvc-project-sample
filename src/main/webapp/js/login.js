(function() {
	var username, password;
	var loginSubmit = document.getElementById("loginSubmit");
	var errorOutput = document.getElementById("errorOutput");
	var errorBlock = document.getElementById("errorBlock");

	function showDiv() {
		errorBlock.style.display = "block";
	}

	function submitClick() {
		username = document.forms["loginForm"]["username"].value;
		password = document.forms["loginForm"]["password"].value;

		if (username == "") {
			showDiv();
			event.preventDefault();
			errorOutput.innerHTML = "Username can not be empty.";
		} else if (password == "") {
			showDiv();
			event.preventDefault();
			errorOutput.innerHTML = "Password can not be empty.";
		}
	}

	function init() {
		loginSubmit.addEventListener('click', submitClick);
	}

	init();
})();