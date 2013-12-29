package com.mgbatchelor.nb.chatroom.model;

import java.util.Date;

import com.mgbatchelor.nb.chatroom.exception.ApplicationException;
import com.mgbatchelor.nb.chatroom.model.ChatEvent.Event;

public class ChatEventFactory {

	public static ChatEvent createEvent(String type, String username,
			String comment, String altUsername, Date timestamp)
			throws ApplicationException {
		ChatEvent event = null;
		try {
			if (type == null) {
				throw new ApplicationException("Event type cannot be null.");
			}
			Event eventType = Event.valueOf(type);
			switch (eventType) {
			case COMMENT_EVT:
				event = new ChatComment(comment, username, timestamp);
				break;
			case ENTER_EVT:
				event = new ChatEntersRoom(username, timestamp);
				break;
			case LEAVE_EVT:
				event = new ChatLeavesRoom(username, timestamp);
				break;
			case HIGH_FIVE_EVT:
				event = new ChatHighFive(altUsername, username, timestamp);
				break;
			default:
				// Cannot occur unless a new ENUM value is added.
			}
		} catch (IllegalArgumentException e) {
			throw new ApplicationException("Event type " + type
					+ " not supported.");
		}
		return event;
	}
}
