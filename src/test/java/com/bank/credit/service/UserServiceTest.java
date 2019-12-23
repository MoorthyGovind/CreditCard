package com.bank.credit.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.bank.credit.dto.UserLoginDto;
import com.bank.credit.dto.UserLoginResponseDto;
import com.bank.credit.entity.User;
import com.bank.credit.exception.UserNotFoundException;
import com.bank.credit.repository.UserRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserServiceTest {

	@InjectMocks
	UserServiceImpl userServiceImpl;

	@Mock
	UserRepository userRepository;

	User user = null;
	UserLoginResponseDto userLoginResponseDto = null;
	UserLoginDto userLoginDto = null;

	@Before
	public void setup() {
		user = new User();
		user.setEmailId("vishali@gmail.com");
		user.setPassword("vishali");

		userLoginResponseDto = new UserLoginResponseDto();
		userLoginResponseDto.setEmailId(user.getEmailId());
		userLoginResponseDto.setUserId(1);
		userLoginResponseDto.setUserName("Vishalakshi");

		userLoginDto = new UserLoginDto();
		userLoginDto.setPassword(user.getPassword());
		userLoginDto.setUserId(user.getEmailId());
	}

	@Test
	public void testLoginUser() throws UserNotFoundException {
		Mockito.when(userRepository.findByEmailIdAndPassword(userLoginDto.getUserId(), userLoginDto.getPassword()))
				.thenReturn(Optional.of(user));
		UserLoginResponseDto result = userServiceImpl.loginUser(userLoginDto);

		assertNotNull(userLoginResponseDto);
		assertEquals("vishali@gmail.com", result.getEmailId());
	}
	
	@Test(expected = UserNotFoundException.class)
	public void testLoginUserForNegative() throws UserNotFoundException {
		user = new User();
		user.setEmailId("abc@gmail.com");
		user.setPassword("abc");
		Mockito.when(userRepository.findByEmailIdAndPassword("xyz@gmail.com","xyz"))
				.thenReturn(Optional.of(user));
		 userServiceImpl.loginUser(userLoginDto);
	}

}
