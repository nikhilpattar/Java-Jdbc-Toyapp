package com.toyapp.pagesandtransactions;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

import com.toyapp.beanclass.*;
import com.toyapp.exceptions.DateMismatchException;
import com.toyapp.exceptions.InvalidNameException;
import com.toyapp.serviceandimplementation.*;

public class Transactions 
{
	private static Scanner scan = new Scanner(System.in);

	private static CustomerBean cBean = new CustomerBean();
	private static RentalBean rBean = new RentalBean();
	private static ToyBean tBean = new ToyBean();

	private static CustomerImplementation customerService = new CustomerImplementation();
	private static ToyRentalImplementation toyRental = new ToyRentalImplementation();
	private static ToyImplementation toyService = new ToyImplementation();

	static void toyRentalDetails()  throws SQLException {
		
		System.out.println("Available toys: ");
		toyService.displayToys();
		
		System.out.println("Enter Toy Id to get details: ");tBean.setToyId(scan.nextInt());
		if(toyRental.toyRentalDetails(tBean.getToyId())) {
			System.out.println("No rentals to display");
		}
	}
	
	static void rentalDetails() throws SQLException {
		
		System.out.println("Please find your rental details:\n");
		if(toyRental.getRentalDetails(cBean.getCustomerId())) {
			System.out.println("No rentals to display");
		}
	}

	static void totalRentalAmount() throws SQLException {
		
		System.out.println("\nTotal rental amount: "+toyRental.getTotalRentalAmount(cBean.getCustomerId()));
	}

	public static boolean signedUp() throws InvalidNameException, SQLException {

		// Login to set unique customer Id each time method invoked 
		cBean.setCustomerId(customerService.getMaxCustomerId() + 1);

		//Set Sign up details from user using scanner
		System.out.println("Please enter following details: ");
		System.out.println("Full Name: ");cBean.setcustomerName(scan.nextLine());
		System.out.println("Password: ");cBean.setPassword(scan.next());
		System.out.println("City: ");cBean.setCity(scan.next());
		System.out.println("Zipcode");cBean.setZipCode(scan.nextInt());
		System.out.println("State: ");cBean.setState(scan.next());
		System.out.println("Country: ");cBean.setCountry(scan.next());


		if(customerService.addCustomer(cBean.getCustomerId(), cBean.getcustomerName(), cBean.getPassword(), 
				cBean.getCity(), cBean.getState(), cBean.getZipCode(), cBean.getCountry())) {

			System.out.println(cBean.getcustomerName()+" ,you're registered successfully"
					+"\nPlease note down your Customer ID for future login: "+cBean.getCustomerId()+"\n");
			return true;
		}else {
			return false;
		}

	}

	static boolean loggedIn() throws SQLException, InvalidNameException {

		System.out.println("Customer Id: ");cBean.setCustomerId(scan.nextInt());
		System.out.println("Password: ");cBean.setPassword(scan.next());

		if(customerService.validateCustomer(cBean.getCustomerId(), cBean.getPassword())) {
			System.out.println("Logged in succcessfully");
			return true;
		}else {
			System.out.println("Invalid credentials, Try again");
			return false;
		}
	}

	private static int getTotalAmount() {

		// Calculate total amount to be paid, using => Number of rental days * Rental amount per day
		int totalDays = (int) ChronoUnit.DAYS.between(LocalDate.parse(rBean.getRentalStartDate()), LocalDate.parse(rBean.getRentalEndDate()));
		return totalDays * rBean.getRentalAmountPerDay();
	}

	static boolean rentedToy() throws SQLException, InvalidNameException, DateMismatchException {

		//Display available toys from database
		System.out.println("Available toys: ");
		toyService.displayToys();

		//Set rental details from customer using scanner 
		rBean.setRentId(toyRental.getMaxRentalId() + 1);
		System.out.println("Enter Toy Id to rent :");tBean.setToyId(scan.nextInt());
		System.out.println("Rental Start Date in yyyy-mm-dd format ");rBean.setRentalStartDate(scan.next());
		System.out.println("Rental End Date in yyyy-mm-dd format ");rBean.setRentalEndDate(scan.next());
		rBean.setRentalAmountPerDay(toyService.getToyAmount(tBean.getToyId()));
		rBean.setTotalAmount(getTotalAmount());
		rBean.setFine(0);
		rBean.setStatus("Booked");

		if(toyRental.bookToy(rBean.getRentId(), rBean.getRentalStartDate(), rBean.getRentalEndDate(), 
				rBean.getRentalAmountPerDay(), rBean.getTotalAmount(), rBean.getFine(), rBean.getStatus(),cBean.getCustomerId(), tBean.getToyId())) {
			System.out.println("Toy booked successfully with Renatl Id: "+rBean.getRentId()+", You can choose option 3 to view rental details");
			return true;
		}else {
			System.out.println("Failed to book a toy, Please try again");
			return false;
		}
	}

	static boolean returnedToy() throws SQLException, InvalidNameException {

		//Display rental history off customer
		System.out.println("Please find you rental details and select Rental Id to process your return");
		if(toyRental.getRentalDetails(cBean.getCustomerId())) {
			System.out.println("No rentals to display");
			return false;
		}

		System.out.println("\nEnter Rental Id to process return of toy:");rBean.setRentId(scan.nextInt());
		getFineAmount();
		if(toyRental.returnToy(rBean.getRentId(), rBean.getFine(), rBean.getStatus())) {
			System.out.println("Toy returned successfully");
			return true;
		}else {
			System.out.println("Failed to return toy, Please try again");
			return false;
		}
	}

	private static void getFineAmount() throws SQLException {
		//Login to calculate fine amount if customer is returning toy post rental end date,
		// Fine amount = Days laps * Rental amount per day

		int referenceDate = (int) ChronoUnit.DAYS.between(LocalDate.now(), 
				LocalDate.parse(toyRental.getRentalEndDate(rBean.getRentId())));
		if( referenceDate >= 0) {
			rBean.setFine(0);
			rBean.setStatus("Returned");
		}else {
			rBean.setFine(Math.abs(referenceDate) * toyRental.getToyRentalAmount(rBean.getRentId()));
			rBean.setStatus("Fined");
		}
	}
}
