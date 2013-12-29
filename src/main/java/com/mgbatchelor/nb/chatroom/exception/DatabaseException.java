package com.mgbatchelor.nb.chatroom.exception;

public class DatabaseException extends ApplicationException {
	private static final long serialVersionUID = 7797454181933115357L;

	public DatabaseException() {
		super();
	}

	public DatabaseException(String message) {
		super(message);
	}

	public DatabaseException(String message, Throwable t) {
		super(message, t);
	}

	public DatabaseException(Throwable t) {
		super(t);
	}

}
