package com.eshopping.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@AllArgsConstructor 
@NoArgsConstructor
@ToString
public class CustomerDetails {
	private String name;
	private String address;
	private String emailid;
	private long mobilenumber;
	private String password;
	private String gender;	
}
