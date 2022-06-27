/**
 * @author sahilsharma
 */
package com.nagarro.assignment11.repository;

import java.util.List;

import com.nagarro.assignment11.dto.FlightQuery;
import com.nagarro.assignment11.model.FlightData;

/**
 * The Interface IFlightRepository.
 */
public interface IFlightRepository {

	/**
	 * Gets the flights.
	 *
	 * @param flightQuery
	 *            the flight query
	 * @return the flights
	 */
	List<FlightData> getFlights(FlightQuery flightQuery);

	/**
	 * Adds the flight.
	 *
	 * @param flight
	 *            the flight
	 */
	void addFlight(FlightData flight);

	/**
	 * Delete previous record.
	 */
	void deletePreviousRecord();

	/**
	 * Gets the departure locations.
	 *
	 * @return the departure locations
	 */
	List<String> getDepartureLocations();

	/**
	 * Gets the arrival location.
	 *
	 * @return the arrival location
	 */
	List<String> getArrivalLocation();

}