package com.sandip.firstjpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.sandip.firstjpa.entities.User;

/*
 * CrudRepository<T, ID>
 * T - Which Entity
 * ID - What data type is ID field of the Entity
 */
public interface UserRepository extends CrudRepository<User, Integer> {
	/*
	 * Do not implement anything. Spring Boot provides basic functionality
	 * Basic things specified Here
	 */

}
