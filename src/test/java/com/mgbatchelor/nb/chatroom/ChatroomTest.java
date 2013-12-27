package com.mgbatchelor.nb.chatroom;

import org.junit.Assert;
import org.junit.Test;

public class ChatroomTest {

	@Test
	public void test() {
		Chatroom chatroom = new Chatroom();
		Assert.assertEquals("The chatroom index controler should return the index view.", "index", chatroom.index());
	}

}
