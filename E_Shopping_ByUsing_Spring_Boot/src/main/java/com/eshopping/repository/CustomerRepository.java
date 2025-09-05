package com.eshopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.eshopping.entity.CustomerDetails;

import jakarta.transaction.Transactional;

public interface CustomerRepository extends JpaRepository<CustomerDetails, Integer>{
	//selection
	@Query("select customer from CustomerDetails customer where customer.name=?1 or customer.emailid=?1 or customer.gender=?1")
	List<CustomerDetails> getCustomerDetailsByNameOrEmailidOrGender(String name);
	@Transactional
	@Modifying
	@Query("delete from CustomerDetails customer where customer.name=?1 ")
	void deleteCustomerDetailsByName(String name);
	@Query("select customer from CustomerDetails customer where customer.emailid=?1 and customer.password=?2")
	CustomerDetails customerLoginByEmailidAndPassword(String emailid,String password);
}
