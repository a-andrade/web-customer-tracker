package com.crm.springproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crm.springproject.entity.Customer;
import com.crm.springproject.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// remove customer dao, inject customer service
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		// remove customer dao call, get customers from service
		List<Customer> theCustomers = customerService.getCustomers();
		
		// add customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}

}
