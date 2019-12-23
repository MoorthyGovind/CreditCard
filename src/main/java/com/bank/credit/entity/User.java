package com.bank.credit.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	private String userName;
	private LocalDate dateOfBirth;
	private String address;
	private Long phoneNumber;
	private String emailId;
	private Double salary;
	private String companyName;
	private String password;

}
