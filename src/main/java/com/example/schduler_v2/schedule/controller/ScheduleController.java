package com.example.schduler_v2.schedule.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.schduler_v2.schedule.dto.ScheduleDeleteResponseDto;
import com.example.schduler_v2.schedule.dto.ScheduleListResponseDto;
import com.example.schduler_v2.schedule.dto.ScheduleRequestDto;
import com.example.schduler_v2.schedule.dto.ScheduleCreateResponseDto;
import com.example.schduler_v2.schedule.dto.ScheduleResponseDto;
import com.example.schduler_v2.schedule.dto.ScheduleUpdateRequestDto;
import com.example.schduler_v2.schedule.dto.ScheduleWithCommentsResponseDto;
import com.example.schduler_v2.schedule.service.ScheduleService;

@RestController
@RequestMapping("/schedule")
@RequiredArgsConstructor
public class ScheduleController {
	private final ScheduleService scheduleService;

	@PostMapping
	public ResponseEntity<ScheduleCreateResponseDto> createSchedule(@RequestBody ScheduleRequestDto requestDto){
		ScheduleCreateResponseDto responseDto = scheduleService.createSchedule(requestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<ScheduleListResponseDto>> findAllSchedules(){
		List<ScheduleListResponseDto> scheduleList = scheduleService.findAllSchedules();
		return new ResponseEntity<>(scheduleList, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ScheduleWithCommentsResponseDto> findScheduleById(@PathVariable Long id){
		ScheduleWithCommentsResponseDto responseDto = scheduleService.findScheduleById(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ScheduleResponseDto> updateSchedule(@PathVariable Long id,@RequestBody ScheduleUpdateRequestDto requestDto){
		ScheduleResponseDto responseDto = scheduleService.updateSchedule(id,requestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ScheduleDeleteResponseDto> deleteSchedule(@PathVariable Long id){
		ScheduleDeleteResponseDto responseDto = scheduleService.deleteSchedule(id);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
