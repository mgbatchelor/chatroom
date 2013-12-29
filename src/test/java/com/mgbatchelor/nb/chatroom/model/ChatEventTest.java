package com.mgbatchelor.nb.chatroom.model;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class ChatEventTest {

	@Test
	public void testChatCommentFormat() {
		ChatComment comment = new ChatComment("Comment test value", "User",
				new Date(0L));
		Assert.assertEquals(
				"<i>4:00 PM</i>&nbsp;<b>User comments: </b>Comment test value",
				comment.formatEvent());
	}

	@Test
	public void testChatEntersRoomFormat() {
		ChatEntersRoom enter = new ChatEntersRoom("User", new Date(0L));
		Assert.assertEquals("<i>4:00 PM</i>&nbsp;<i>User enters</i>",
				enter.formatEvent());
	}

	@Test
	public void testChatHighFiveFormat() {
		ChatHighFive highFive = new ChatHighFive("Other", "User", new Date(0L));
		Assert.assertEquals("<i>4:00 PM</i>&nbsp;<i>User high-fives Other</i>",
				highFive.formatEvent());
	}

	@Test
	public void testChatLeavesRoomFormat() {
		ChatLeavesRoom leave = new ChatLeavesRoom("User", new Date(0L));
		Assert.assertEquals("<i>4:00 PM</i>&nbsp;<i>User leaves</i>",
				leave.formatEvent());
	}

}
