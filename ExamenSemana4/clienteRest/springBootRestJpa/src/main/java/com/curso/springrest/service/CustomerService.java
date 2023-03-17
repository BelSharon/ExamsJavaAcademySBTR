package com.curso.springrest.service;

import java.util.List;

import com.curso.springrest.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public Customer saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
	
}
