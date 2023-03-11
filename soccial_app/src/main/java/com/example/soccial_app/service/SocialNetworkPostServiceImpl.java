package com.example.soccial_app.service;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.soccial_app.model.SocialNetworkPost;
import com.example.soccial_app.payloads.request.SocialNetworkPostRequest;
import com.example.soccial_app.payloads.response.MessageResponse;
import com.example.soccial_app.repository.SocialNetworkPostRepository;


import java.util.List;
import java.util.Optional;

@Service
public class SocialNetworkPostServiceImpl implements SocialNetworkPostService {

	@Autowired
	SocialNetworkPostRepository socialNetworkPostRepository;

	@Override
	public MessageResponse createSocialNetworkPost(SocialNetworkPostRequest socialNetworkPostRequest) {
		SocialNetworkPost socialNetworkPost = new SocialNetworkPost();
		socialNetworkPost.setAuthorName(socialNetworkPostRequest.getAuthorName());
		socialNetworkPost.setPostContent(socialNetworkPostRequest.getPostContent());
		socialNetworkPost.setPostDate(socialNetworkPostRequest.getPostDate());
		socialNetworkPost.setViewCount(socialNetworkPostRequest.getViewCount());
		socialNetworkPostRepository.save(socialNetworkPost);
		return new MessageResponse("New SocialNetworkPost created successfully");

	}

	@Override
	public Optional<SocialNetworkPost> updateSocialNetworkPost(Long postId, SocialNetworkPostRequest socialNetworkPostRequest)  throws ResourceNotFoundException{
		Optional<SocialNetworkPost> socialNetworkPost = socialNetworkPostRepository.findById(postId);
		if (socialNetworkPost == null){
			throw new ResourceNotFoundException("Can not update SocialNetworkPost =" + postId);
		}
		else {
			socialNetworkPost.get().setAuthorName(socialNetworkPostRequest.getAuthorName());
			socialNetworkPost.get().setPostContent(socialNetworkPostRequest.getPostContent());
			socialNetworkPost.get().setPostDate(socialNetworkPostRequest.getPostDate());
			socialNetworkPost.get().setViewCount(socialNetworkPostRequest.getViewCount());
			socialNetworkPostRepository.save(socialNetworkPost.get());
		return socialNetworkPost;
		}
	}

	@Override
	public SocialNetworkPost getASingleSocialNetworkPost(Long postId) throws ResourceNotFoundException{
		return socialNetworkPostRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Can not update socialNetworkPost = " + postId));
	}

	@Override
	public List<SocialNetworkPost> getAllSocialNetworkPost() {
		return socialNetworkPostRepository.findAll();
	}

//	@Override
//	public List<SocialNetworkPost> getTenMostPopularPosts() {
//		return socialNetworkPostRepository.findTopPosts("SELECT * FROM SOCIAL_NETWORK_POST ORDER BY VIEW_COUNT Desc LIMIT 10");
//	}

	@Override
	public void deleteSocialNetworkPost(Long postId) throws ResourceNotFoundException {
		Long postIdToDelete = socialNetworkPostRepository.getReferenceById(postId).getPostId();
		if (postIdToDelete.equals(postId)){
			socialNetworkPostRepository.deleteById(postId);
		}
		else throw new ResourceNotFoundException("Can not delete SocialNetworkPost = " + postId);
	}
}
