package com.bank.credit.service;

import com.bank.credit.dto.TransactionRequestDto;
import com.bank.credit.dto.TransactionResponseDto;
import com.bank.credit.dto.UserCardTransactionDto;
import com.bank.credit.exception.CardNotFoundException;
import com.bank.credit.exception.UserNotFoundException;

public interface UserCardTransactionService {

	UserCardTransactionDto getAllTransaction(Integer userId, Integer month, Integer year) throws UserNotFoundException;

	TransactionResponseDto createTransaction(TransactionRequestDto transactionRequestDto)
			throws CardNotFoundException, UserNotFoundException;
}
