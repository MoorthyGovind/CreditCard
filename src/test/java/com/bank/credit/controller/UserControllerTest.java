package com.bank.credit.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.bank.credit.constant.Constant;
import com.bank.credit.dto.UserLoginDto;
import com.bank.credit.dto.UserLoginResponseDto;
import com.bank.credit.exception.UserNotFoundException;
import com.bank.credit.service.UserService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserControllerTest {

	@InjectMocks
	UserController userController;

	@Mock
	UserService userService;

	UserLoginDto userLoginDto = null;
	UserLoginResponseDto userLoginResponseDto = null;

	@Before
	public void setup() {
		userLoginResponseDto = new UserLoginResponseDto();
		userLoginResponseDto.setMessage(Constant.LOGIN_SUCCESS_MESSAGE);
		userLoginResponseDto.setStatusCode(Constant.LOGIN_SUCCESS_CODE);
		userLoginResponseDto.setLoginType(Constant.LOGIN_TYPE);

		userLoginDto = new UserLoginDto();
		userLoginDto.setPassword("vishali");
		userLoginDto.setUserId("vishali@gmail.com");
	}

	@Test
	public void testLoginUser() throws UserNotFoundException {
		Mockito.when(userService.loginUser(userLoginDto)).thenReturn(userLoginResponseDto);
		ResponseEntity<UserLoginResponseDto> result = userController.loginUser(userLoginDto);

		assertNotNull(userLoginResponseDto);
		assertEquals(Constant.LOGIN_SUCCESS_CODE, result.getStatusCodeValue());

	}

}
