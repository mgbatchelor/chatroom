package com.mgbatchelor.nb.chatroom.model;

import java.util.Date;

public class ChatEntersRoom extends ChatUserEvent {

	public ChatEntersRoom(String userName, Date timestamp) {
		super(userName, timestamp);
	}
	
	@Override
	public String formatEvent() {
		return getFormattedTimestamp() + "<i>" + getUserName() + " enters</i>";
	}

}
