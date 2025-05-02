package com.example.schduler_v2.schedule.service;

import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import com.example.schduler_v2.comment.repository.CommentRepository;
import com.example.schduler_v2.schedule.dto.ScheduleRequestDto;
import com.example.schduler_v2.schedule.dto.ScheduleResponseDto;
import com.example.schduler_v2.schedule.entity.Schedule;
import com.example.schduler_v2.schedule.repository.ScheduleRepository;

@Service
@RequiredArgsConstructor
public class ScheduleService {
	private final ScheduleRepository scheduleRepository;

	public ScheduleResponseDto createSchedule(ScheduleRequestDto requestDto){
		Long id = requestDto.getWriterId();
		String title = requestDto.getTitle();
		String content = requestDto.getContent();
		Schedule schedule = new Schedule(id,title,content);
		scheduleRepository.save(schedule);

		return new ScheduleResponseDto(schedule.getTitle(),schedule.getContent(),schedule.getUserId(),0L,schedule.getCreateAt());
	}
	public List<ScheduleResponseDto> findAllSchedules(){
		return scheduleRepository.findAllWithCommentCount();
	}
}
