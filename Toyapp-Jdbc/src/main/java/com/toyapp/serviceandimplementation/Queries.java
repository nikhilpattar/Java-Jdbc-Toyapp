package com.toyapp.serviceandimplementation;

public interface Queries 
{
	
	// Customer Table
	
	String ADD_CUSTOMER ="insert into webapp.customer (customer_id, customer_name, password, city, state, zipcode, country) "
			+ "values ";
	
	String DISPLAY_CUSTOMER = "select customer_name, city, state, zipcode, country from webapp.customer where customer_id = ?";
	
	String DELETE_CUSTOMER = "delete from webapp.customer where customer_id = ?";
	
	String GET_MAX_CUSTOMER_ID = "select max(customer_id) from webapp.customer";
	
	String VALIDATE_CUSTOMER = "select password from webapp.customer where customer_id = ?";
	
	// Toy Table
	
	String ADD_TOY = "insert into webapp.toy (toy_id, toy_name, toy_type, min_age, max_age, price, quantity, rental_amount) "
			+ "values ";
	
	String DISPLAY_TOYS = "select * from webapp.toy";
	
	String DELETE_TOY = "delete from webapp.toy where toy_id = ?";
	
	String GET_TOY_AMOUNT_PER_DAY = "select rental_amount from webapp.toy where toy_id = ?";


	// Toy Rental Table
	
	String BOOK_TOY = "insert into webapp.toyrental (rental_id, rental_start_date, rental_end_date, rental_amount_per_day, total_amount, "
			+ "fine, status, customer_id, toy_id) values ";
	
	String GET_CUSTOMER_RENTAL_DETAILS = "select customer_name, rental_id, rental_start_date, rental_end_date, rental_amount_per_day, total_amount, fine, status "
			+ "from webapp.toyrental cross join webapp.customer "
			+ "where webapp.toyrental.customer_id = webapp.customer.customer_id and webapp.toyrental.status = 'Booked' and webapp.customer.customer_id = ?";
	
	String GET_TOY_RENTAL_DETAILS = "select toy_name, rental_id, rental_start_date, rental_end_date, rental_amount_per_day, total_amount, fine, status, customer_id "
			+ "from webapp.toyrental cross join webapp.toy "
			+ "where webapp.toyrental.toy_id = webapp.toy.toy_id and webapp.toy.toy_id = ?";
	
	String GET_TOTAL_RENTAL_AMOUNT = "select total_amount, fine from webapp.toyrental where customer_id = ?";
	
	String GET_MAX_RENTAL_ID = "select max(rental_id) from webapp.toyrental";
	
	String GET_RENTAL_AMOUNT_PER_DAY = "select rental_amount_per_day from webapp.toyrental where rental_id = ?";
	
	String RETURN_TOY = "update webapp.toyrental set total_amount = ?, fine = ?, status = ? where rental_id = ?";
	
	String GET_RENTAL_END_DATE = "select rental_end_date from webapp.toyrental where rental_id = ?";
}
