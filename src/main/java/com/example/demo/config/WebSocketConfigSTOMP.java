package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
// 啟用 Websocket 的消息代理
@EnableWebSocketMessageBroker
public class WebSocketConfigSTOMP implements WebSocketMessageBrokerConfigurer {
// 註冊 STOMP 協議的節點（Endpoint），並映射為指定的 URL
// 我們使用 STOMP，所以不需要再實現 WebSocketHandler。
// 實現 WebSocketHandler 的目的是接收和處理消息，STOMP 已經為我們做了這些。
	@Override
	public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
// 註冊 STOMP 協議的節點，並指定使用 SockJS 協議
		stompEndpointRegistry.addEndpoint("/websocket").setAllowedOrigins("*")
		.addInterceptors(new HandshakeInterceptor()).withSockJS();
	}

// 配置使用消息代理
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
// 統一配置消息代理，消息代理即訂閱點，客戶端通過訂閱消息代理點接受消息
		registry.enableSimpleBroker("/all");
	}
}