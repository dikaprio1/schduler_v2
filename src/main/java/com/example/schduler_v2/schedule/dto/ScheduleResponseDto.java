package com.example.schduler_v2.schedule.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.antlr.v4.runtime.misc.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleResponseDto {
	private String title;
	private String content;
	private String writerId;
	private Long commentCount;
	private LocalDateTime time;
}
