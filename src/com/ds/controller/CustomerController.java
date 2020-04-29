package com.ds.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ds.dao.CustomerDAO;
import com.ds.entity.Customer;
import com.ds.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

//	Logic move to service layer
//	@Autowired
//	private CustomerDAO customerDAO;
	
	@Autowired
	private CustomerService customerService;
	
//	@RequestMapping("/list")
	@GetMapping("/list") //added in Spring 4.3
	public String listCustomersString(Model model) {
		
//		Logic move to service layer
//		List<Customer> customers = customerDAO.getCustomers();
		
		List<Customer> customers = customerService.getCustomers();
		
		model.addAttribute("customers",customers);
		
		return "list-customers";
	}
}
