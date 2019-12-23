package com.bank.credit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.credit.entity.User;
import com.bank.credit.entity.UserCard;

@Repository
public interface UserCardRepository extends JpaRepository<UserCard, Long> {

	Optional<UserCard> findByUser(User user);

	Optional<UserCard> findByCardNumber(Long cardNumber);

}
