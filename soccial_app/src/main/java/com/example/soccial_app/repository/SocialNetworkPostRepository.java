package com.example.soccial_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.soccial_app.model.SocialNetworkPost;

import java.util.List;

@Repository
public interface SocialNetworkPostRepository extends JpaRepository<SocialNetworkPost, Long> {

	@Query (value="SELECT * FROM SOCIAL_NETWORK_POST ORDER BY VIEW_COUNT Desc LIMIT 10", nativeQuery = true)
	List<SocialNetworkPost> findTopPosts();
}
