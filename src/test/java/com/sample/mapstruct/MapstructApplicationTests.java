package com.sample.mapstruct;

import com.sample.mapstruct.dto.custom.UserCustomDto;
import com.sample.mapstruct.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MapstructApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	public void userServiceTest() {
		UserCustomDto result = userService.findUser(1L);
		Assertions.assertThat(result).isNotNull();
	}

}
