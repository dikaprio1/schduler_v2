package com.example.schduler_v2.comment.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponseDto {
	private Long writerId;
	private Long scheduleId;
	private String content;
	private LocalDateTime createdAt;
}
