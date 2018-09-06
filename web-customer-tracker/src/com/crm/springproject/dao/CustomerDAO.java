package com.crm.springproject.dao;

import java.util.List;

import com.crm.springproject.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

}
