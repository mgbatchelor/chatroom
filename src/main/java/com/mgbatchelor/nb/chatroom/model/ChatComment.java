package com.mgbatchelor.nb.chatroom.model;

import java.util.Date;

public class ChatComment extends ChatUserEvent {

	private String comment;

	public ChatComment(String comment, String userName, Date timestamp) {
		super(userName, timestamp);
		this.comment = comment;
	}

	public String getComment() {
		return comment;
	}

	@Override
	public String formatEvent() {
		return getFormattedTimestamp() + "<b>" + getUserName()
				+ " comments: </b>" + getComment();
	}

}
