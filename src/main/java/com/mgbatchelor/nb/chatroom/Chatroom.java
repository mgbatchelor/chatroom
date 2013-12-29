package com.mgbatchelor.nb.chatroom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mgbatchelor.nb.chatroom.exception.DatabaseException;
import com.mgbatchelor.nb.chatroom.services.ChatroomService;

/**
 * Chatroom controller that handles all mappings from the URL routes to views,
 * and adds the necessary data to the model.
 * 
 * @author michaelbatchelor
 * 
 */
@Controller
@RequestMapping(value = "/")
public class Chatroom {

	private static final String SUMMARY_QUERY_PARAM = "s";

	@Autowired
	private ChatroomService service;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index() {
		return new ModelAndView("index");
	}

	@RequestMapping(value = "join/{name}", method = RequestMethod.GET)
	public ModelAndView chatroom(
			@PathVariable("name") String name,
			@RequestParam(value = "sort", required = false) String sort,
			@RequestParam(value = "range", required = false, defaultValue = "hour") String range) {
		ModelAndView mav = new ModelAndView("chatroom");
		try {
			Long chatroomId = service.getChatroomId(name);

			if (SUMMARY_QUERY_PARAM.equals(sort)) { // Event summary.
				mav.addObject("summary", "active");
				mav.addObject(range.toLowerCase(), "active");
				mav.addObject("events",
						service.getChatroomSummary(chatroomId, range));
			} else { // Defaulting sort to history view
				mav.addObject("history", "active");
				mav.addObject("events", service.getChatroomEvents(chatroomId));
			}

			List<String> users = service.getChatroomUsers(chatroomId);
			mav.addObject("users", users);
			mav.addObject("userCount", users.size());
		} catch (DatabaseException e) {
			throw new RuntimeException("Could not get data.", e);
		}
		return mav;
	}
}
