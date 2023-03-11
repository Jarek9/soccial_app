package com.example.soccial_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.soccial_app.model.SocialNetworkPost;
import com.example.soccial_app.payloads.request.SocialNetworkPostRequest;
import com.example.soccial_app.payloads.response.MessageResponse;
import com.example.soccial_app.service.SocialNetworkPostService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/SocialNetworkPost")
public class SocialNetworkPostController {
	@Autowired
	SocialNetworkPostService socialNetworkPostService;

	@GetMapping("/all")
	public ResponseEntity<List<SocialNetworkPost>> getAllSocialNetworkPost () {
		List<SocialNetworkPost> socialNetworkPost = socialNetworkPostService.getAllSocialNetworkPost();
		return new ResponseEntity<>(socialNetworkPost, HttpStatus.OK);
	}

	@GetMapping("/topPosts")
	public ResponseEntity<List<SocialNetworkPost>> getTenMostPopularPosts () {
		List<SocialNetworkPost> socialNetworkPost = socialNetworkPostService.getTenMostPopularPosts();
		return new ResponseEntity<>(socialNetworkPost, HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<SocialNetworkPost> getSocialNetworkPostById (@PathVariable("id") Long postId) {
		SocialNetworkPost socialNetworkPost = socialNetworkPostService.getASingleSocialNetworkPost(postId);
		return new ResponseEntity<>(socialNetworkPost, HttpStatus.OK);
	}
	@PostMapping("/add")
	public ResponseEntity<MessageResponse> createSocialNetworkPost( @RequestBody SocialNetworkPostRequest socialNetworkPostRequest) {
		MessageResponse newSocialNetworkPost = socialNetworkPostService.createSocialNetworkPost(socialNetworkPostRequest);
		return new ResponseEntity<>(newSocialNetworkPost, HttpStatus.CREATED);
	}
	@PutMapping("/update/{postId}")
	public ResponseEntity<MessageResponse> updateSocialNetworkPost( @PathVariable("postId") Long postId, @RequestBody SocialNetworkPostRequest socialNetworkPostRequest) {
		Optional<SocialNetworkPost> SocialNetworkPost = socialNetworkPostService.updateSocialNetworkPost(postId, socialNetworkPostRequest);
		return new ResponseEntity(SocialNetworkPost, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{postId}")
	public ResponseEntity<?> deleteSocialNetworkPost(@PathVariable("postId") Long postId) {
		socialNetworkPostService.deleteSocialNetworkPost(postId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
