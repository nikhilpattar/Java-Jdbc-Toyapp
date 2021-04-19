package com.toyapp.serviceandimplementation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.toyapp.connection.Prerequisites;
import com.toyapp.exceptions.InvalidAgeException;
import com.toyapp.exceptions.InvalidNameException;

public class ToyImplementation extends Prerequisites implements ToyService, Queries
{
	private PreparedStatement pstmt  = null;
	private ResultSet rs = null;
	
	public void addToy(int toyId, String toyName, String toyType, int minAge, int maxAge, int price, int quantity,
			int rentalAmount) throws InvalidNameException, InvalidAgeException, SQLException {

		if(getStmt().executeUpdate(ADD_TOY +"("+toyId+",'"+toyName+"','"+toyType+"',"
				+ ""+minAge+","+maxAge+","+price+","+quantity+","+rentalAmount+")") > 0) {
			System.out.println("Toy added successfully");
		}else {
			System.out.println("Try again");
		}
	}
	
	public int getToyAmount(int toyId) throws SQLException {
		pstmt = getPstmt(GET_TOY_AMOUNT_PER_DAY);
		pstmt.setInt(1, toyId);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			return rs.getInt(1);
		}else {
			System.out.println("Failed to fetch amount per day");
			return 0;
		}
	}

	public void displayToys() throws SQLException {
		pstmt = getPstmt(DISPLAY_TOYS);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			System.out.println("Toy ID: "+rs.getInt(1)
					+" | Name: "+rs.getString(2)
					+" | Type: "+rs.getString(3)
					+" | Min Age: "+rs.getInt(4)
					+" | Max Age: "+rs.getInt(5)
					+" | Price: "+rs.getInt(6)
					+" | Quantity: "+rs.getInt(7)
					+" | Rental Amount: "+rs.getInt(8));
		}
	}
	
	public void deleteToy(int toyId) throws SQLException {

		pstmt = getPstmt(DELETE_TOY);
		pstmt.setInt(1, toyId);
		if(pstmt.executeUpdate() > 0) {
			System.out.println("Toy with ID: "+toyId+" deleted successfully");
		}else {
			System.out.println("Please enter valid ID");
		}
	}
}
