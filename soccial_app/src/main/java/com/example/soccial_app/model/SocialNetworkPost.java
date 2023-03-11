package com.example.soccial_app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.Date;


@Entity
public class SocialNetworkPost {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long PostId;

	private String AuthorName;

	private String PostContent;

	private Date PostDate;

	private Long viewCount;

	public SocialNetworkPost(){}

	public Long getPostId() {
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

	public Long getViewCount() {
		return viewCount;
	}

	public void setViewCount(Long viewCount) {
		this.viewCount = viewCount;
	}

	@Override public String toString() {
		return "SocialNetworkPost{" +
				"PostId=" + PostId +
				", AuthorName='" + AuthorName + '\'' +
				", PostContent='" + PostContent + '\'' +
				", PostDate=" + PostDate +
				", viewCount=" + viewCount +
				'}';
	}

	@Override public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		SocialNetworkPost that = (SocialNetworkPost) o;

		if (PostId != that.PostId)
			return false;
		if (viewCount != that.viewCount)
			return false;
		if (!AuthorName.equals(that.AuthorName))
			return false;
		if (!PostContent.equals(that.PostContent))
			return false;
		return PostDate.equals(that.PostDate);
	}

	@Override public int hashCode() {
		int result = (int) (PostId ^ (PostId >>> 32));
		result = 31 * result + AuthorName.hashCode();
		result = 31 * result + PostContent.hashCode();
		result = 31 * result + PostDate.hashCode();
		result = 31 * result + (int) (viewCount ^ (viewCount >>> 32));
		return result;
	}
}
