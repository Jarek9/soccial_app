package com.example.soccial_app.repository;

import javax.persistence.Access;
import javax.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.soccial_app.model.SocialNetworkPost;

import java.util.List;

@Repository
public interface SocialNetworkPostRepository extends JpaRepository<SocialNetworkPost, Long> {

//	List<SocialNetworkPost> findTopPosts(String s);
}
