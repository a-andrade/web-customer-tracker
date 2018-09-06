package com.crm.springproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.springproject.dao.CustomerDAO;
import com.crm.springproject.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	//need to inject customer dao
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// delegate call to customer dao
		return customerDAO.getCustomers();
	}

}
