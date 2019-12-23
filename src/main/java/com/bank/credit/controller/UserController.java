package com.bank.credit.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.credit.constant.Constant;
import com.bank.credit.dto.RegistrationRequestDto;
import com.bank.credit.dto.RegistrationResponseDto;
import com.bank.credit.dto.UserLoginDto;
import com.bank.credit.dto.UserLoginResponseDto;
import com.bank.credit.exception.AgeNotValidException;
import com.bank.credit.exception.EmailAlreadyExistException;
import com.bank.credit.exception.SalaryLimitException;
import com.bank.credit.exception.UserNotFoundException;
import com.bank.credit.service.UserService;

/**
 * This service has the methods for the implementations of userLogin
 * 
 * @Api loginUser method is used to login the user
 * 
 * @author Vishalakshi D
 * 
 * @version V1.1
 * @since 23-12-2019
 */
@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	/**
	 * This will injects all the implementations of userService method
	 */
	@Autowired
	UserService userService;

	/**
	 * This loginUser method is used to login the user
	 * 
	 * @param userLoginDto contains email and password fields
	 * @return userLoginResponseDto which returns the status message and status code
	 * @throws UserNotFoundException This exception occurs when the user is not
	 *                               found
	 */
	@PostMapping("/login")
	public ResponseEntity<UserLoginResponseDto> loginUser(@RequestBody UserLoginDto userLoginDto)
			throws UserNotFoundException {
		log.info("loginUser controller method - login the user");
		UserLoginResponseDto userLoginResponseDto = userService.loginUser(userLoginDto);
		userLoginResponseDto.setMessage(Constant.LOGIN_SUCCESS_MESSAGE);
		userLoginResponseDto.setStatusCode(Constant.LOGIN_SUCCESS_CODE);
		userLoginResponseDto.setLoginType(Constant.LOGIN_TYPE);
		return new ResponseEntity<UserLoginResponseDto>(userLoginResponseDto, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<RegistrationResponseDto> userRegistration(@Valid @RequestBody RegistrationRequestDto registrationRequestDto) throws EmailAlreadyExistException, SalaryLimitException, AgeNotValidException{
		userService.userRegistration(registrationRequestDto);
			RegistrationResponseDto registrationResponseDto = new RegistrationResponseDto();
			registrationResponseDto.setStatusCode(Constant.REGISTRATION_SUCCESSFUL_CODE);
			registrationResponseDto.setMessage(Constant.REGISTRATION_SUCCESSFUL);
			return new ResponseEntity<RegistrationResponseDto>(registrationResponseDto,HttpStatus.OK);
		}

}
