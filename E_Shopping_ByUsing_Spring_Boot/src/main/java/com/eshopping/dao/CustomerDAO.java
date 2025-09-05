package com.eshopping.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eshopping.entity.CustomerDetails;
import com.eshopping.repository.CustomerRepository;

@Repository
public class CustomerDAO {
	@Autowired
	private CustomerRepository customerRepository;
	
	public CustomerDetails insertCustomerDetails(CustomerDetails customerDetails) {
		return customerRepository.save(customerDetails);
	}
	
	public List<CustomerDetails> selectAllCustomerDetails() {
		return customerRepository.findAll();
	}
	
	public List<CustomerDetails> selectCustomerDetailsByNameOrEmailidOrGender(String filterdata) {
		return customerRepository.getCustomerDetailsByNameOrEmailidOrGender(filterdata);
	}
	public void deleteByName(String name) {
		customerRepository.deleteCustomerDetailsByName(name);
	}
	public CustomerDetails customerLoginByEmailAndPassword(String emailid,String password) {
		return customerRepository.customerLoginByEmailidAndPassword(emailid, password);
	}
}
