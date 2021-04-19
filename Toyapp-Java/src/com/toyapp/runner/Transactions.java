package com.toyapp.runner;

import java.util.Scanner;

import com.toyapp.exceptions.InvalidAgeException;
import com.toyapp.exceptions.InvalidNameException;
import com.toyapp.serviceandimplementation.CustomerImplementation;
import com.toyapp.serviceandimplementation.ToyImplementation;

public class Transactions 
{
	
	private static Scanner scan = new Scanner(System.in);
	private static CustomerImplementation customerService = new CustomerImplementation();
	private static ToyImplementation toyService = new ToyImplementation();
	
	public static void run() throws InvalidNameException, InvalidAgeException {
		System.out.println("Please choose an option: \n1. Toy\n2. Customer\n3. Exit");
		int optTwo = scan.nextInt();
		if(optTwo == 1) {
			toyFuntions();
		}else if(optTwo == 2) {
			customerFuntions();
		}else if(optTwo == 3) {
			System.out.println("********* Thank you for using our services *********");
			System.exit(0);
		}
	}
	
	public static void toyFuntions() throws InvalidNameException, InvalidAgeException {
		System.out.println("Please choose following option:\n1. Add Toy\n2. Display Toy\n3. Search Toy by Id\n4. Search Toy by Name"
				+ "\n5. Back To Main menu");
		int optOne = scan.nextInt();
		if(optOne == 1) {
			toyService.insertToy();
			toyFuntions();
		}else if(optOne == 2) {
			System.out.println("Enter Toy Id: ");
			toyService.displayToy(scan.nextInt());
			toyFuntions();
		}else if(optOne == 3) {
			System.out.println("Enter Toy Id: ");
			toyService.searchToy(scan.nextInt());
			toyFuntions();
		}else if(optOne == 4) {
			System.out.println("Enter Toy Name: ");
			toyService.searchToyByName(scan.nextLine());
			toyFuntions();
		}else if(optOne == 5) {
			run();
		}
	}
	
	public static void customerFuntions() throws InvalidNameException, InvalidAgeException {
		System.out.println("Please choose following option:\n1. Add Customer\n2. Display Customer\n3. Search Cutomer By Id\n"
				+ "4. Search Customer By Name\n5. Back To Main Menu");
		int optOne = scan.nextInt();
		if(optOne == 1) {
			customerService.insertCustomer();
			customerFuntions();
		}else if(optOne == 2) {
			System.out.println("Enter customer Id: ");
			customerService.displayCustomer(scan.nextInt());
			customerFuntions();
		}else if(optOne == 3) {
			System.out.println("Enter customerr Id: ");
			customerService.searchCustomer(scan.nextInt());
			customerFuntions();
		}else if(optOne == 4) {
			System.out.println("Enter customerr Id: ");
			customerService.searchCustomerByName(scan.nextLine());
			customerFuntions();
		}else if(optOne == 5) {
			run();
		}
	}
}
