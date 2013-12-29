package com.mgbatchelor.nb.chatroom.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.mgbatchelor.nb.chatroom.db.AbstractQueryHandler;
import com.mgbatchelor.nb.chatroom.exception.ApplicationException;
import com.mgbatchelor.nb.chatroom.exception.DatabaseException;
import com.mgbatchelor.nb.chatroom.model.ChatEvent;
import com.mgbatchelor.nb.chatroom.model.ChatEventFactory;
import com.mgbatchelor.nb.chatroom.model.ChatSummaryEvent;
import com.mgbatchelor.nb.chatroom.model.ChatSummaryGroup;

public class ChatroomServiceImpl implements ChatroomService {

	private static final String CHATROOM_ID_SQL = "select chatroom_id from chatroom where name = ?";
	private static final String USERS_SQL = "select username from chatroom_users c, user u where c.user_id = u.user_id and c.chatroom_id = ?";
	private static final String EVENTS_SQL = "select event_type, u.username, comment, a.username, timestamp from event e, user u, user a where e.user_id = u.user_id and e.alt_user_id = a.user_id (+) and chatroom_id = ? order by timestamp asc";
	private static final String EVENT_SUMMARY_SQL = "select event_type, {RANGE}(timestamp) time, count(1) count, count(distinct(user_id)) count_dist_users, count(distinct(alt_user_id)) count_dist_alt_users  from event where chatRoom_id  = ? and day_of_year(timestamp) = ? group by event_type, {RANGE}(timestamp) order by time asc";

	public List<String> getChatroomUsers(long chatroomId)
			throws DatabaseException {
		final List<String> users = new ArrayList<String>();
		new AbstractQueryHandler() {

			@Override
			public void next(ResultSet rs) throws SQLException {
				String username = rs.getString(1);
				users.add(username);
			}
		}.select(USERS_SQL, chatroomId);
		return users;
	}

	public List<ChatEvent> getChatroomEvents(long chatroomId)
			throws DatabaseException {
		final List<ChatEvent> events = new ArrayList<ChatEvent>();
		new AbstractQueryHandler() {
			@Override
			public void next(ResultSet rs) throws SQLException {
				try {
					String type = rs.getString(1);
					String username = rs.getString(2);
					String comment = rs.getString(3);
					String altUsername = rs.getString(4);
					java.sql.Timestamp sqlTimestamp = rs.getTimestamp(5);
					Date timestamp = new Date(sqlTimestamp.getTime());
					ChatEvent event = ChatEventFactory.createEvent(type,
							username, comment, altUsername, timestamp);
					events.add(event);
				} catch (ApplicationException e) {
					System.err.println("Could not create event.");
					e.printStackTrace();
				}
			}
		}.select(EVENTS_SQL, chatroomId);
		return events;
	}

	public List<ChatEvent> getChatroomSummary(long chatroomId,
			final String range) throws DatabaseException {
		final Map<String, ChatSummaryGroup> events = new LinkedHashMap<String, ChatSummaryGroup>();
		new AbstractQueryHandler() {

			@Override
			public void next(ResultSet rs) throws SQLException {
				String type = rs.getString(1);
				String timeRange = rs.getString(2);
				Long count = rs.getLong(3);
				Long countDistUsers = rs.getLong(4);
				Long countDistAltUsers = rs.getLong(5);
				ChatSummaryGroup e = events.get(timeRange);
				if (e == null) {
					e = new ChatSummaryGroup(range, timeRange);
					events.put(timeRange, e);
				}
				e.addEvent(new ChatSummaryEvent(type, count, countDistUsers,
						countDistAltUsers));
			}
		}.select(EVENT_SUMMARY_SQL.replaceAll("\\{RANGE\\}", range),
				chatroomId, 1);
		return new ArrayList<ChatEvent>(events.values());
	}

	public long getChatroomId(String name) throws DatabaseException {
		final MutableInt value = new MutableInt();
		new AbstractQueryHandler() {
			@Override
			public void next(ResultSet rs) throws SQLException {
				value.setValue(rs.getInt(1));
			}
		}.select(CHATROOM_ID_SQL, name);
		Integer v = value.getValue();
		if (v == null) {
			throw new DatabaseException("Could not find chatroom.");
		}
		return value.getValue().longValue();
	}

	private final class MutableInt {
		private Integer value;

		public void setValue(int value) {
			this.value = value;
		}

		public Integer getValue() {
			return value;
		}
	}

}
