package com.mgbatchelor.nb.chatroom.model;

public abstract class ChatEvent {

	public enum Event {
		ENTER_EVT, COMMENT_EVT, HIGH_FIVE_EVT, LEAVE_EVT;
	}

	@Override
	public String toString() {
		return formatEvent();
	}

	public abstract String formatEvent();

}
