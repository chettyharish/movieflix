package com.movie.app.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table
@NamedQueries({@NamedQuery(name = "Comment.findAll", query = "SELECT c from Comment c ")})

public class Comment {
	@Id
	private String commentId;

	@JsonProperty("Text")
	private String text;

	@JsonProperty("Rating")
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
		return "Comment [commentId=" + commentId + ", text=" + text + ", rating=" + rating + "]";
	}

}
