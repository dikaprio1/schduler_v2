package com.example.schduler_v2.schedule.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import com.example.schduler_v2.comment.dto.CommentDto;
import com.example.schduler_v2.comment.entity.Comment;
import com.example.schduler_v2.schedule.entity.Schedule;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleWithCommentsResponseDto {
	private String title;
	private String content;
	private Long writerId;
	private LocalDateTime createAt;
	private List<CommentDto> comments;

	public ScheduleWithCommentsResponseDto(Schedule schedule) {
		this.title = schedule.getTitle();
		this.content = schedule.getContent();
		this.writerId = schedule.getWriterId();
		this.createAt = schedule.getCreateAt();
		this.comments = schedule.getComments().stream()
			.map(CommentDto::new)
			.toList();
	}
}
