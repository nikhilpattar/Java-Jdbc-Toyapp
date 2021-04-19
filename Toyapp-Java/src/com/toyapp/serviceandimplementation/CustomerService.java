package com.toyapp.serviceandimplementation;

import com.toyapp.beanclass.CustomerBean;
import com.toyapp.exceptions.InvalidNameException;

public interface CustomerService 
{
	
	CustomerBean searchCustomer(int customerId);
	
	void displayCustomer(int customerId);

	void insertCustomer() throws InvalidNameException;
}
