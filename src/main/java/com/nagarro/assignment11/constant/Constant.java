/**
 * @author sahilsharma
 */
package com.nagarro.assignment11.constant;

/**
 * The Class Constant.
 */
public class Constant {

	/** The Constant DIRECTORY_PATH. */
	public static final String DIRECTORY_PATH = "/Users/sahilsharma/Documents/workspace/CSVfiles";
			
//			"C:\\Users\\sahilsharma\\workspace\\Assignment11-SpringMVC\\src\\main\\resources\\CSVfiles";

	/** The Constant DIRECTORY_CONNECTION_ERROR. */
	public static final String DIRECTORY_CONNECTION_ERROR = "Error connecting to Directory.";

	/** The Constant DELIMITER. */
	public static final String DELIMITER = "|";

	/** The Constant DATE_DELIMITER. */
	public static final String DATE_DELIMITER = "-";

	/** The Constant SORT_BY_FARE. */
	public static final String SORT_BY_FARE = "get_flights_sorted_by_fare";

	/** The Constant SORT_BY_FARE_AND_DURATION. */
	public static final String SORT_BY_FARE_AND_DURATION = "get_flights_sorted_by_fare_and_duration";

	/** The Constant SESSION_ATTR_LOGGED_IN. */
	public static final String SESSION_ATTR_LOGGED_IN = "loggedIn";

	/** The Constant USER. */
	public static final String USER = "user";

	/** The Constant USERNAME. */
	public static final String USERNAME = "username";

	/** The Constant USER_BINDING_ERROR. */
	public static final String USER_BINDING_ERROR = "Error in Binding User Object.";

	/** The Constant DEPARTURE_LOCATION. */
	public static final String DEPARTURE_LOCATION = "departureLocation";

	/** The Constant ARRIVAL_LOCATION. */
	public static final String ARRIVAL_LOCATION = "arrivalLocation";

	/** The Constant FLIGHT_CLASS. */
	public static final String FLIGHT_CLASS = "flightClass";

	/** The Constant FLIGHT_DATE. */
	public static final String FLIGHT_DATE = "flightDate";

	/** The Constant OUTPUT_PREFERENCE. */
	public static final String OUTPUT_PREFERENCE = "preference";

	/** The Constant FLIGHTS_RESULT_LIST. */
	public static final String FLIGHTS_RESULT_LIST = "flights";

	/** The Constant ECONOMY. */
	public static final String ECONOMY = "E";

	/** The Constant FARE. */
	public static final String FARE = "F";

	/** The Constant PATTERN_ECONOMY. */
	public static final String PATTERN_ECONOMY = "E%";

	/** The Constant PATTERN_BUSINESS. */
	public static final String PATTERN_BUSINESS = "%B";

	/*
	 * Queries
	 */

	/** The Constant QUERY_SORT_BY_FARE. */
	public static final String QUERY_SORT_BY_FARE = "SELECT f FROM FlightData f "
			+ "where f.departureLocation = :departureLocation AND f.arrivalLocation = :arrivalLocation "
			+ "AND f.validTill >= :flightDate AND f.flightClass LIKE :flightClass " 
			+ "ORDER BY f.fare ";

	/** The Constant QUERY_SORT_BY_FARE_AND_DURATION. */
	public static final String QUERY_SORT_BY_FARE_AND_DURATION = "SELECT f FROM FlightData f "
			+ "where f.departureLocation = :departureLocation AND f.arrivalLocation = :arrivalLocation "
			+ "AND f.validTill >= :flightDate  AND f.flightClass LIKE :flightClass "
			+ "ORDER BY f.fare,f.flightDuration ";

	/** The Constant DELETE_TABLE_QUERY. */
	public static final String DELETE_TABLE_QUERY = "DELETE FROM flight_search.flightsdata WHERE id >= 1";

	/** The Constant RESET_AUTO_INCREMENT. */
	public static final String RESET_AUTO_INCREMENT = "ALTER TABLE flight_search.flightsdata AUTO_INCREMENT = 1";

	/** The Constant GET_DEPARTURE_LOCATIONS. */
	public static final String GET_DEPARTURE_LOCATIONS = "SELECT DISTINCT departureLocation FROM FlightData";

	/** The Constant GET_ARRIVAL_LOCATIONS. */
	public static final String GET_ARRIVAL_LOCATIONS = "SELECT DISTINCT arrivalLocation FROM FlightData";
	/*
	 * jsp Pages
	 */

	/** The Constant LOGIN_PAGE. */
	public static final String LOGIN_PAGE = "login";

	/** The Constant FLIGHTS_PAGE. */
	public static final String FLIGHTS_PAGE = "flights";

	/** The Constant REDIRECT_FLIGHTS_PAGE. */
	public static final String REDIRECT_FLIGHTS_PAGE = "redirect:flights.html";

	/** The Constant REDIRECT_FLIGHTS_RESULT_PAGE. */
	public static final String FORWARD_TO_FLIGHTS_RESULT_PAGE = "forward:flights-result.html";

	/** The Constant REDIRECT_TO_LOGIN_PAGE. */
	public static final String REDIRECT_TO_LOGIN_PAGE = "redirect:login.html";

	/** The Constant FLIGHTS_RESULT_PAGE. */
	public static final String FLIGHTS_RESULT_PAGE = "flights-result";

	/** The Constant ATTR_DEPARTURE_LOCATIONS. */
	public static final String ATTR_DEPARTURE_LOCATIONS = "departureLocations";
	
	/** The Constant ATTR_ARRIVAL_LOCATIONS. */
	public static final String ATTR_ARRIVAL_LOCATIONS = "arrivalLocations";
	
	/** The Constant ATTR_LOGIN_ERROR. */
	public static final String ATTR_LOGIN_ERROR = "loginError";

	/** The Constant ATTR_LOGIN_ERROR_MESSAGE. */
	public static final String ATTR_LOGIN_ERROR_MESSAGE = "Invalid Login Details. Please Try Again.";

}
