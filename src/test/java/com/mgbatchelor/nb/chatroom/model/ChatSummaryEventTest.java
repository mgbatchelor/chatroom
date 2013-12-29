package com.mgbatchelor.nb.chatroom.model;

import org.junit.Assert;
import org.junit.Test;

public class ChatSummaryEventTest {

	@Test
	public void testPeoplePlurality() {
		Assert.assertEquals("people", ChatSummaryEvent.person(0L));
		Assert.assertEquals("person", ChatSummaryEvent.person(1L));
		Assert.assertEquals("people", ChatSummaryEvent.person(2L));
	}

	@Test
	public void testCommentPlurality() {
		Assert.assertEquals("comments", ChatSummaryEvent.comment(0L));
		Assert.assertEquals("comment", ChatSummaryEvent.comment(1L));
		Assert.assertEquals("comments", ChatSummaryEvent.comment(2L));
	}

	@Test
	public void testEnterEventFormat() {
		ChatSummaryEvent e = new ChatSummaryEvent("ENTER_EVT", 1L, 1L, 0L);
		Assert.assertEquals("1 person entered", e.formatEvent());
	}

	@Test
	public void testLeaveEventFormat() {
		ChatSummaryEvent e = new ChatSummaryEvent("LEAVE_EVT", 1L, 1L, 0L);
		Assert.assertEquals("1 person left", e.formatEvent());
	}

	@Test
	public void testCommentEventFormat() {
		ChatSummaryEvent e = new ChatSummaryEvent("COMMENT_EVT", 20L, 2L, 0L);
		Assert.assertEquals("20 comments", e.formatEvent());
	}

	@Test
	public void testHighFiveEventFormat() {
		ChatSummaryEvent e = new ChatSummaryEvent("HIGH_FIVE_EVT", 1L, 10L, 2L);
		Assert.assertEquals("10 people high-fived 2 other people",
				e.formatEvent());
	}
}
