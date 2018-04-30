package com.loyer.hrsystem;

import com.loyer.hrsystem.model.App;
import com.loyer.hrsystem.model.Job;
import com.loyer.hrsystem.model.User;
import com.loyer.hrsystem.repository.AppRepository;
import com.loyer.hrsystem.repository.JobRepository;
import com.loyer.hrsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class HrsystemApplication implements CommandLineRunner{
	@Autowired
	UserRepository userRepository;
	@Autowired
	JobRepository jobRepository;
	@Autowired
	AppRepository appRepository;



	public static void main(String[] args) {
		SpringApplication.run(HrsystemApplication.class, args);
	}

	public void run(String... strings) throws Exception{
		User user1 = new User("recep", "123456");
		user1.setName("recep");
		user1.setLastName("çelik");

		userRepository.save(user1);
		Job job = new Job("Yazılım Stajyeri","Tercihen Java bilen",2,"01/05/2018");

		App app = new App("recep","recep@gmail.com",111111111,"izmir","elimden geldiğince, öğrenmeye hevesli");
		Set set = new HashSet<App>();

		set.add(app);
		app.setJob(job);
		jobRepository.save(job);
		appRepository.save(app);


	}

}
