package com.example.schduler_v2.schedule.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.schduler_v2.schedule.dto.ScheduleRequestDto;
import com.example.schduler_v2.schedule.dto.ScheduleResponseDto;
import com.example.schduler_v2.schedule.entity.Schedule;
import com.example.schduler_v2.schedule.service.ScheduleService;

@RestController
@RequestMapping("/schedule")
@RequiredArgsConstructor
public class ScheduleController {
	private final ScheduleService scheduleService;

	@PostMapping
	public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto requestDto){
		ScheduleResponseDto responseDto = scheduleService.createSchedule(requestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<ScheduleResponseDto>> findAllSchedules(){
		List<ScheduleResponseDto> scheduleList = scheduleService.findAllSchedules();
		return new ResponseEntity<>(scheduleList, HttpStatus.OK);
	}

	// @GetMapping("/{id}")
	// public ResponseEntity<ScheduleResponseDto> findScheduleById(@PathVariable Long id){
	// 	ScheduleResponseDto responseDto = scheduleService.findScheduleById(id);
	// 	return new ResponseEntity<>(responseDto, HttpStatus.OK);
	// }

	// @PutMapping("/{id}")
	// public ResponseEntity<ScheduleResponseDto> updateSchedule(@PathVariable Long id,@RequestBody ScheduleRequestDto requestDto){
	// 	ScheduleResponseDto responseDto = scheduleService.updateSchedule(id,requestDto);
	// 	return new ResponseEntity<>(responseDto, HttpStatus.OK);
	// }

	// @DeleteMapping("/{id}")
	// public ResponseEntity<ScheduleResponseDto> deleteSchedule(@PathVariable Long id){
	// 	ScheduleResponseDto responseDto = scheduleService.deleteSchedule(requestDto);
	// 	return new ResponseEntity<>(responseDto, HttpStatus.OK);
	// }
}
