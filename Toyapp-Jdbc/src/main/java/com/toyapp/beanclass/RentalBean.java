package com.toyapp.beanclass;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.toyapp.exceptions.DateMismatchException;

public class RentalBean 
{
	private int rentalId;
	private String rentalStartDate;
	private String rentalEndDate;
	private int rentalAmountPerDay;
	private int totalAmount;
	private int fine;
	private String status;

	public void setRentId(int rentalId) {
		this.rentalId = rentalId;
	}
	public void setRentalStartDate(String rentalStartDate) {
		this.rentalStartDate = rentalStartDate;
	}
	public void setRentalEndDate(String rentalEndDate) throws DateMismatchException {
		if((ChronoUnit.DAYS.between(LocalDate.parse(rentalStartDate), LocalDate.parse(rentalEndDate)) <= 0)) {
			throw new DateMismatchException();
		}else {
			this.rentalEndDate = rentalEndDate;
		}
	}
	public void setRentalAmountPerDay(int rentalAmountPerDay) {
		this.rentalAmountPerDay = rentalAmountPerDay;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public void setFine(int fine) {
		this.fine = fine;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getRentId() {
		return rentalId;
	}
	public String getRentalStartDate() {
		return rentalStartDate;
	}
	public String getRentalEndDate() {
		return rentalEndDate;
	}
	public int getRentalAmountPerDay() {
		return rentalAmountPerDay;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public int getFine() {
		return fine;
	}
	public String getStatus() {
		return status;
	}
}
