package com.example.schduler_v2.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
	EXIST_CHILD_COMMENT("BAD-001", "이미 대댓글이 존재합니다", 400),

	COMMENT_NOT_FOUND("NF-001", "댓글이 존재하지 않습니다.", 404),
	SCHEDULE_NOT_FOUND("NF-002", "존재하지 않는 일정입니다.", 404),
	ALREADY_HAS_REPLY("COMMENT_409", "해당 댓글에는 이미 대댓글이 존재합니다.", 409);

	private final String code;
	private final String message;
	private final int status;
}
