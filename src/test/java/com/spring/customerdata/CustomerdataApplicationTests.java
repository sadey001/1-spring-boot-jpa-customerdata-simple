package com.spring.customerdata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.customerdata.entity.Customer;
import com.spring.customerdata.repository.CustomerRepository;

@SpringBootTest
class CustomerdataApplicationTests {
	
	@Autowired
	CustomerRepository repository;
	
	@Test
	void RepositoryTest() {
		assertNotNull(repository);
	}
	
	@Test
	void CreateTest() {
		long count = repository.count();
		repository.save(getCustomer());
		long afterCount = repository.count();
		assertEquals((afterCount-count),1);
	}
	
	@Test
	void UpdateTest() {
		String email = "dey001sanat@gmail.com";
		Customer customer= repository.save(getCustomer());
		customer.setEmail(email);
		Customer updatedCustomer = repository.save(customer);
		
		assertEquals(email,updatedCustomer.getEmail());
		
	}
	
	@Test
	void getCustomersTest() {
		repository.save(getCustomer());
		Iterable<Customer> customers = repository.findAll();
		System.out.println(customers);
		Customer customer = customers.iterator().next();
		
		assertEquals(customer.getName(),"Sanat Dey");
	}

	@Test
	void getCustomerTest() {
		repository.save(getCustomer());
		int id = 1;
		Optional<Customer> customer = repository.findById(id);
		assertEquals(customer.get().getName(),"Sanat Dey");
	}
	
	@Test
	void DeleteTest() {
		repository.save(getCustomer());
		long count = repository.count();
		repository.deleteById(Long.signum(count));;
		long afterCount = repository.count();
		assertEquals((count-afterCount),1);
		
	}
	
	
	
	private Customer getCustomer() {
		
		Customer customer = new Customer();
		customer.setName("Sanat Dey");
		customer.setEmail("deysanat001@gmail.com");
		customer.setRole_id(1);
		
		return customer;
	}

}
