package com.example.security;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@GetMapping(value="/getUsers")
	public List<User> getUsers(){
		List<User> users = new ArrayList<>();
		User u1 = new User();User u2 = new User();User u3 = new User();
		u1.setName("Juju"); u1.setAge(8); u1.setSalary(100000);
		u2.setName("Papu"); u2.setAge(26); u2.setSalary(100000);
		u3.setName("Saba"); u3.setAge(38); u3.setSalary(100000);

		users.add(u1);users.add(u2);users.add(u3);
		return users;
	}
}
