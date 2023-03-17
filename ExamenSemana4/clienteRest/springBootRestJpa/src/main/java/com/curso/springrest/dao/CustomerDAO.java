package com.curso.springrest.dao;

import java.util.List;

import com.curso.springrest.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public Customer saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
	
}
