package com.toyapp.serviceandimplementation;

import com.toyapp.beanclass.ToyBean;
import com.toyapp.exceptions.InvalidAgeException;
import com.toyapp.exceptions.InvalidNameException;

public interface ToyService 
{
	void insertToy() throws InvalidNameException, InvalidAgeException;
	
	void displayToy(int toyId);
	
	ToyBean searchToy(int toyId);
}
