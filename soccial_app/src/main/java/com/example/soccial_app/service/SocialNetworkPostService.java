package com.example.soccial_app.service;

import org.springframework.stereotype.Component;

import com.example.soccial_app.model.SocialNetworkPost;
import com.example.soccial_app.payloads.request.SocialNetworkPostRequest;
import com.example.soccial_app.payloads.response.MessageResponse;

import java.util.List;
import java.util.Optional;

@Component
public interface SocialNetworkPostService {
	MessageResponse createSocialNetworkPost(SocialNetworkPostRequest socialNetworkPostRequest);
	Optional<SocialNetworkPost> updateSocialNetworkPost(Long PostId, SocialNetworkPostRequest socialNetworkPostRequest);
	void deleteSocialNetworkPost(Long PostId);
	SocialNetworkPost getASingleSocialNetworkPost(Long PostId);
	List<SocialNetworkPost> getAllSocialNetworkPost();
//	List<SocialNetworkPost> getTenMostPopularPosts();
}
