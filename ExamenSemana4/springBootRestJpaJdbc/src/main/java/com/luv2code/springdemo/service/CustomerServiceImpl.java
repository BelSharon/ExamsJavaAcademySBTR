package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.luv2code.springdemo.dao.CustomerDAOJdbc;
import com.luv2code.springdemo.dao.CustomerDAOJpa;
import com.luv2code.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	//@Qualifier("customerDAOJdbc")
	//private CustomerDAOJpa customerDAO; //JPA
	private CustomerDAOJdbc customerDAO; //JDBC
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public Customer saveCustomer(Customer theCustomer) {
		Customer customer = customerDAO.saveCustomer(theCustomer);
		return customer;
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		
		return customerDAO.getCustomer(theId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		
		customerDAO.deleteCustomer(theId);
	}
}





