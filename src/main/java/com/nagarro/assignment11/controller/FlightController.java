/**
 * @author sahilsharma
 */
package com.nagarro.assignment11.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagarro.assignment11.constant.Constant;
import com.nagarro.assignment11.dto.FlightQuery;
import com.nagarro.assignment11.model.FlightData;
import com.nagarro.assignment11.service.IFlightService;

/**
 * The Class FlightController.
 */
@Controller
public class FlightController {

	/** The flight service. */
	@Autowired
	private IFlightService flightService;

	/**
	 * Query.
	 *
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/flights", method = RequestMethod.GET)
	public String query(Model model, HttpServletRequest request) {
		Boolean isLoggedIn = (Boolean) request.getSession().getAttribute(Constant.SESSION_ATTR_LOGGED_IN);
		if (null != isLoggedIn && isLoggedIn) {
			model.addAttribute(Constant.ATTR_DEPARTURE_LOCATIONS, flightService.getDepartureLocations());
			model.addAttribute(Constant.ATTR_ARRIVAL_LOCATIONS, flightService.getArrivalLocation());
			return Constant.FLIGHTS_PAGE;
		} else {
			return Constant.REDIRECT_TO_LOGIN_PAGE;
		}
	}

	/**
	 * Post query.
	 *
	 * @param params
	 *            the params
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/flights", method = RequestMethod.POST)
	public String postQuery(@RequestParam Map<String, String> params, Model model) {

		FlightQuery query = new FlightQuery();

		query.setDepartureLocation(params.get(Constant.DEPARTURE_LOCATION));
		query.setArrivalLocation(params.get(Constant.ARRIVAL_LOCATION));
		query.setFlightClass(params.get(Constant.FLIGHT_CLASS));
		query.setFlightDate(getDate(params.get(Constant.FLIGHT_DATE)));
		query.setPreference(params.get(Constant.OUTPUT_PREFERENCE));

		List<FlightData> flights = flightService.getFlights(query);
		model.addAttribute(Constant.FLIGHTS_RESULT_LIST, flights);

		return Constant.FORWARD_TO_FLIGHTS_RESULT_PAGE;
	}

	/**
	 * Gets the flights result.
	 *
	 * @return the flights result
	 */
	@RequestMapping(value = "/flights-result")
	public String getFlightsResult(HttpServletRequest request) {
		Boolean isLoggedIn = (Boolean) request.getSession().getAttribute(Constant.SESSION_ATTR_LOGGED_IN);
		if (null != isLoggedIn && isLoggedIn) {
			return Constant.FLIGHTS_RESULT_PAGE;
		} else {
			return Constant.REDIRECT_TO_LOGIN_PAGE;
		}
	}

	/**
	 * Gets the date.
	 *
	 * @param flightDate
	 *            the flight date
	 * @return the date
	 */
	private LocalDate getDate(String flightDate) {
		LocalDate newDate;
		StringTokenizer tokenizer = new StringTokenizer(flightDate, Constant.DATE_DELIMITER);
		int year = Integer.parseInt(tokenizer.nextToken());
		int month = Integer.parseInt(tokenizer.nextToken());
		int day = Integer.parseInt(tokenizer.nextToken());
		newDate = LocalDate.of(year, month, day);

		return newDate;
	}

}
