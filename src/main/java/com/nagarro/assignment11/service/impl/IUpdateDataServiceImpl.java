package com.nagarro.assignment11.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.assignment11.service.IFileReader;

@Service("updateDataService")
public class IUpdateDataServiceImpl implements Runnable {

	@Autowired
	private IFileReader fileReader;

	boolean flag = true;

	@Override
	public void run() {
		while (flag) {
			boolean isUpdated = fileReader.isDataUpdated();
			if (isUpdated) {
				fileReader.loadDataFromFiles();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
