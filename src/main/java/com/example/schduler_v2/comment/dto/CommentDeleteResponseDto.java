package com.example.schduler_v2.comment.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDeleteResponseDto {
	private String message;
	private LocalDateTime deletedAt;
}
