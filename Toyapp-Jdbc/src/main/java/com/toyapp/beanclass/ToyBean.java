package com.toyapp.beanclass;

import com.toyapp.exceptions.InvalidAgeException;
import com.toyapp.exceptions.InvalidNameException;

public class ToyBean 
{
	private int toyId;
	private String toyName;
	private String toyType;
	private int minAge;
	private int maxAge;
	private int price;
	private int quantity;
	private int rentalAmount;

	public ToyBean() {
		super();
	}

	@Override
	public String toString() {
		return "Toy Details\nToyId=" + toyId + ", ToyName=" + toyName + ", ToyType=" + toyType + ", minAge=" + minAge
				+ ", maxAge=" + maxAge + ", price=" + price + ", quantity=" + quantity + ", rentalAmount="
				+ rentalAmount + "]";
	}

	public int getToyId() {
		return toyId;
	}
	public String getToyName() {
		return toyName;
	}
	public String getToyType() {
		return toyType;
	}
	public int getMinAge() {
		return minAge;
	}
	public int getMaxAge() {
		return maxAge;
	}
	public int getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
	public int getRentalAmount() {
		return rentalAmount;
	}
	public void setToyId(int toyId) {
		this.toyId = toyId;
	}
	public void setToyName(String toyName) throws InvalidNameException {
		if(isValid(toyName)) {
			this.toyName = toyName;
		}else {
			throw new InvalidNameException();
		}
	}
	public void setToyType(String toyType) {
		this.toyType = toyType;
	}
	public void setMinAge(int minAge) throws InvalidAgeException {
		if(minAge <= 0) {
			throw new InvalidAgeException();
		}else {
			this.minAge = minAge;
		}
	}
	public void setMaxAge(int maxAge) throws InvalidAgeException {
		if(maxAge > 12) {
			throw new InvalidAgeException();
		}else {
			this.maxAge = maxAge;
		}
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setRentalAmount(int rentalAmount) {
		this.rentalAmount = rentalAmount;
	}
	
	private boolean isValid(String name) {

		if(name.length() < 6) {
			System.out.println(name.length());
			return false;
		}
		
		char a[] = name.toLowerCase().toCharArray();
		for(int i = 0;i < a.length;i++) {
			if(!(a[i] >= 97 && a[i] <= 122 || a[i] == 32)) {
				System.out.println(a[i]);
				return false;
			}
		}
		return true;
	}
}
