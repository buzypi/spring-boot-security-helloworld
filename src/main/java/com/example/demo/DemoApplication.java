package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		UserRepository repository = context.getBean(UserRepository.class);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		User user = new User("admin", encoder.encode("admin111"));
		repository.save(user);
		user = new User("user", encoder.encode("user111"));
		repository.save(user);
	}
}
