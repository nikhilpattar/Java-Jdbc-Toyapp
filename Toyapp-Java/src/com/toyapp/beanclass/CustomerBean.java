package com.toyapp.beanclass;

import com.toyapp.exceptions.InvalidNameException;

public class CustomerBean 
{
	private int customerId;
	private String customerName;
	private String password;
	private String city;
	private String state;
	private int zipCode;
	private String country;

	public CustomerBean() {
		super();
	}

	public CustomerBean(int customerId, String customerName, String password, String city, String state, int zipCode,
			String country) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.password = password;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.country = country;
	}

	@Override
	public String toString() {
		return "Customer Details: Name=" + customerName + ", City=" + city + ", State=" + state + ", ZipCode=" + zipCode + ", Country=" + country + "]";
	}

	public int getCustomerId() {
		return customerId;
	}
	public String getcustomerName() {
		return customerName;
	}
	public String getPassword() {
		return password;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public int getZipCode() {
		return zipCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public void setcustomerName(String customerName) throws InvalidNameException {
		if(isValid(customerName)) {
			this.customerName = customerName;
		}else {
			throw new InvalidNameException();
		}
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setZipCode(int zipCode) {

		this.zipCode = zipCode;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	private boolean isValid(String name) {

		char a[] = name.toLowerCase().toCharArray();
		for(int i = 0;i < a.length;i++) {
			if(!(a[i] >= 97 && a[i] <= 122 || a[i] == 32)) {
				return false;
			}
		}
		return true;
	}
}
