package com.study.helloworld;

public class JavaBean {
	private String message;

	public JavaBean(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "JavaBean [message=" + message + "]";
	}

}
