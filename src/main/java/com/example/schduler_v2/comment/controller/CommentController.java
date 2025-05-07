package com.example.schduler_v2.comment.controller;

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
import com.example.schduler_v2.comment.dto.CommentCreateRequestDto;
import com.example.schduler_v2.comment.dto.CommentDeleteResponseDto;
import com.example.schduler_v2.comment.dto.CommentDto;
import com.example.schduler_v2.comment.dto.CommentResponseDto;
import com.example.schduler_v2.comment.dto.CommentUpdateRequestDto;
import com.example.schduler_v2.comment.service.CommentService;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class CommentController {
	private final CommentService commentService;

	@PostMapping("/schedule/{scheduleId}/comments")
	public ResponseEntity<CommentResponseDto> createComment(@PathVariable Long scheduleId, @RequestBody CommentCreateRequestDto requestDto){
		CommentResponseDto responseDto = commentService.createComment(scheduleId,requestDto);
		return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
	}
	@PostMapping("/schedule/{scheduleId}/comments/{parentCommentId}/replies")
	public ResponseEntity<CommentResponseDto> createReply(@PathVariable Long scheduleId, @PathVariable Long parentCommentId, @RequestBody CommentCreateRequestDto requestDto) {
		CommentResponseDto response = commentService.createReply(scheduleId, parentCommentId, requestDto);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/schedule/{scheduleId}/comments")
	public ResponseEntity<List<CommentDto>> findAllComments(@PathVariable Long scheduleId){
		List<CommentDto> commentList = commentService.findAllComments(scheduleId);
		return new ResponseEntity<>(commentList, HttpStatus.OK);
	}

	@GetMapping("/comments/{commentId}")
	public ResponseEntity<CommentDto> findCommentById(@PathVariable Long commentId){
		CommentDto responseDto = commentService.findCommentById(commentId);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PutMapping("/comments/{commentId}")
	public ResponseEntity<CommentResponseDto> updateComment(@PathVariable Long commentId, @RequestBody CommentUpdateRequestDto requestDto) {
		CommentResponseDto responseDto = commentService.updateComment(commentId, requestDto);
		return ResponseEntity.ok(responseDto);
	}

	@DeleteMapping("/comments/{commentId}")
	public ResponseEntity<CommentDeleteResponseDto> deleteComment(@PathVariable Long commentId) {
		CommentDeleteResponseDto responseDto = commentService.deleteComment(commentId);
		return ResponseEntity.ok(responseDto);
	}
}
