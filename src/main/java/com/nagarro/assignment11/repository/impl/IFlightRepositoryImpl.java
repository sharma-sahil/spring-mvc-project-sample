/**
 * @author sahilsharma
 */
package com.nagarro.assignment11.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.nagarro.assignment11.constant.Constant;
import com.nagarro.assignment11.dto.FlightQuery;
import com.nagarro.assignment11.model.FlightData;
import com.nagarro.assignment11.repository.IFlightRepository;

/**
 * The Class IFlightRepositoryImpl.
 */
@Repository("flightRepository")
@EnableTransactionManagement
public class IFlightRepositoryImpl implements IFlightRepository {

	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;

	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(IFlightRepositoryImpl.class);

	@Override
	public List<FlightData> getFlights(FlightQuery flightQuery) {
		List<FlightData> flights;

		TypedQuery<FlightData> typedQuery;
		try {
			if (Constant.FARE.equals(flightQuery.getPreference())) {
				typedQuery = entityManager.createNamedQuery(Constant.SORT_BY_FARE, FlightData.class);
			} else {
				typedQuery = entityManager.createNamedQuery(Constant.SORT_BY_FARE_AND_DURATION, FlightData.class);
			}

			typedQuery.setParameter(Constant.DEPARTURE_LOCATION, flightQuery.getDepartureLocation())
					.setParameter(Constant.ARRIVAL_LOCATION, flightQuery.getArrivalLocation())
					.setParameter(Constant.FLIGHT_DATE, flightQuery.getFlightDate());

			if (Constant.ECONOMY.equals(flightQuery.getFlightClass())) {
				typedQuery.setParameter(Constant.FLIGHT_CLASS, Constant.PATTERN_ECONOMY);
			} else {
				typedQuery.setParameter(Constant.FLIGHT_CLASS, Constant.PATTERN_BUSINESS);
			}
			flights = typedQuery.getResultList();

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			flights = null;
		}

		return flights;
	}

	@Override
	public void addFlight(FlightData flight) {
		try {
			entityManager.persist(flight);
			entityManager.flush();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
	}

	@Override
	public void deletePreviousRecord() {
		try {
			entityManager.createNativeQuery(Constant.DELETE_TABLE_QUERY).executeUpdate();
			entityManager.createNativeQuery(Constant.RESET_AUTO_INCREMENT).executeUpdate();

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
	}

	@Override
	public List<String> getDepartureLocations() {

		List<String> departureLocations = null;
		try {
			departureLocations = entityManager.createQuery(Constant.GET_DEPARTURE_LOCATIONS, String.class)
					.getResultList();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return departureLocations;
	}

	@Override
	public List<String> getArrivalLocation() {
		List<String> arrivalLocations = null;
		try {
			arrivalLocations = entityManager.createQuery(Constant.GET_ARRIVAL_LOCATIONS, String.class).getResultList();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return arrivalLocations;
	}
}
