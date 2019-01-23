package com.ssafy.hw;

public class CodeNotFoundException extends Exception {

	public CodeNotFoundException() {
		super("존재하지 않는 상품번호 입니다.");
	}

	public CodeNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CodeNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public CodeNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CodeNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
