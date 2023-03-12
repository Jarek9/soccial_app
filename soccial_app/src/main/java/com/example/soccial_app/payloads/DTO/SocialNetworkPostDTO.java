package com.example.soccial_app.payloads.DTO;


import java.util.Date;

public class SocialNetworkPostDTO {
	private Long PostId;
	private String AuthorName;
	private String PostContent;
	private Date PostDate;

	public SocialNetworkPostDTO() {}

	public Long getPostId() {
		return PostId;
	}

	public void setPostId(Long postId) {
		PostId = postId;
	}

	public String getAuthorName() {
		return AuthorName;
	}

	public void setAuthorName(String authorName) {
		AuthorName = authorName;
	}

	public String getPostContent() {
		return PostContent;
	}

	public void setPostContent(String postContent) {
		PostContent = postContent;
	}

	public Date getPostDate() {
		return PostDate;
	}

	public void setPostDate(Date postDate) {
		PostDate = postDate;
	}
}
