package com.example.schduler_v2.schedule.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.schduler_v2.schedule.dto.ScheduleResponseDto;
import com.example.schduler_v2.schedule.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
	@Query("""
		SELECT new com.example.schduler_v2.schedule.dto.ScheduleResponseDto(
			s.title, s.content, s.userId, COUNT(c.id),s.createAt
		)
		FROM Schedule s
		LEFT JOIN Comment c ON c.schedule.id = s.id
		GROUP BY s.id, s.title, s.content, s.userId,s.createAt
	""")
	List<ScheduleResponseDto> findAllWithCommentCount();

}
