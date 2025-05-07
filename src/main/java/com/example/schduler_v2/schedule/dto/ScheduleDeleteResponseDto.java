package com.example.schduler_v2.schedule.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleDeleteResponseDto {
	private String message;
	private LocalDateTime deletedAt;
}
