package com.movie.app.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({@NamedQuery(name = "Comment.findAll", query = "SELECT c from Comment c ")})

public class Comment {
	@Id
	private String commentId;
	private String text;
	private int rating;

	public Comment() {
		commentId = UUID.randomUUID().toString();
	}

	public String getCommentId() {
		return commentId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Comments [commentId=" + commentId + ", text=" + text + ", rating=" + rating + "]";
	}

}
