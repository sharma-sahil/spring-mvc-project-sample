/**
 * @author sahilsharma
 */
package com.nagarro.assignment11.dto;

import java.time.LocalDate;

/**
 * The Class FlightQuery.
 */
public class FlightQuery {

	/** The departure location. */
	private String departureLocation;

	/** The arrival location. */
	private String arrivalLocation;

	/** The flight class. */
	private String flightClass;

	/** The flight date. */
	private LocalDate flightDate;

	/** The preference. */
	private String preference;

	/**
	 * Gets the arrival location.
	 *
	 * @return the arrivalLocation
	 */
	public String getArrivalLocation() {
		return arrivalLocation;
	}

	/**
	 * Gets the departure location.
	 *
	 * @return the departureLocation
	 */
	public String getDepartureLocation() {
		return departureLocation;
	}

	/**
	 * Gets the flight class.
	 *
	 * @return the flightClass
	 */
	public String getFlightClass() {
		return flightClass;
	}

	/**
	 * Gets the flight date.
	 *
	 * @return the flight date
	 */
	public LocalDate getFlightDate() {
		return flightDate;
	}

	/**
	 * Gets the preference.
	 *
	 * @return the preference
	 */
	public String getPreference() {
		return preference;
	}

	/**
	 * Sets the arrival location.
	 *
	 * @param arrivalLocation
	 *            the arrivalLocation to set
	 */
	public void setArrivalLocation(String arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}

	/**
	 * Sets the departure location.
	 *
	 * @param departureLocation
	 *            the departureLocation to set
	 */
	public void setDepartureLocation(String departureLocation) {
		this.departureLocation = departureLocation;
	}

	/**
	 * Sets the flight class.
	 *
	 * @param flightClass
	 *            the flightClass to set
	 */
	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}

	/**
	 * Sets the flight date.
	 *
	 * @param flightDate
	 *            the new flight date
	 */
	public void setFlightDate(LocalDate flightDate) {
		this.flightDate = flightDate;
	}

	/**
	 * Sets the preference.
	 *
	 * @param preference
	 *            the preference to set
	 */
	public void setPreference(String preference) {
		this.preference = preference;
	}

}
