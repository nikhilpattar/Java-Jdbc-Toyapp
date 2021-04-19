package com.toyapp.toytypes;

import com.toyapp.beanclass.ToyBean;

public class ElectricToy extends ToyBean{

	private int numberOfBatteries;
	private String operatingMode;
	
	public void setNumberOfBatteries(int numberOfBatteries) {
		this.numberOfBatteries = numberOfBatteries;
	}
	public void setOperatingMode(String operatingMode) {
		this.operatingMode = operatingMode;
	}
	public int getNumberOfBatteries() {
		return numberOfBatteries;
	}
	public String getOperatingMode() {
		return operatingMode;
	}
	
	
}
