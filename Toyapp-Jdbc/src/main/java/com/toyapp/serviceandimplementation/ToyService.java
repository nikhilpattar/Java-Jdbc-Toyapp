package com.toyapp.serviceandimplementation;

import java.sql.SQLException;

import com.toyapp.exceptions.InvalidAgeException;
import com.toyapp.exceptions.InvalidNameException;

public interface ToyService 
{
	
	void addToy(int toyId, String toyName, String toyType, int minAge, int maxAge, int price, int quantity,
			int rentalAmount) throws SQLException, InvalidNameException, InvalidAgeException;

	void displayToys() throws SQLException;
	
	void deleteToy(int toyId) throws SQLException;
}
