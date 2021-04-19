package com.toyapp.serviceandimplementation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.toyapp.connection.Prerequisites;
import com.toyapp.exceptions.InvalidNameException;

public class CustomerImplementation extends Prerequisites implements CustomerService, Queries
{
	private PreparedStatement pstmt  = null;
	private ResultSet rs = null;

	public boolean addCustomer(int customerId, String customerName, String password, String city, String state,
			int zipCode, String country) throws InvalidNameException, SQLException {

		if(getStmt().executeUpdate(ADD_CUSTOMER + "("+customerId+",'"+customerName+"',"
				+ "'"+password+"','"+city+"','"+state+"',"+zipCode+",'"+country+"')") > 0) {
			return true;
		}else {
			return false;
		}
	}

	public void displayCustomer(int customerId) throws SQLException {

		pstmt = getPstmt(DISPLAY_CUSTOMER);
		pstmt.setInt(1, customerId);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			System.out.println("Customer Details:\n"+rs.getString(1)
			+"\n"+rs.getString(2)+"-"+rs.getString(4)
			+"\n"+rs.getString(3)
			+"\n"+rs.getString(5));
		}else {
			System.out.println("Please enter valid customer ID");
		}
	}

	public int getMaxCustomerId() throws SQLException {
		
		rs = getStmt().executeQuery(GET_MAX_CUSTOMER_ID);
		if(rs.next())
			return rs.getInt(1);
		else {
			System.out.println("Failed to fetch customer id");
			return 0;
		}
	}

	public boolean validateCustomer(int customerId, String password) throws SQLException {
		pstmt = getPstmt(VALIDATE_CUSTOMER);
		pstmt.setInt(1, customerId);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			return rs.getString(1).equals(password);
		}
		return false;
	}
}
