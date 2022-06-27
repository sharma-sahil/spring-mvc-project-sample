/**

 * @author sahilsharma
 */
package com.nagarro.assignment11.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.nagarro.assignment11.constant.Constant;

/**
 * The Class FlightData.
 */
@Entity
@Table(name = "flightsdata")
@NamedQueries({ @NamedQuery(name = Constant.SORT_BY_FARE, query = Constant.QUERY_SORT_BY_FARE),
		@NamedQuery(name = Constant.SORT_BY_FARE_AND_DURATION, query = Constant.QUERY_SORT_BY_FARE_AND_DURATION) })
public class FlightData {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	/** The flight number. */
	private String flightNumber;

	/** The departure location. */
	private String departureLocation;

	/** The arrival location. */
	private String arrivalLocation;

	/** The fare. */
	private double fare;

	/** The seat availability. */
	private String seatAvailability;

	/** The flight time. */
	private String flightTime;

	/** The flight duration. */
	private String flightDuration;

	/** The flight class. */
	private String flightClass;

	/** The valid till. */
	private LocalDate validTill;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets the flight number.
	 *
	 * @return the flightNumber
	 */
	public String getFlightNumber() {
		return flightNumber;
	}

	/**
	 * Sets the flight number.
	 *
	 * @param flightNumber
	 *            the flightNumber to set
	 */
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
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
	 * Sets the departure location.
	 *
	 * @param departureLocation
	 *            the departureLocation to set
	 */
	public void setDepartureLocation(String departureLocation) {
		this.departureLocation = departureLocation;
	}

	/**
	 * Gets the arrival location.
	 *
	 * @return the arrivalLocation
	 */
	public String getArrivalLocation() {
		return arrivalLocation;
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
	 * Gets the fare.
	 *
	 * @return the fare
	 */
	public double getFare() {
		return fare;
	}

	/**
	 * Sets the fare.
	 *
	 * @param fare
	 *            the fare to set
	 */
	public void setFare(double fare) {
		this.fare = fare;
	}

	/**
	 * Gets the seat availability.
	 *
	 * @return the seatAvailability
	 */
	public String getSeatAvailability() {
		return seatAvailability;
	}

	/**
	 * Sets the seat availability.
	 *
	 * @param seatAvailability
	 *            the seatAvailability to set
	 */
	public void setSeatAvailability(String seatAvailability) {
		this.seatAvailability = seatAvailability;
	}

	/**
	 * Gets the flight time.
	 *
	 * @return the flightTime
	 */
	public String getFlightTime() {
		return flightTime;
	}

	/**
	 * Sets the flight time.
	 *
	 * @param flightTime
	 *            the flightTime to set
	 */
	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}

	/**
	 * Gets the flight duration.
	 *
	 * @return the flightDuration
	 */
	public String getFlightDuration() {
		return flightDuration;
	}

	/**
	 * Sets the flight duration.
	 *
	 * @param flightDuration
	 *            the flightDuration to set
	 */
	public void setFlightDuration(String flightDuration) {
		this.flightDuration = flightDuration;
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
	 * Sets the flight class.
	 *
	 * @param flightClass
	 *            the flightClass to set
	 */
	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}

	/**
	 * Gets the valid till.
	 *
	 * @return the validTill
	 */
	public LocalDate getValidTill() {
		return validTill;
	}

	/**
	 * Sets the valid till.
	 *
	 * @param validTill
	 *            the validTill to set
	 */
	public void setValidTill(LocalDate validTill) {
		this.validTill = validTill;
	}

}
