package com.example.schduler_v2.schedule.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import com.example.schduler_v2.schedule.entity.Schedule;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleResponseDto {
	private String title;
	private String content;
	private Long writerId;
	private LocalDateTime time;

}
