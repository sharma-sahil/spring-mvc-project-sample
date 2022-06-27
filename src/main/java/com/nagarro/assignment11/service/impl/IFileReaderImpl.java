/**
 * @author sahilsharma
 */
package com.nagarro.assignment11.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.assignment11.constant.Constant;
import com.nagarro.assignment11.model.FlightData;
import com.nagarro.assignment11.repository.IFlightRepository;
import com.nagarro.assignment11.service.IFileReader;

/**
 * The Class IFileReaderImpl.
 */
@Service("fileReader")
public class IFileReaderImpl implements IFileReader {

	@Autowired
	private IFlightRepository flightRepository;

	/** The directory. */
	private File directory;

	/** The last modified. */
	private static long lastModified = Long.MIN_VALUE;

	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(IFileReaderImpl.class);

	public IFileReaderImpl() {
		try {
			directory = new File(Constant.DIRECTORY_PATH);
		} catch (Exception e) {
			LOGGER.error(Constant.DIRECTORY_CONNECTION_ERROR);
		}
	}

	@Override
	@Transactional
	public void loadDataFromFiles() {
		String input;
		StringTokenizer tokenizer;
		synchronized (flightRepository) {

			try {
				lastModified = directory.lastModified();
				Path dir = Paths.get(Constant.DIRECTORY_PATH);
				try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {

					for (Path entry : stream) {
						try (BufferedReader reader = Files.newBufferedReader(Paths.get(entry.toString()))) {
							input = reader.readLine();
							while ((input = reader.readLine()) != null) {
								tokenizer = new StringTokenizer(input, Constant.DELIMITER);
								flightRepository.addFlight(getFlightObject(tokenizer));
							}
						} catch (Exception e) {
							LOGGER.error(e.getMessage());
						}
					}
				} catch (Exception e) {
					LOGGER.error(e.getMessage());
				} finally {
				}
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
			}
		}

	}

	@Override
	@Transactional
	public boolean isDataUpdated() {
		boolean retVal = false;
		if (directory.lastModified() > lastModified) {
			flightRepository.deletePreviousRecord();
			retVal = true;
		}
		return retVal;
	}

	/**
	 * Gets the flight object.
	 *
	 * @param flightRecord
	 *            the flight record
	 * @return the flight object
	 */
	private FlightData getFlightObject(StringTokenizer flightRecord) {

		FlightData flightData = new FlightData();

		flightData.setFlightNumber(flightRecord.nextToken());
		flightData.setDepartureLocation(flightRecord.nextToken());
		flightData.setArrivalLocation(flightRecord.nextToken());
		flightData.setValidTill(getDate(flightRecord.nextToken()));
		flightData.setFlightTime(flightRecord.nextToken());
		flightData.setFlightDuration(flightRecord.nextToken());
		flightData.setFare(Double.parseDouble(flightRecord.nextToken()));
		flightData.setSeatAvailability(flightRecord.nextToken());
		flightData.setFlightClass(flightRecord.nextToken());

		return flightData;

	}

	/**
	 * Gets the date.
	 *
	 * @param date
	 *            the date
	 * @return the date
	 */
	private LocalDate getDate(String date) {
		StringTokenizer st = new StringTokenizer(date, "-");
		int day = Integer.parseInt(st.nextToken());
		int month = Integer.parseInt(st.nextToken());
		int year = Integer.parseInt(st.nextToken());

		return LocalDate.of(year, month, day);
	}

}
