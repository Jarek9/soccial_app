package com.example.soccial_app;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.annotation.Rollback;

import com.example.soccial_app.model.SocialNetworkPost;
import com.example.soccial_app.repository.SocialNetworkPostRepository;


@SpringBootApplication
public class SoccialAppApplication {
	@Autowired
	private SocialNetworkPostRepository socialNetworkPostRepository;

	public static void main(String[] args) {
		SpringApplication.run(SoccialAppApplication.class, args);
	}

	@PostConstruct
	@Rollback()
	private void initDb() {
		SocialNetworkPost socialNetworkPost = new SocialNetworkPost();
		try{
			socialNetworkPostRepository.save(socialNetworkPost);
		}catch (Exception e) {
			System.out.println(e);
		}

	}
}




