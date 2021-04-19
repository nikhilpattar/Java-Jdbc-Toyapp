package com.toyapp.runner;

import java.sql.Connection;
import java.sql.SQLException;

import com.toyapp.connection.ConnectionDAO;
import com.toyapp.exceptions.DateMismatchException;
import com.toyapp.exceptions.InvalidNameException;
import com.toyapp.pagesandtransactions.Pages;

public class RunToyApp 
{
	private static Connection con = ConnectionDAO.getConnection();
	
	public static void main(String[] args) 
	{
		System.out.println("*************************** Welcome to Toy App ***************************");
		
		try {
			con.setAutoCommit(false);
			Pages.loginOrSignupPage();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InvalidNameException e) {
			e.printStackTrace();
		} catch (DateMismatchException e) {
			e.printStackTrace();
		}
		
	}
}