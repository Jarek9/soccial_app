package com.example.soccial_app.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Rollback;

import com.example.soccial_app.model.SocialNetworkPost;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SocialNetworkPostRepositoryTest {

	@Autowired
	private SocialNetworkPostRepository socialNetworkPostRepository;

	// JUnit test for saveSocialNetworkPost
	@Test
	@Order(1)
	public void saveSocialNetworkPostTest(){
		SocialNetworkPost socialNetworkPost = new SocialNetworkPost();
		socialNetworkPost.setAuthorName("Ramesh");
		socialNetworkPost.setPostContent("test 123");
		socialNetworkPost.setPostDate(new Date(2020-12-30));
		socialNetworkPost.setViewCount(0L);
		socialNetworkPostRepository.save(socialNetworkPost);
		Assertions.assertThat(socialNetworkPost.getPostId()).isGreaterThan(0);
	}

	@Test
	@Order(2)
	public void getSocialNetworkPostTest(){
		SocialNetworkPost socialNetworkPost = socialNetworkPostRepository.getReferenceById(1L);
		Assertions.assertThat(socialNetworkPost.getPostId()).isEqualTo(1L);
	}

	@Test
	@Order(3)
	public void getListOfSocialNetworkPostTest(){
		List<SocialNetworkPost> socialNetworkPost = socialNetworkPostRepository.findAll();
		Assertions.assertThat(socialNetworkPost).hasSize(1);
	}

	@Test
	@Order(4)
	@Rollback(value = false)
	public void updateSocialNetworkPostTest(){
		SocialNetworkPost socialNetworkPost = socialNetworkPostRepository.getReferenceById(1L);
		socialNetworkPost.setPostContent("test 321");
		SocialNetworkPost socialNetworkPostUpdated = socialNetworkPostRepository.save(socialNetworkPost);
		Assertions.assertThat(socialNetworkPostUpdated.getPostContent()).isEqualTo("test 321");
	}

	@Test
	@Order(5)
	public void getListOfTopPostsTest(){
		List<SocialNetworkPost> socialNetworkPost = socialNetworkPostRepository.findTopPosts();
		Assertions.assertThat(socialNetworkPost.size()).isGreaterThan(0);
	}

	@Test
	@Order(6)
	@Rollback(value = false)
	public void deleteSocialNetworkPostTest(){
		SocialNetworkPost socialNetworkPost = socialNetworkPostRepository.getReferenceById(1L);
		socialNetworkPostRepository.delete(socialNetworkPost);
		//socialNetworkPostRepository.deleteById(1L);
		SocialNetworkPost socialNetworkPost1 = null;
		Optional<SocialNetworkPost> optionalSocialNetworkPost = socialNetworkPostRepository.findById(1L);
		if(optionalSocialNetworkPost.isPresent()){
			socialNetworkPost1 = optionalSocialNetworkPost.get();
		}
		Assertions.assertThat(socialNetworkPost1).isNull();
	}

}
