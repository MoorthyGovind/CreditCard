package com.bank.credit.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCardTransactionDto {

	private List<TransactionListResponseDTO> transactions;
	private Long cardNumber;
	private String holderName;
	private Double availableAmount;

}
