package com.toyapp.serviceandimplementation;

import java.util.Scanner;

import com.toyapp.beanclass.ToyBean;
import com.toyapp.exceptions.InvalidAgeException;
import com.toyapp.exceptions.InvalidNameException;
import com.toyapp.store.DataSet;

public class ToyImplementation implements ToyService
{
	private static Scanner scan = new Scanner(System.in);
	private static ToyBean tBean = new ToyBean();
	private static int toyId = 0;
	
	@Override
	public void insertToy() throws InvalidNameException, InvalidAgeException {
		
		tBean.setToyId(toyId++);

		System.out.println("Please enter toy details:");
		System.out.println("Toy Name: ");tBean.setToyName(scan.nextLine());
		System.out.println("Toy Type: ");tBean.setToyType(scan.nextLine());
		System.out.println("Minimum Age: ");tBean.setMinAge(scan.nextInt());
		System.out.println("Maximum Age: ");tBean.setMaxAge(scan.nextInt());
		System.out.println("Price: ");tBean.setPrice(scan.nextInt());
		System.out.println("Quantity: ");tBean.setQuantity(scan.nextInt());
		System.out.println("Rental Amount: ");tBean.setRentalAmount(scan.nextInt());
		
		DataSet.getToyList().add(new ToyBean(tBean.getToyId(), tBean.getToyName(), tBean.getToyType(), tBean.getMinAge(), tBean.getMaxAge(), 
				tBean.getPrice(), tBean.getQuantity(), tBean.getRentalAmount()));
	}
	
	@Override
	public ToyBean searchToy(int toyId){
		for (ToyBean toy: DataSet.getToyList()) {
			if(toy.getToyId() == toyId) {
				System.out.println("Toy is available");
				return toy;
			}
		}
		System.out.println("No toy found with given toy ID");
		return null;
	}
	
	public ToyBean searchToyByName(String toyName){
		for (ToyBean toy: DataSet.getToyList()) {
			if(toy.getToyName().equals(toyName)) {
				System.out.println("Toy is available");
				return toy;
			}
		}
		System.out.println("No toy found with given toy ID");
		return null;
	}

	@Override
	public void displayToy(int toyId){
		
		ToyBean toy = searchToy(toyId);
		if(toy != null) {
			System.out.println(toy);
		}
	}
}
