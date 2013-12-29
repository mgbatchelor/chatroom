package com.mgbatchelor.nb.chatroom.model;

import org.junit.Assert;
import org.junit.Test;

public class ChatSummaryGroupTest {

	@Test
	public void testFormatTimeRange() {
		Assert.assertEquals("Minute 10",
				ChatSummaryGroup.formatTimeRange("minute", 10));
		Assert.assertEquals("4:00 am",
				ChatSummaryGroup.formatTimeRange("hour", 4));
		Assert.assertEquals("2:00 pm",
				ChatSummaryGroup.formatTimeRange("hour", 14));
		Assert.assertEquals("Day Summary:",
				ChatSummaryGroup.formatTimeRange("day", 12));
	}

	@Test
	public void testFormatEvent() {
		ChatSummaryGroup group = new ChatSummaryGroup("hour", "13");
		group.addEvent(new ChatSummaryEvent("ENTER_EVT", 2L, 2L, 0L));
		group.addEvent(new ChatSummaryEvent("LEAVE_EVT", 2L, 2L, 0L));
		group.addEvent(new ChatSummaryEvent("HIGH_FIVE_EVT", 3L, 10L, 10L));
		group.addEvent(new ChatSummaryEvent("COMMENT_EVT", 10L, 10L, 0L));
		Assert.assertEquals(
				"<strong>1:00 pm</strong><p style='padding-left: 20px'>2 people entered</p><p style='padding-left: 20px'>2 people left</p><p style='padding-left: 20px'>10 people high-fived 10 other people</p><p style='padding-left: 20px'>10 comments</p>",
				group.formatEvent());
	}

}
