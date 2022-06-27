/**
 * @author sahilsharma
 */
package com.nagarro.assignment11.service;

import java.util.List;

import com.nagarro.assignment11.dto.FlightQuery;
import com.nagarro.assignment11.model.FlightData;

/**
 * The Interface IFlightService.
 */
public interface IFlightService {

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