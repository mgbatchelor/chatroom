package com.mgbatchelor.nb.chatroom.model;

import java.util.Date;

public class ChatHighFive extends ChatUserEvent {

	private String alternateUserName;

	public ChatHighFive(String alternateUserName, String userName,
			Date timestamp) {
		super(userName, timestamp);
		this.alternateUserName = alternateUserName;
	}

	public String getAlternateUserName() {
		return alternateUserName;
	}

	@Override
	public String formatEvent() {
		return getFormattedTimestamp() + "<i>" + getUserName() + " high-fives "
				+ getAlternateUserName() + "</i>";
	}

}
