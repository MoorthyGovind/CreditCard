package com.bank.credit.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationRequestDto {
	
	private String userName;
	private LocalDate dateOfBirth;
	private String address;
	private Long phoneNumber;
	private String emailId;
	private Double salary;
	private String companyName;
	private String password;

}
