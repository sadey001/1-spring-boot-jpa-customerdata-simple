package com.spring.customerdata.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.customerdata.entity.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {

}
