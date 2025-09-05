package com.eshopping.service;

import java.util.List;
import java.util.Random;

import com.eshopping.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.eshopping.dao.CustomerDAO;
import com.eshopping.dto.CustomerDetails;
import com.eshopping.exception.InvalidOTPException;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
	@Autowired
	private CustomerDAO customerDAO;
	@Value("${spring.mail.username}")
	private String from;
	@Autowired
	private JavaMailSender javaMailSender;
    CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
	com.eshopping.entity.CustomerDetails customerDetails;
	int otp;
	public void customerRegistration(CustomerDetails customerDetails) {
		com.eshopping.entity.CustomerDetails customerDetails2=new com.eshopping.entity.CustomerDetails();
		customerDetails2.setName(customerDetails.getName());
		customerDetails2.setEmailid(customerDetails.getEmailid());
		customerDetails2.setMobilenumber(customerDetails.getMobilenumber());
		customerDetails2.setPassword(customerDetails.getPassword());
		customerDetails2.setGender(customerDetails.getGender());
		customerDAO.insertCustomerDetails(customerDetails2);
		if(customerDetails2.getId()!=0)
		{
			System.out.println("Data Inserted");
			SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
			simpleMailMessage.setTo(customerDetails2.getEmailid());
			simpleMailMessage.setSubject("Welcome to E-Shopping");
			simpleMailMessage.setText(customerDetails2.getName()+"Thank you for registration");
			javaMailSender.send(simpleMailMessage);
		}
	}
	public List<com.eshopping.entity.CustomerDetails> getAllCustomerDetails() {
		List<com.eshopping.entity.CustomerDetails> allCustomerDetails=customerDAO.selectAllCustomerDetails();
		if(allCustomerDetails.size()!=0)
			return allCustomerDetails;
		return null;
	}
	public List<com.eshopping.entity.CustomerDetails> filterCustomerByNameOrEmailidOrGender(String name) {
		List<com.eshopping.entity.CustomerDetails> customerDetails=customerDAO.selectCustomerDetailsByNameOrEmailidOrGender(name);
		if(customerDetails.size()!=0)
			return customerDetails;
		return null;
	}
	public void deleteCustomerDetailsByName(String name) {
		 customerDAO.deleteByName(name);
	}
	
	public com.eshopping.entity.CustomerDetails customerLogin(String emailid, String password) {
	    customerDetails = customerDAO.customerLoginByEmailAndPassword(emailid, password);

	    if (customerDetails != null) {
	        // Generate 4-digit OTP
	        Random random = new Random();
	        otp = random.nextInt(9000) + 1000;

	        // Send OTP to email
	        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
	        simpleMailMessage.setTo(customerDetails.getEmailid());
	        simpleMailMessage.setFrom(from);
	        simpleMailMessage.setSubject("Otp For E-Shopping");
	        simpleMailMessage.setText("Your generated OTP is: " + otp);

	        javaMailSender.send(simpleMailMessage);

	        System.out.println("OTP sent to: " + customerDetails.getEmailid());
	        //return "OTPPage"; // ✅ send to OTP entry page
	        return customerDetails;
	    } else {
//	        System.err.println("Invalid Email ID or Password");
	        //return "CustomerLogin"; // ❌ return to login page
	    	return null;
	    }
	}

	
	public void otpValidation(int userotp) {
		if(userotp==otp) {
			SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
			simpleMailMessage.setTo(customerDetails.getEmailid());
			simpleMailMessage.setFrom(from);
			simpleMailMessage.setSubject("Welcome For E-Shopping");
			simpleMailMessage.setText("Dear Customer "+customerDetails.getName()+" is succefully Loggeed in");
			javaMailSender.send(simpleMailMessage);
		}
		else {
			throw new InvalidOTPException("Dear "+customerDetails.getName()+" You Have Entered Invalid OTP");
		}
	}
}
