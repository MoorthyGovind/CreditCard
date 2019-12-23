package com.bank.credit.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TransactionResponseDto {

	private String message;
	private Integer statusCode;
	private Long transactionId;
}
