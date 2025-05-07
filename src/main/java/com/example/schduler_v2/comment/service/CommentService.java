package com.example.schduler_v2.comment.service;

import java.util.List;

import jakarta.transaction.Transactional;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import com.example.schduler_v2.comment.dto.CommentDeleteResponseDto;
import com.example.schduler_v2.comment.dto.CommentDto;
import com.example.schduler_v2.comment.dto.CommentResponseDto;
import com.example.schduler_v2.comment.dto.CommentCreateRequestDto;
import com.example.schduler_v2.comment.dto.CommentUpdateRequestDto;
import com.example.schduler_v2.comment.entity.Comment;
import com.example.schduler_v2.comment.repository.CommentRepository;
import com.example.schduler_v2.common.exception.CustomException;
import com.example.schduler_v2.common.exception.ErrorCode;
import com.example.schduler_v2.schedule.entity.Schedule;
import com.example.schduler_v2.schedule.repository.ScheduleRepository;

@Service
@RequiredArgsConstructor
public class CommentService {
	private final CommentRepository commentRepository;
	private final ScheduleRepository scheduleRepository;

	public CommentResponseDto createComment(Long scheduleId,CommentCreateRequestDto requestDto){

		Schedule schedule = scheduleRepository.findByIdOrElseThrow(scheduleId);
		Comment comment = new Comment(requestDto.getContent(), requestDto.getWriterId(), schedule, null);

		Comment saved = commentRepository.save(comment);

		return new CommentResponseDto(saved.getWriterId(), saved.getSchedule().getId(), saved.getContent(), saved.getCreateAt());
	}

	public CommentResponseDto createReply(Long scheduleId, Long parentCommentId, CommentCreateRequestDto requestDto) {
		Schedule schedule = scheduleRepository.findByIdOrElseThrow(scheduleId);

		Comment parentComment = commentRepository.findById(parentCommentId)
			.orElseThrow(() -> new CustomException(ErrorCode.COMMENT_NOT_FOUND));

		if (parentComment.getChildren() != null && parentComment.getChildren().getDeleteAt() == null) {
			throw new CustomException(ErrorCode.ALREADY_HAS_REPLY); // 이 에러코드는 직접 정의
		}

		Comment reply = new Comment(requestDto.getContent(), requestDto.getWriterId(), schedule, parentComment);

		Comment saved = commentRepository.save(reply);

		return new CommentResponseDto(saved.getWriterId(), saved.getSchedule().getId(), saved.getContent(), saved.getCreateAt());
	}
	public List<CommentDto> findAllComments(Long scheduleId) {
		List<Comment> commentList = commentRepository.findByScheduleIdAndDeleteAtIsNull(scheduleId);
		if (commentList.isEmpty()) {
			throw new CustomException(ErrorCode.COMMENT_NOT_FOUND);
		}
		return commentList.stream()
			.map(CommentDto::new)
			.toList();
	}

	public CommentDto findCommentById(Long commentId){
		Comment comment = commentRepository.findById(commentId)
			.orElseThrow(() -> new CustomException(ErrorCode.COMMENT_NOT_FOUND));
		if(comment.getDeleteAt() != null){
			throw new CustomException(ErrorCode.COMMENT_NOT_FOUND);
		}
		return new CommentDto(comment);
	}

	@Transactional
	public CommentResponseDto updateComment(Long commentId, CommentUpdateRequestDto requestDto) {
		Comment comment = commentRepository.findById(commentId)
			.orElseThrow(() -> new CustomException(ErrorCode.COMMENT_NOT_FOUND));
		if(comment.getDeleteAt() != null){
			throw new CustomException(ErrorCode.COMMENT_NOT_FOUND);
		}
		comment.updateContent(requestDto.getContent());
		commentRepository.save(comment); // 실질적으로는 없어도 되지만 명확히 해줌

		return new CommentResponseDto(comment.getWriterId(), comment.getSchedule().getId(), comment.getContent(), comment.getCreateAt());
	}

	@Transactional
	public CommentDeleteResponseDto deleteComment(Long commentId) {
		Comment comment = commentRepository.findById(commentId)
			.orElseThrow(() -> new CustomException(ErrorCode.COMMENT_NOT_FOUND));
		if (comment.getDeleteAt() != null) {
			throw new CustomException(ErrorCode.COMMENT_NOT_FOUND);
		}
		comment.softDelete();

		return new CommentDeleteResponseDto("댓글이 삭제되었습니다.", comment.getDeleteAt());
	}
}
