package com.toyapp.exceptions;

@SuppressWarnings("serial")
public class InvalidAgeException extends Exception
{
	public InvalidAgeException() {
		super("InvalidAgeException");
	}
}