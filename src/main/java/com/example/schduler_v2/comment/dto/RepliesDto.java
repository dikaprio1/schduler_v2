package com.example.schduler_v2.comment.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import com.example.schduler_v2.comment.entity.Comment;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RepliesDto {
	private Long writerId;
	private String content;
	private LocalDateTime createAt;

	public RepliesDto(Comment comment) {
		this.writerId = comment.getWriterId();
		this.content = comment.getContent();
		this.createAt = comment.getCreateAt();
	}
}
