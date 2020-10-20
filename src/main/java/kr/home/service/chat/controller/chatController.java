package kr.home.service.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class chatController {

	@RequestMapping("/socket/view")
	public String chatView() {
		return "socketchat/websocketChat";
	}
}
