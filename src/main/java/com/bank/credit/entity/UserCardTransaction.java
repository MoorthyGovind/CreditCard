package com.bank.credit.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@SequenceGenerator(name = "transactionId", initialValue = 60000, allocationSize = 1)
public class UserCardTransaction {
		
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transactionId")
		private Long transactionId; 
		private LocalDate transactionDate; 
		private Double transactionAmount; 
		private String description; 
		@ManyToOne
		@JoinColumn(name = "cardNumber")
		private UserCard userCard; 
		@ManyToOne
		@JoinColumn(name = "userId")
		private User user; 

}
