package com.toyapp.serviceandimplementation;

import java.sql.SQLException;

public interface ToyRentalService 
{
	boolean bookToy(int rentId, String rentalStartDate, String rentalEndDate, int rentalAmountPerDay, int totalAmount,
			int fine, String status, int customerId, int toyId) throws SQLException ;
	
	boolean returnToy(int rentalId, int fine, String status) throws SQLException;
	
	boolean getRentalDetails(int customerId) throws SQLException;
	
	boolean toyRentalDetails(int toyId) throws SQLException;
	
	int getTotalRentalAmount(int customerId) throws SQLException;
	
}
