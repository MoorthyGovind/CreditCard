package com.bank.credit.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TransactionListResponseDTO {
	private LocalDate transactionDate;
	private Double transactionAmount;
	private String description;
}