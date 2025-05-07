package com.example.schduler_v2.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class ErrorResponse {
	private final String code;
	private final String message;
	private final int status;
}
