package com.spring.customerdata.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomRepositoryTest {

	@Autowired
	CustomRepository repository;
	
	@Test
	void test() {
		assertNotNull(repository);
	}
	
	@Test
	void getCustomersTest() throws SQLException {
		String customers = repository.getCustomers();
		System.out.println(customers);
		assertNotEquals(customers,"");
	}

}
