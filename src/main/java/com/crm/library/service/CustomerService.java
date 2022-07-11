package com.crm.library.service;

import java.util.List;

import com.crm.library.entity.Customer;

public interface CustomerService {

	public List<Customer> listAllCustomer();

	public Customer findCustomer(Integer customerId);

	public void saveCustomer(Customer customer);

	public void delete(Customer customer);

}
