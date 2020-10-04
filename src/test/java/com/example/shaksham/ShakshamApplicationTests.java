package com.example.shaksham;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.shaksham.ShakshamApplication;

//@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration
@SpringBootTest(classes=ShakshamApplication.class)

class ShakshamApplicationTests {

	@Test
	void contextLoads() {
	}

}
