/**
 * @author sahilsharma
 */
package com.nagarro.assignment11.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagarro.assignment11.constant.Constant;
import com.nagarro.assignment11.model.User;
import com.nagarro.assignment11.service.IUserService;
import com.nagarro.assignment11.service.impl.IUpdateDataServiceImpl;

/**
 * The Class LoginController.
 */
@Controller
public class LoginController {

	@Autowired
	private IUserService userService;

	/** The update data service. */
	@Autowired
	private IUpdateDataServiceImpl updateDataService;

	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(LoginController.class);

	/** The boolean is thread started. */
	private static boolean isThreadStarted = false;

	/**
	 * Login.
	 *
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, HttpServletRequest request) {
		Boolean isLoggedIn = (Boolean) request.getSession().getAttribute(Constant.SESSION_ATTR_LOGGED_IN);
		if (null != isLoggedIn && isLoggedIn) {
			return Constant.REDIRECT_FLIGHTS_PAGE;
		} else {
			updateFlightsData();
			User user = new User();
			model.addAttribute(Constant.USER, user);
			return Constant.LOGIN_PAGE;
		}
	}

	/**
	 * Do login.
	 *
	 * @param user
	 *            the user
	 * @param result
	 *            the result
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLogin(@ModelAttribute(Constant.USER) User user, BindingResult result, Model model,
			HttpServletRequest request) {
		if (!result.hasErrors()) {
			if (userService.isValidUser(user)) {
				request.getSession().setAttribute(Constant.SESSION_ATTR_LOGGED_IN, true);
				return Constant.REDIRECT_FLIGHTS_PAGE;
			} else {
				model.addAttribute(Constant.ATTR_LOGIN_ERROR, Constant.ATTR_LOGIN_ERROR_MESSAGE);
				return Constant.LOGIN_PAGE;
			}
		} else {
			LOGGER.error(Constant.USER_BINDING_ERROR);
			return Constant.LOGIN_PAGE;
		}
	}

	@RequestMapping(value = "/logout")
	public String doLogout(Model model, HttpServletRequest request) {
		request.getSession().invalidate();
		return Constant.REDIRECT_TO_LOGIN_PAGE;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerUser(@RequestParam Map<String, String> parameters, Model model) {

		try {
			if (userService.isValidDetails(parameters)) {
				User user = new User();
				user.setUsername(parameters.get("username"));
				user.setPassword(parameters.get("password"));
				userService.addUser(user);
			}
		} catch (Exception e) {
			model.addAttribute("registerError", e.getMessage());
			return "register";
		}
		return Constant.REDIRECT_TO_LOGIN_PAGE;
	}

	/**
	 * Update flights data.
	 */
	private void updateFlightsData() {
		if (!isThreadStarted) {
			Thread t = new Thread(updateDataService);
			t.start();
			isThreadStarted = true;
		}
	}

}
