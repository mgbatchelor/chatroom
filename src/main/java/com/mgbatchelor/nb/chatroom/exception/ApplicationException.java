package com.mgbatchelor.nb.chatroom.exception;

public class ApplicationException extends Exception {

	private static final long serialVersionUID = 2152794146294776595L;

	public ApplicationException() {
		super();
	}

	public ApplicationException(String message) {
		super(message);
	}

	public ApplicationException(String message, Throwable t) {
		super(message, t);
	}

	public ApplicationException(Throwable t) {
		super(t);
	}

}
