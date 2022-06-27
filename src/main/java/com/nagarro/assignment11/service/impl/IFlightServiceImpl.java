/**
 * @author sahilsharma
 */
package com.nagarro.assignment11.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.assignment11.dto.FlightQuery;
import com.nagarro.assignment11.model.FlightData;
import com.nagarro.assignment11.repository.IFlightRepository;
import com.nagarro.assignment11.service.IFlightService;

/**
 * The Class IFlightServiceImpl.
 */
@Service("flightService")
public class IFlightServiceImpl implements IFlightService {

	/** The flight repository. */
	@Autowired
	private IFlightRepository flightRepository;

	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(IFlightServiceImpl.class);

	@Override
	public List<FlightData> getFlights(FlightQuery flightQuery) {
		List<FlightData> flights;
		try {
			synchronized (flightRepository) {
				flights = flightRepository.getFlights(flightQuery);
			}
		} catch (Exception e) {
			flights = null;
			LOGGER.error(e.getMessage());
		}
		return flights;
	}

	@Override
	@Transactional
	public void addFlight(FlightData flight) {
		try {
			synchronized (flightRepository) {
				flightRepository.addFlight(flight);
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
	}

	@Override
	public List<String> getDepartureLocations() {
		List<String> depLocations;
		synchronized (flightRepository) {
			depLocations = flightRepository.getDepartureLocations();
		}
		return depLocations;
	}

	@Override
	public List<String> getArrivalLocation() {
		List<String> arrLocations;
		synchronized (flightRepository) {
			arrLocations = flightRepository.getArrivalLocation();
		}
		return arrLocations;
	}

}
