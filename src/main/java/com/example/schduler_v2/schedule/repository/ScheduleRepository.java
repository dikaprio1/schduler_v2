package com.example.schduler_v2.schedule.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.schduler_v2.common.exception.CustomException;
import com.example.schduler_v2.common.exception.ErrorCode;
import com.example.schduler_v2.schedule.dto.ScheduleListResponseDto;
import com.example.schduler_v2.schedule.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
	@Query("""
		SELECT new com.example.schduler_v2.schedule.dto.ScheduleListResponseDto(
			s.title, s.content, s.writerId, COUNT(c.id),s.createAt
		)
		FROM Schedule s
		LEFT JOIN Comment c ON c.schedule.id = s.id
		WHERE s.deleteAt IS NULL
		GROUP BY s.id, s.title, s.content, s.writerId,s.createAt
	""")
	List<ScheduleListResponseDto> findAllWithCommentCount();

	@EntityGraph(attributePaths = "comments")
	default Schedule findByIdWithCommentOrElseThrow(Long id) {
		return findById(id).orElseThrow(() ->
			new CustomException(ErrorCode.SCHEDULE_NOT_FOUND)); // 조회 실패시(해당 id 없을 때) 404, "존재하지 않는 정보입니다."
	}

	default Schedule findByIdOrElseThrow(Long id) {
		return findById(id).orElseThrow(() ->
			new CustomException(ErrorCode.SCHEDULE_NOT_FOUND)); // 조회 실패시(해당 id 없을 때) 404, "존재하지 않는 정보입니다."
	}

}
