package com.toyapp.toytypes;

import com.toyapp.beanclass.ToyBean;

public class MusicalToy extends ToyBean{

	private int numberOfSpeakers;

	public void setNumberOfSpeakers(int numberOfSpeakers) {
		this.numberOfSpeakers = numberOfSpeakers;
	}

	public int getNumberOfSpeakers() {
		return numberOfSpeakers;
	}
	
}
