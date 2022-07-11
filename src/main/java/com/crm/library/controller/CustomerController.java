package com.crm.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crm.library.entity.Customer;
import com.crm.library.service.CustomerService;


@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	
	@Autowired
	private CustomerService customerService;
	
	
	@RequestMapping("/list")
	public String listAllCustomer(Model model)
	{
		List<Customer> customerList = customerService.listAllCustomer();
		 for(Customer b:customerList) { System.out.println(b); }
		model.addAttribute("Customers", customerList);
		return "Customer";
	}
	
	
	@RequestMapping("/showAddForm")
	public String showAddForm() {
		return "CustomerForm";
	}
	
	
	@RequestMapping("/save")
	public String registerStudent(@RequestParam("id") Integer customerId,
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("email") String email)
	{
		Customer customer;
		
		if(customerId==null)
		{
			customer = new Customer();
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
			customer.setEmail(email);		
		}
		else
		{
			customer = customerService.findCustomer(customerId);
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
			customer.setEmail(email);
		}

		
		customerService.saveCustomer(customer);
		return "redirect:list";
	}
	
	
	@RequestMapping("/update")
	public String update(@RequestParam("id")Integer customerId, Model model)
	{
		Customer customer=  customerService.findCustomer(customerId);
		model.addAttribute("customer", customer);
		
		return "CustomerForm";
	}
	
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("id") Integer customerId) 
	{
		Customer customer=  customerService.findCustomer(customerId);
		customerService.delete(customer);
		return "redirect:list";
	}
	
	
	

}
