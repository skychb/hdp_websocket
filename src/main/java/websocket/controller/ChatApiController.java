package websocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import websocket.model.Message;

@Controller
@RestController
@RequestMapping("/api/chat/info")
public class ChatApiController {
	public Message id;
	public Message message;
}
