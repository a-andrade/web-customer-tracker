package com.crm.springproject.service;

import java.util.List;

import com.crm.springproject.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();
	
	public void saveCustomer(Customer theCustomer);

}
