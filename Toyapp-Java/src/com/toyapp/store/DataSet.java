package com.toyapp.store;

import java.util.ArrayList;

import com.toyapp.beanclass.CustomerBean;
import com.toyapp.beanclass.ToyBean;

public class DataSet 
{
	private static ArrayList<CustomerBean> customerList = null;
	private static ArrayList<ToyBean> toyList = null;
	
	public static ArrayList<CustomerBean> getCustomerList() {
		if(customerList == null)
			customerList = new ArrayList<>();
		return customerList;
	}
	public static ArrayList<ToyBean> getToyList() {
		if(toyList == null)
			toyList = new ArrayList<>();
		return toyList;
	}
}
