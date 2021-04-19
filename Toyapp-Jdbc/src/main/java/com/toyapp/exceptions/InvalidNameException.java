package com.toyapp.exceptions;

@SuppressWarnings("serial")
public class InvalidNameException extends Exception
{
	public InvalidNameException() {
		super("InvalidNameException");
	}
}