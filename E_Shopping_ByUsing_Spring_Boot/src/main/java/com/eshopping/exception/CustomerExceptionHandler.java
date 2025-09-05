package com.eshopping.exception;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.eshopping.dto.CustomerDetails;

import jakarta.servlet.http.HttpSession;

@ControllerAdvice
public class CustomerExceptionHandler {
	@Autowired
	JavaMailSender javaMailSender;
	@Value("${spring.mail.username}")
	private String from;
	@ExceptionHandler(InvalidOTPException.class)
	public String invalidOTPExceptionMsg(InvalidOTPException invalidOTPException,HttpSession session,Model model) {
		String msg=invalidOTPException.getExceptionMsg();
		CustomerDetails customerDetails=(CustomerDetails) session.getAttribute("customerDetails");
		model.addAttribute("msg", msg);
		
		Random random = new Random();
        int otp = random.nextInt(9000) + 1000;

        // Send OTP to email
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(customerDetails.getEmailid());
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setSubject("Otp For E-Shopping");
        simpleMailMessage.setText("Your Re-generated OTP is: " + otp);
        javaMailSender.send(simpleMailMessage);
        System.out.println("OTP sent to: " + customerDetails.getEmailid());
		return "OTPPage";
		}
}
