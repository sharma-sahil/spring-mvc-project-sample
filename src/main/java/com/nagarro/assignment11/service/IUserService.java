/**
 * @author sahilsharma
 */
package com.nagarro.assignment11.service;

import java.util.Map;

import com.nagarro.assignment11.exception.AddUserException;
import com.nagarro.assignment11.model.User;

public interface IUserService {

	/**
	 * Checks if is valid user.
	 *
	 * @param user
	 *            the user
	 * @return true, if is valid user
	 */
	boolean isValidUser(User user);

	/**
	 * Checks if is valid details.
	 *
	 * @param parameters
	 *            the parameters
	 * @return true, if is valid details
	 * @throws AddUserException 
	 */
	boolean isValidDetails(Map<String, String> parameters) throws AddUserException;

	/**
	 * Adds the user.
	 *
	 * @param user the user
	 * @throws AddUserException 
	 */
	void addUser(User user) throws AddUserException;

}
