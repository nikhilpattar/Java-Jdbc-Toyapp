package com.toyapp.serviceandimplementation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.toyapp.connection.Prerequisites;

public class ToyRentalImplementation extends Prerequisites implements ToyRentalService, Queries
{
	private PreparedStatement pstmt  = null;
	private ResultSet rs = null;

	public boolean bookToy(int rentId, String rentalStartDate, String rentalEndDate, int rentalAmountPerDay, int totalAmount,
			int fine, String status, int customerId, int toyId) throws SQLException {

		if(getStmt().executeUpdate(BOOK_TOY + "("+rentId+", '"+rentalStartDate+"', '"+rentalEndDate+"', "+rentalAmountPerDay+", "+totalAmount+", "
				+fine+", '"+status+"', "+customerId+", "+toyId+")") > 0) {
			return true;
		}else {
			return false;
		}

	}

	public int getMaxRentalId() throws SQLException {
		rs = getStmt().executeQuery(GET_MAX_RENTAL_ID);
		if(rs.next())
			return rs.getInt(1);
		else {
			System.out.println("Failed to fetch rental id");
			return 0;
		}
	}

	public boolean returnToy(int rentalId, int fine, String status) throws SQLException {
		pstmt = getPstmt(RETURN_TOY);
		pstmt.setInt(1, 0);
		pstmt.setInt(2, fine);
		pstmt.setString(3, status);
		pstmt.setInt(4, rentalId);
		if(pstmt.executeUpdate() > 0 && fine <= 0){
			return true;
		}else{
			return false;
		}
	}
	
	public int getToyRentalAmount(int rentalId) throws SQLException {
		pstmt = getPstmt(GET_RENTAL_AMOUNT_PER_DAY);
		pstmt.setInt(1, rentalId);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			return rs.getInt(1);
		}else {
			System.out.println("Failed to fetch rental amount per day");
			return 0;
		}
	}
	
	public String getRentalEndDate(int rentalId) throws SQLException {

		pstmt = getPstmt(GET_RENTAL_END_DATE);
		pstmt.setInt(1, rentalId);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			return rs.getString(1);
		}else {
			return null;
		}
	}

	public boolean getRentalDetails(int customerId) throws SQLException {
		pstmt = getPstmt(GET_CUSTOMER_RENTAL_DETAILS);
		pstmt.setInt(1, customerId);
		rs = pstmt.executeQuery();
		boolean flag = true;
		//customer_name, rental_id, rental_start_date, rental_end_date, rental_amount per_day,total_amount, fine, status
		while(rs.next()) {
			flag = false;
			System.out.println("Rental Id: "+rs.getString(2)
			+" | Start Date: "+rs.getString(3)
			+" | End Date: "+rs.getString(4)
			+" | Rental Amount/Day: "+rs.getString(5)
			+" | Total Amount: "+rs.getString(6)
			+" | Fine: "+rs.getString(7)
			+" | Status: "+rs.getString(8));
		}
		return flag;
	}

	public boolean toyRentalDetails(int toyId) throws SQLException {
		pstmt = getPstmt(GET_TOY_RENTAL_DETAILS);
		pstmt.setInt(1, toyId);
		rs = pstmt.executeQuery();
		boolean flag = true;
		while(rs.next()) {
			flag = false;
			System.out.println("Toy Name: "+rs.getString(1)
			+" | Rental Id: "+rs.getString(2)
			+" | Customer Id: "+rs.getString(9)
			+" | Start Date: "+rs.getString(3)
			+" | End Date: "+rs.getString(4)
			+" | Rental Amount/Day: "+rs.getString(5)
			+" | Total Amount: "+rs.getString(6)
			+" | Fine: "+rs.getString(7)
			+" | Status: "+rs.getString(8));
		}
		return flag;
	}

	public int getTotalRentalAmount(int customerId) throws SQLException {
		
		int totalRentalAmount = 0;
		pstmt = getPstmt(GET_TOTAL_RENTAL_AMOUNT);
		pstmt.setInt(1, customerId);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			totalRentalAmount += rs.getInt(1) + rs.getInt(2);
		}
		return totalRentalAmount;
	}
}
