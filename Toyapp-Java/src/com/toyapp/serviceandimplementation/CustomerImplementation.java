package com.toyapp.serviceandimplementation;

import java.util.Scanner;

import com.toyapp.beanclass.CustomerBean;
import com.toyapp.exceptions.InvalidNameException;
import com.toyapp.store.DataSet;

public class CustomerImplementation implements CustomerService
{
	
	private static Scanner scan = new Scanner(System.in);
	private static CustomerBean cBean = new CustomerBean();
	private static int customerId = 0;
	
	@Override
	public void insertCustomer() throws InvalidNameException {

		cBean.setCustomerId(customerId++);

		System.out.println("Please enter customer details: ");
		System.out.println("Full Name: ");cBean.setcustomerName(scan.nextLine());
		System.out.println("Password: ");cBean.setPassword(scan.next());
		System.out.println("City: ");cBean.setCity(scan.next());
		System.out.println("Zipcode");cBean.setZipCode(scan.nextInt());
		System.out.println("State: ");cBean.setState(scan.next());
		System.out.println("Country: ");cBean.setCountry(scan.next());

		DataSet.getCustomerList().add(new CustomerBean(cBean.getCustomerId(), cBean.getcustomerName(), cBean.getPassword(), 
				cBean.getCity(), cBean.getState(), cBean.getZipCode(), cBean.getCountry()));
		System.out.println("Customer "+cBean.getcustomerName()+" added successfully with ID: "+cBean.getCustomerId());
	}

	
	public CustomerBean searchCustomerByName(String customerName) {
		for (CustomerBean customer : DataSet.getCustomerList()) {
			if(customer.getcustomerName().equals(customerName)) {
				System.out.println("Customer is available");
				return customer;
			}
		}
		System.out.println("No customer found with given customer ID");
		return null;
	}
	
	@Override
	public CustomerBean searchCustomer(int customerId) {
		for (CustomerBean customer : DataSet.getCustomerList()) {
			if(customer.getCustomerId() == (customerId)) {
				System.out.println("Customer is available");
				return customer;
			}
		}
		System.out.println("No customer found with given customer ID");
		return null;
	}

	@Override
	public void displayCustomer(int customerId) {
		CustomerBean customer = searchCustomer(customerId);
		if(customer != null) {
			System.out.println(customer);
		}
	}
}
