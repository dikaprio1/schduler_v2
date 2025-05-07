package com.example.schduler_v2.comment.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import com.example.schduler_v2.comment.entity.Comment;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
	private Long writerId;
	private String content;
	private LocalDateTime createAt;
	private RepliesDto replies;

	public CommentDto(Comment comment) {
		this.writerId = comment.getWriterId();
		this.content = comment.getContent();
		this.createAt = comment.getCreateAt();
		if (comment.getChildren() != null) {
			this.replies = new RepliesDto(comment.getChildren());
		}
	}
}
