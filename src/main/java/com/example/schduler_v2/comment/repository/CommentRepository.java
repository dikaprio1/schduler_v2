package com.example.schduler_v2.comment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.schduler_v2.comment.entity.Comment;
import com.example.schduler_v2.schedule.dto.ScheduleResponseDto;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
