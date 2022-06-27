package com.nagarro.assignment11.service.impl;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.assignment11.exception.AddUserException;
import com.nagarro.assignment11.model.User;
import com.nagarro.assignment11.repository.IUserRepository;
import com.nagarro.assignment11.service.IUserService;

@Service("userService")
public class IUserServiceImpl implements IUserService {

	/** The user repository. */
	@Autowired
	private IUserRepository userRepository;

	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(IUserServiceImpl.class);

	@Override
	public boolean isValidUser(User user) {
		boolean isValidUser;
		try {
			isValidUser = userRepository.isValidUser(user);
		} catch (Exception e) {
			isValidUser = false;
			LOGGER.error(e.getMessage());
		}
		return isValidUser;
	}

	@Override
	public boolean isValidDetails(Map<String, String> parameters) throws AddUserException {
		boolean isValidDetails = true;
		String errorMessage = "";
		if (parameters.get("username").isEmpty()) {
			errorMessage = "username cannot be empty.";
			isValidDetails = false;
		} else if (isValidDetails && parameters.get("password").isEmpty()) {
			errorMessage = "password cannot be empty.";
			isValidDetails = false;
		} else if (isValidDetails && parameters.get("confirmPassword").isEmpty()) {
			errorMessage = "Confirm password cannot be empty.";
			isValidDetails = false;
		}
		if (isValidDetails) {
			if (!parameters.get("password").equals(parameters.get("confirmPassword"))) {
				errorMessage = "password and confirm password must match";
				isValidDetails = false;
			}
		}
		if (!isValidDetails) {
			throw new AddUserException(errorMessage);
		}
		return isValidDetails;
	}

	@Override
	@Transactional
	public void addUser(User user) throws AddUserException {
		if (!userRepository.isAlreadyRegistered(user)) {
			try {
				userRepository.addUser(user);
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
				throw new AddUserException("Server Error. Please Try again.");
			}
		} else {
			throw new AddUserException("This username already exists. Please try again.");
		}
	}

}
