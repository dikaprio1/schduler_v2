package com.example.schduler_v2.comment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.schduler_v2.comment.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	List<Comment> findByScheduleIdAndDeleteAtIsNull(Long scheduleId);
}
