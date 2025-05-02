package com.example.schduler_v2.schedule.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.antlr.v4.runtime.misc.NotNull;
import com.example.schduler_v2.schedule.entity.Schedule;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleResponseDto {
	private String title;
	private String content;
	private Long writerId;
	private Long commentCount;
	private LocalDateTime time;

	public static ScheduleResponseDto toDto(Schedule schedule, Long commentCount) {
		return new ScheduleResponseDto(
			schedule.getTitle(),
			schedule.getContent(),
			schedule.getUserId(),
			commentCount,
			schedule.getCreateAt()
		);
	}
}
