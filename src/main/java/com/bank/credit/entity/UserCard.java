package com.bank.credit.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@SequenceGenerator(name = "cardNumber", initialValue = 500000000, allocationSize = 1)
public class UserCard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cardNumber")
	private Long cardNumber; 
	private String holderName; 
	private LocalDate validFrom; 
	private LocalDate validTo; 
	private Integer cvv; 
	private Double creditLimit;
	private Double availableAmount; 
	@OneToOne
	@JoinColumn(name = "userId")
	private User user;
	

}
