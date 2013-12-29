package com.mgbatchelor.nb.chatroom.model;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.mgbatchelor.nb.chatroom.exception.ApplicationException;

public class ChatEventFactoryTest {

	@Test(expected = ApplicationException.class)
	public void testCreateEventNullType() throws ApplicationException {
		ChatEventFactory.createEvent(null, null, null, null, null);
	}

	@Test(expected = ApplicationException.class)
	public void testCreateEventUnsupportedType() throws ApplicationException {
		ChatEventFactory.createEvent("unsupported", null, null, null, null);
	}

	@Test
	public void testCreateChatComment() throws ApplicationException {
		ChatEvent e = ChatEventFactory.createEvent("COMMENT_EVT", "user",
				"comment", null, new Date(0L));

		Assert.assertNotNull(e);
		Assert.assertEquals(0L, ((ChatUserEvent) e).getTimestamp().getTime());
		Assert.assertEquals("user", ((ChatUserEvent) e).getUserName());
		Assert.assertEquals(ChatComment.class.getCanonicalName(), e.getClass()
				.getCanonicalName());
		ChatComment c = (ChatComment) e;
		Assert.assertEquals("comment", c.getComment());
	}

	@Test
	public void testCreateChatEntersRoom() throws ApplicationException {
		ChatEvent e = ChatEventFactory.createEvent("ENTER_EVT", "user", null,
				null, new Date(0L));
		Assert.assertNotNull(e);
		Assert.assertEquals(0L, ((ChatUserEvent) e).getTimestamp().getTime());
		Assert.assertEquals("user", ((ChatUserEvent) e).getUserName());
		Assert.assertEquals(ChatEntersRoom.class.getCanonicalName(), e
				.getClass().getCanonicalName());
	}

	@Test
	public void testChatLeavesRoom() throws ApplicationException {
		ChatEvent e = ChatEventFactory.createEvent("LEAVE_EVT", "user", null,
				null, new Date(0L));
		Assert.assertNotNull(e);
		Assert.assertEquals(0L, ((ChatUserEvent) e).getTimestamp().getTime());
		Assert.assertEquals("user", ((ChatUserEvent) e).getUserName());
		Assert.assertEquals(ChatLeavesRoom.class.getCanonicalName(), e
				.getClass().getCanonicalName());
	}

	@Test
	public void testChatHighFive() throws ApplicationException {

		ChatEvent e = ChatEventFactory.createEvent("HIGH_FIVE_EVT", "user",
				null, "user2", new Date(0L));
		Assert.assertNotNull(e);
		Assert.assertEquals(0L, ((ChatUserEvent) e).getTimestamp().getTime());
		Assert.assertEquals("user", ((ChatUserEvent) e).getUserName());
		Assert.assertEquals(ChatHighFive.class.getCanonicalName(), e.getClass()
				.getCanonicalName());
		ChatHighFive c = (ChatHighFive) e;
		Assert.assertEquals("user2", c.getAlternateUserName());
	}

}
