package com.example.schduler_v2.schedule.dto;

import jakarta.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleRequestDto {

	@NotBlank
	private String title;

	private String content;

	@NotBlank
	private Long writerId;
}
