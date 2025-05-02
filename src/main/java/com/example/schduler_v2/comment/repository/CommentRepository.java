package com.example.schduler_v2.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.schduler_v2.comment.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
