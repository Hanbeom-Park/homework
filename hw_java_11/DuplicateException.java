package com.ssafy.hw;

public class DuplicateException extends Exception {

	public DuplicateException() {
		// TODO Auto-generated constructor stub
		super("이미 존재하는 상품입니다.");
	}

	public DuplicateException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DuplicateException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public DuplicateException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DuplicateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
