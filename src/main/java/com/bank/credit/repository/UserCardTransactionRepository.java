package com.bank.credit.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.credit.entity.User;
import com.bank.credit.entity.UserCardTransaction;

@Repository
public interface UserCardTransactionRepository extends JpaRepository<UserCardTransaction, Long> {

	List<UserCardTransaction> findAllByUserAndTransactionDateBetween(User user, LocalDate startDate, LocalDate endDate);

}
