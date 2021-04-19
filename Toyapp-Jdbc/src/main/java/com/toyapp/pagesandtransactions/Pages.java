package com.toyapp.pagesandtransactions;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.toyapp.connection.ConnectionDAO;
import com.toyapp.exceptions.DateMismatchException;
import com.toyapp.exceptions.InvalidNameException;

public class Pages extends Transactions
{
	private static Scanner scan = new Scanner(System.in);
	private static Connection con = ConnectionDAO.getConnection();
	
	public static void transactionPage() throws SQLException, InvalidNameException, DateMismatchException {
		System.out.println("\nPlease choose an option:\n1. Book a Toy\n2. Return Toy\n3. Get Rental Details\n4. Get Total Rental Amount"
				+ "\n5. Toy Rental Details\n6. Back To Login Page");
		int selectOne = scan.nextInt();
		
		if(selectOne == 1) {
			if(rentedToy()) {
				con.commit();
			}else {
				con.rollback();
			}
		}else if(selectOne == 2) {
			if(returnedToy()) {
				con.commit();
			}else {
				con.rollback();
			}
		}else if(selectOne == 3) {
			rentalDetails();
		}else if(selectOne == 4) {
			totalRentalAmount();
		}else if(selectOne == 5) {
			toyRentalDetails();
		}else if(selectOne == 6) {
			loginOrSignupPage();
		}
		transactionPage();
	}


	public static void loginOrSignupPage() throws SQLException, InvalidNameException, DateMismatchException {
		System.out.println("\n******************* Login or Sign up *******************");
		System.out.println("Select an option:\n1. Login\n2. SignUp\n3. Exit");
		int option = scan.nextInt();

		if(option == 1) {
			if(loggedIn()) {
				transactionPage();
			}else {
				loginOrSignupPage();
			}
		}else if(option == 2){
			if(signedUp() && loggedIn()) {
				con.commit();
				transactionPage();
			}else {
				con.rollback();
				loginOrSignupPage();
			}
		}else if(option == 3) {
			System.out.println("\n********** Thank you for using our services **********");
			System.exit(0);
		}else {
			System.out.println("Invalid option, Please choose right one");
			loginOrSignupPage();
		}
	}
}
