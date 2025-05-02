package com.example.schduler_v2.schedule.service;

import java.util.List;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.schduler_v2.schedule.dto.ScheduleListResponseDto;
import com.example.schduler_v2.schedule.dto.ScheduleRequestDto;
import com.example.schduler_v2.schedule.dto.ScheduleCreateResponseDto;
import com.example.schduler_v2.schedule.dto.ScheduleResponseDto;
import com.example.schduler_v2.schedule.dto.ScheduleUpdateRequestDto;
import com.example.schduler_v2.schedule.dto.ScheduleWithCommentsResponseDto;
import com.example.schduler_v2.schedule.entity.Schedule;
import com.example.schduler_v2.schedule.repository.ScheduleRepository;

@Service
@RequiredArgsConstructor
public class ScheduleService {
	private final ScheduleRepository scheduleRepository;

	public ScheduleCreateResponseDto createSchedule(@Valid @RequestBody ScheduleRequestDto requestDto){
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

	public ScheduleWithCommentsResponseDto findScheduleById(@PathVariable Long id){
		Schedule schedule = scheduleRepository.findByIdWithCommentOrElseThrow(id);
		return new ScheduleWithCommentsResponseDto(schedule);
	}
	@Transactional
	public ScheduleResponseDto updateSchedule(@PathVariable Long id, @RequestBody ScheduleUpdateRequestDto requestDto){
		Schedule schedule = scheduleRepository.findByIdOrElseThrow(id);
		if(requestDto.getTitle() != null){
			schedule.updateTitle(requestDto);
		}
		if(requestDto.getContent() != null){
			schedule.updateContent(requestDto);
		}
		return new ScheduleResponseDto(schedule.getTitle(),schedule.getContent(),schedule.getWriterId(),schedule.getUpdateAt());
	}
}
