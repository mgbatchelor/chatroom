package com.mgbatchelor.nb.chatroom.model;

import java.util.Date;

public class ChatLeavesRoom extends ChatUserEvent {

	public ChatLeavesRoom(String userName, Date timestamp) {
		super(userName, timestamp);
	}

	@Override
	public String formatEvent() {
		return getFormattedTimestamp() + "<i>" + getUserName() + " leaves</i>";
	}

}
