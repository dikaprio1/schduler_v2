package com.example.schduler_v2.schedule.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import com.example.schduler_v2.schedule.entity.Schedule;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleCreateResponseDto {
	private String title;
	private String content;
	private Long writerId;
	private LocalDateTime createAt;
	private Long commentCount;

	public static ScheduleCreateResponseDto toDto(Schedule schedule, Long commentCount) {
		return new ScheduleCreateResponseDto(
			schedule.getTitle(),
			schedule.getContent(),
			schedule.getWriterId(),
			schedule.getCreateAt(),
			commentCount
		);
	}
}
