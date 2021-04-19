package com.toyapp.serviceandimplementation;

import java.sql.SQLException;

import com.toyapp.exceptions.InvalidNameException;

public interface CustomerService 
{
	boolean addCustomer(int customerId, String customerName, String password, String city, String state, int zipCode,
			String country) throws InvalidNameException, SQLException;
	
	
	void displayCustomer(int customerId) throws SQLException;
}
