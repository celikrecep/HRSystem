package com.loyer.hrsystem;

import com.loyer.hrsystem.model.Job;
import com.loyer.hrsystem.model.User;
import com.loyer.hrsystem.repository.JobRepository;
import com.loyer.hrsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HrsystemApplication implements CommandLineRunner{
	@Autowired
	UserRepository userRepository;
	@Autowired
	JobRepository jobRepository;



	public static void main(String[] args) {
		SpringApplication.run(HrsystemApplication.class, args);
	}

	public void run(String... strings) throws Exception{
		User user1 = new User("recep", "123456");
		user1.setName("recep");
		user1.setLastName("çelik");

		userRepository.save(user1);
		Job job = new Job("deneme","deneme",22,"deneme");
		jobRepository.save(job);

	}

}
