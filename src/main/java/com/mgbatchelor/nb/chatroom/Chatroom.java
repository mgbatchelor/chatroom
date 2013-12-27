package com.mgbatchelor.nb.chatroom;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class Chatroom {

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "index";
	}
}
