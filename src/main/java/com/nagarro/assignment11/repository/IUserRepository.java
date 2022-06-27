/**
 * @author sahilsharma
 */
package com.nagarro.assignment11.repository;

import com.nagarro.assignment11.exception.AddUserException;
import com.nagarro.assignment11.model.User;

/**
 * The Interface IUserRepository.
 */
public interface IUserRepository {

	/**
	 * Checks if is valid user.
	 *
	 * @param user
	 *            the user
	 * @return true, if is valid user
	 */
	boolean isValidUser(User user);

	/**
	 * Adds the user.
	 *
	 * @param user the user
	 */
	void addUser(User user);

	/**
	 * Checks if is already registered.
	 *
	 * @param user the user
	 * @return true, if is already registered
	 * @throws AddUserException the add user exception
	 */
	boolean isAlreadyRegistered(User user) throws AddUserException;

}