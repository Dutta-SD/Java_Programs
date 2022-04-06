package com.sandip.firstjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sandip.firstjpa.dao.UserRepository;
import com.sandip.firstjpa.entities.User;

@SpringBootApplication
public class FirstjpaApplication {

	public static void main(String[] args) {
		/*
		 * Use Entity ORM
		 */
		ApplicationContext context = SpringApplication.run(FirstjpaApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);

		/*
		User user = new User();
		user.setName("Sandip Dutta");
		user.setCity("Kolkata");
		user.setStatus("Active");

		User user1 = userRepository.save(user);
		System.out.println(user1);
		*/
//		userRepository.
		/*
		 * More CRUD Operations can be done using similar methods
		 * Also custom finder methods can be implemented as per need 
		 */
		
		

	}

}