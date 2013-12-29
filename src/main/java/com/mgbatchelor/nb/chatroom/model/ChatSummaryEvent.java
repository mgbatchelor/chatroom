package com.mgbatchelor.nb.chatroom.model;

public class ChatSummaryEvent extends ChatEvent {

	private Event eventType;
	private Long count;
	private Long countDistUsers;
	private Long countDistAltUsers;

	public ChatSummaryEvent(String type, Long count, Long countDistUsers,
			Long countDistAltUsers) {
		eventType = Event.valueOf(type);
		this.count = count;
		this.countDistUsers = countDistUsers;
		this.countDistAltUsers = countDistAltUsers;
	}

	public Event getEventType() {
		return eventType;
	}

	public Long getCount() {
		return count;
	}

	public Long getCountDistUsers() {
		return countDistUsers;
	}

	public Long getCountDistAltUsers() {
		return countDistAltUsers;
	}

	@Override
	public String formatEvent() {
		StringBuffer sb = new StringBuffer();
		switch (getEventType()) {
		case ENTER_EVT:
			sb.append(getCountDistUsers()).append(" ")
					.append(person(getCountDistUsers())).append(" entered");
			break;
		case LEAVE_EVT:
			sb.append(getCountDistUsers()).append(" ")
					.append(person(getCountDistUsers())).append(" left");
			break;
		case COMMENT_EVT:
			sb.append(getCount()).append(" ")
					.append(comment(getCount()));
			break;
		case HIGH_FIVE_EVT:
			sb.append(countDistUsers).append(" ")
					.append(person(countDistUsers)).append(" high-fived ")
					.append(countDistAltUsers).append(" other ")
					.append(person(countDistAltUsers));
			break;
		default:
			// do nothing
		}

		return sb.toString();
	}

	public static String comment(Long count) {
		return count == 1 ? "comment" : "comments";
	}

	public static String person(Long count) {
		return count == 1 ? "person" : "people";
	}

}
