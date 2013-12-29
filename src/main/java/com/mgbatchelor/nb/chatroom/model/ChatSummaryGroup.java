package com.mgbatchelor.nb.chatroom.model;

import java.util.ArrayList;
import java.util.List;

public class ChatSummaryGroup extends ChatEvent {

	private String rangeType;
	private String timeRange;

	private List<ChatSummaryEvent> events = new ArrayList<ChatSummaryEvent>();

	public ChatSummaryGroup(String rangeType, String timeRange) {
		this.rangeType = rangeType;
		this.timeRange = timeRange;
	}

	public String getRangeType() {
		return rangeType;
	}

	public String getTimeRange() {
		return timeRange;
	}

	public void addEvent(ChatSummaryEvent event) {
		this.events.add(event);
	}

	public static String formatTimeRange(String rangeType, int timeRange) {
		StringBuffer sb = new StringBuffer();
		if ("minute".equals(rangeType)) {
			sb.append("Minute ").append(timeRange);
		} else if ("hour".equals(rangeType)) {
			sb.append(timeRange <= 12 ? timeRange + ":00 am" : timeRange - 12
					+ ":00 pm");
		} else if ("day".equals(rangeType)) {
			sb.append("Day Summary:");
		}
		return sb.toString();
	}

	@Override
	public String formatEvent() {
		StringBuffer sb = new StringBuffer();
		sb.append("<strong>")
				.append(formatTimeRange(getRangeType(),
						Integer.parseInt(getTimeRange()))).append("</strong>");
		for (ChatSummaryEvent e : events) {
			sb.append("<p style='padding-left: 20px'>").append(e)
					.append("</p>");
		}
		return sb.toString();
	}

}
