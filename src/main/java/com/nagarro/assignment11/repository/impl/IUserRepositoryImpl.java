/**
 * @author sahilsharma
 */
package com.nagarro.assignment11.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.nagarro.assignment11.constant.Constant;
import com.nagarro.assignment11.exception.AddUserException;
import com.nagarro.assignment11.model.User;
import com.nagarro.assignment11.repository.IUserRepository;

/**
 * The Class IUserRepositoryImpl.
 */
@Repository("userRepository")
@EnableTransactionManagement
public class IUserRepositoryImpl implements IUserRepository {

	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;

	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(IUserRepositoryImpl.class);

	@Override
	public boolean isValidUser(User user) {
		boolean retVal;
		try {

			CriteriaBuilder builder = entityManager.getCriteriaBuilder();
			CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
			Root<User> root = criteriaQuery.from(User.class);

			criteriaQuery.select(root).where(builder.equal(root.get(Constant.USERNAME), user.getUsername()));

			List<User> users = entityManager.createQuery(criteriaQuery).getResultList();

			if (users.isEmpty() || users.size() > 1) {
				retVal = false;
			} else if (!users.get(0).getPassword().equals(user.getPassword())) {
				retVal = false;
			} else {
				retVal = true;
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			retVal = false;
		}
		return retVal;
	}

	@Override
	public boolean isAlreadyRegistered(User user) throws AddUserException {
		boolean retVal = true;
		try {

			CriteriaBuilder builder = entityManager.getCriteriaBuilder();
			CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
			Root<User> root = criteriaQuery.from(User.class);

			criteriaQuery.select(root).where(builder.equal(root.get(Constant.USERNAME), user.getUsername()));

			List<User> users = entityManager.createQuery(criteriaQuery).getResultList();

			if (users.isEmpty()) {
				retVal = false;
			} else {
				retVal = true;
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw new AddUserException("Server Error. Please try Again");
		}

		return retVal;
	}

	@Override
	public void addUser(User user) {
		try {
			entityManager.persist(user);
			entityManager.flush();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
	}

}
