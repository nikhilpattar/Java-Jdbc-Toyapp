package com.toyapp.runner;

import com.toyapp.exceptions.InvalidAgeException;
import com.toyapp.exceptions.InvalidNameException;

public class RunToyApp 
{
	
	public static void main(String[] args) 
	{
		System.out.println("*************************** Welcome to Toy App ***************************");
		
		try {
			Transactions.run();
		} catch (InvalidNameException e) {
			e.printStackTrace();
		} catch (InvalidAgeException e) {
			e.printStackTrace();
		}
	}
}