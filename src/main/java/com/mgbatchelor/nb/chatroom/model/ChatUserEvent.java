package com.mgbatchelor.nb.chatroom.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class ChatUserEvent extends ChatEvent {

	private static final String TIMESTAMP_FORMAT = "h:mm a";

	private String userName;
	private Date timestamp;

	public ChatUserEvent(String userName, Date timestamp) {
		this.userName = userName;
		this.timestamp = timestamp;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getUserName() {
		return userName;
	}

	public String getFormattedTimestamp() {
		SimpleDateFormat sdf = new SimpleDateFormat(TIMESTAMP_FORMAT);
		return "<i>" + sdf.format(getTimestamp()) + "</i>&nbsp;";
	}
}
