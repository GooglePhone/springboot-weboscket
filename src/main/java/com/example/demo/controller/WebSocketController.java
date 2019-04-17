package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import com.example.demo.message.Message;
import com.example.demo.message.Response;

@Controller
public class WebSocketController {
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;
    // 當客戶端向服務器發送請求時，通過 `@MessageMapping` 映射 /broadcast 這個地址
    @MessageMapping("/broadcast")
    // 當服務器有消息時，會對訂閱了 @SendTo 中的路徑的客戶端發送消息
    @SendTo("/all")
    public Response say(Message message) {
    	Response r = Response.getInstance();
    	int number = StringUtils.isEmpty(message.getNumber()) ? 0 : Integer.parseInt(message.getNumber());
    	switch(number) { 
        case 1: 
        	r.setNumber1(r.getNumber1()+1);
            break; 
        case 2: 
        	r.setNumber2(r.getNumber2()+1); 
            break; 
        case 3: 
        	r.setNumber3(r.getNumber3()+1); 
    } 
    	 return r;
    }

}
