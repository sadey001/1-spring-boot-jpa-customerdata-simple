package com.spring.customerdata.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.customerdata.entity.Role;

@SpringBootTest
class RoleRepositoryTest {
	
	@Autowired
	RoleRepository repository;

	@Test
	void setRoletest() {
		repository.save(getVIPRole());
		repository.save(getBasicRole());
		repository.save(getStanderdRole());
		
		assertEquals(3, (int)repository.count());
		
	}
	
	public Role getVIPRole() {
		Role role = new Role();
		role.setRole("VIP");
		role.setDeliveryCharge(0);
		return role;
	}
	
	public Role getBasicRole() {
		Role role = new Role();
		role.setRole("Basic");
		role.setDeliveryCharge(25);
		return role;
	}
	
	public Role getStanderdRole() {
		Role role = new Role();
		role.setRole("Standerd");
		role.setDeliveryCharge(50);
		return role;
	}

}
