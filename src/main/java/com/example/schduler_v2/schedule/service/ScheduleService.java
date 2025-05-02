package com.example.schduler_v2.schedule.service;

import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import com.example.schduler_v2.schedule.dto.ScheduleListResponseDto;
import com.example.schduler_v2.schedule.dto.ScheduleRequestDto;
import com.example.schduler_v2.schedule.dto.ScheduleCreateResponseDto;
import com.example.schduler_v2.schedule.dto.ScheduleWithCommentsResponseDto;
import com.example.schduler_v2.schedule.entity.Schedule;
import com.example.schduler_v2.schedule.repository.ScheduleRepository;

@Service
@RequiredArgsConstructor
public class ScheduleService {
	private final ScheduleRepository scheduleRepository;

	public ScheduleCreateResponseDto createSchedule(ScheduleRequestDto requestDto){
		Long id = requestDto.getWriterId();
		String title = requestDto.getTitle();
		String content = requestDto.getContent();
		Schedule schedule = new Schedule(id,title,content);
		scheduleRepository.save(schedule);

		return new ScheduleCreateResponseDto(schedule.getTitle(),schedule.getContent(),schedule.getWriterId(),schedule.getCreateAt(),0L);
	}
	public List<ScheduleListResponseDto> findAllSchedules(){
		return scheduleRepository.findAllWithCommentCount();
	}

	public ScheduleWithCommentsResponseDto findScheduleById(Long id){
		Schedule schedule = scheduleRepository.findByIdWithCommentOrElseThrow(id);

		return new ScheduleWithCommentsResponseDto(schedule);
	}
}
