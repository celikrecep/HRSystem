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
		Job job1 = new Job("Çaycı","Çay getirip götüren",1,"02/05/2018");

		jobRepository.save(job);
		jobRepository.save(job1);


		App app = new App("Recep","recep@gmail.com",111111111,"izmir","elimden geldiğince, öğrenmeye hevesli");
		App app1 = new App("Ahmet","ahmet@gmail.com",22222222,"Bolu","iş hakkındaki düşünceler");

		App app2 = new App("Hüseyin","hüseyin@gmail.com",33333333,"istanbul","Tepsiyi sallayabiliyorum");

		Set set1 = new HashSet<App>();
		set1.add(app2);

		app2.setJob(job1);

		Set set = new HashSet<App>();
		set.add(app);
		set.add(app1);

		app.setJob(job);
		app1.setJob(job);


		appRepository.save(app);
		appRepository.save(app1);
		appRepository.save(app2);


	}

}
