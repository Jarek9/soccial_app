package com.example.soccial_app.payloads.request;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class SocialNetworkPostRequest {

	@NotBlank
	@NotNull
	private long PostId;

	@NotBlank
	@NotNull
	private String AuthorName;

	@NotBlank
	@NotNull
	private String PostContent;

	@NotBlank
	@NotNull
	private Date PostDate;

	private int viewCount;

	public long getPostId() {
		return PostId;
	}

	public void setPostId(long postId) {
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

	public long getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
}
