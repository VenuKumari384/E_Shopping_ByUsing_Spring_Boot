package com.eshopping.controller;
import com.eshopping.service.CustomerService;

import jakarta.servlet.http.HttpSession;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eshopping.EShoppingByUsingSpringBootApplication;
import com.eshopping.EShoppingByUsingSpringBootApplication;

import com.eshopping.dto.CustomerDetails;

/* *Steps to add the Dependencies in to already existed project

->Click on the Project right click on it

->select the option spring move the courser to the right click on Add starters

->Search for Required Dependencies and select it

->click on next

->select pom.xml

->click on finish

 *Note: While adding the Dependencies in to the project make sure that Internet

 connection/
*/
@Controller
public class UserController {
	@Autowired
    private CustomerService customerService;
	@RequestMapping("/userregistrationpage")
	public String userRegistrationPage() {
		return "UserRegistrationPage";
	}
	@RequestMapping("/userregistrationrequest")
	public void userRegistrationRequest(CustomerDetails customerDetails) {
		customerService.customerRegistration(customerDetails);
		System.out.println(customerDetails);
	}
	@RequestMapping("/userlogin")
	public String userLoginPage() {
		return "CustomerLogin";
	}
	@RequestMapping("/userloginrequest")
	public String userLoginPageRequest(String emailid,String password,HttpSession session) {
		com.eshopping.entity.CustomerDetails customerlogin=customerService.customerLogin(emailid, password);
		session.setAttribute("customerDetails", customerlogin);
		if(customerlogin!=null) {
			return "OTPPage";
		}
		return null;
	}
	@RequestMapping("/loginwithotp")
	public String loginWithOTP(@RequestParam int userotp) {
	    customerService.otpValidation(userotp);
	    return "WelcomePage"; // or whatever success page you want
	}

	//@ResponseBody
	@RequestMapping("/getallcustomerdetails")
	public String getAllCustomerDetails(Model model) {
		List<com.eshopping.entity.CustomerDetails> allCustomerDetails=customerService.getAllCustomerDetails();
		System.out.println(allCustomerDetails);
		model.addAttribute("allCustomerDetails", allCustomerDetails);
		return "AllCustomerDetails";
	}
	//@ResponseBody
	@RequestMapping("/filtercustomer")
	public String filterCustomerByNameOrEmailidOrGender(@RequestParam("name")String name,Model model) {
		List<com.eshopping.entity.CustomerDetails> customerDetails=customerService.filterCustomerByNameOrEmailidOrGender(name);
		model.addAttribute("allCustomerDetails",customerDetails);
		return "AllCustomerDetails";
	}
	@RequestMapping("/deletebyname")
	public String deleteCustomerByName(String name) {
		customerService.deleteCustomerDetailsByName(name);
		return "redirect:/getallcustomerdetails";
	}

}
