package com.mgbatchelor.nb.chatroom.services;

import java.util.List;

import com.mgbatchelor.nb.chatroom.exception.DatabaseException;
import com.mgbatchelor.nb.chatroom.model.ChatEvent;

public interface ChatroomService {

	/**
	 * Get the chatroom ID for the chatroom name provided. If the name does not
	 * exist in the database, it will throw a database exception.
	 * 
	 * @param name
	 * @return
	 * @throws DatabaseException
	 */
	long getChatroomId(String name) throws DatabaseException;

	/**
	 * Get the list of users that are currently in the chatroom.
	 * 
	 * @param chatroomId
	 * @return
	 * @throws DatabaseException
	 */
	List<String> getChatroomUsers(long chatroomId) throws DatabaseException;

	/**
	 * Get a list of the ordered events that have occurred in the chatroom.
	 * 
	 * @param chatroomId
	 * @return
	 * @throws DatabaseException
	 */
	List<ChatEvent> getChatroomEvents(long chatroomId) throws DatabaseException;

	/**
	 * Get the summary list of events that occurred in the chatroom, grouped by
	 * the range type provided.
	 * 
	 * @param chatroomId
	 * @param range Allows 'minute', 'hour', and 'day'
	 * @return
	 * @throws DatabaseException
	 */
	List<ChatEvent> getChatroomSummary(long chatroomId, String range)
			throws DatabaseException;

}
