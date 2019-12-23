package com.bank.credit.service;

import com.bank.credit.dto.RegistrationRequestDto;
import com.bank.credit.dto.UserLoginDto;
import com.bank.credit.dto.UserLoginResponseDto;
import com.bank.credit.exception.AgeNotValidException;
import com.bank.credit.exception.EmailAlreadyExistException;
import com.bank.credit.exception.SalaryLimitException;
import com.bank.credit.exception.UserNotFoundException;

/**
 * This interface has method loginUser for login the user
 * 
 * @author Vishalakshi D
 * @version V1.1
 * @since 23-12-2019
 */
public interface UserService {

	/**
	 * This loginUser method is used to login the user
	 * 
	 * @param userLoginDto contains email and password fields
	 * @return userLoginResponseDto which returns the status message and status code
	 * @throws UserNotFoundException This exception occurs when the user is not
	 *                               found
	 */
	public UserLoginResponseDto loginUser(UserLoginDto userLoginDto) throws UserNotFoundException;

	void userRegistration(RegistrationRequestDto registrationRequestDto)
			throws EmailAlreadyExistException, SalaryLimitException, AgeNotValidException;

}
