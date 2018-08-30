package com.crm.springproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crm.springproject.dao.CustomerDAO;
import com.crm.springproject.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// need to inject customer DAO
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("/list")
	public String listCustomers(Model model) {
		// get customers from DAO
		List<Customer> customers = customerDAO.getCustomers();
		
		// add customers to model
		model.addAttribute("customers", customers);
		
		return "list-customers";
	}
	
	
	
}
