package com.wangm.springaidemo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangmeng
 * @since 2025/6/23
 */
@Configuration
public class AiConfig {

    @Bean
    public ChatClient chatClient(ChatClient.Builder builder) {
        return builder
                .defaultAdvisors()
                .defaultSystem("你是一名语文老师")
                .build();
    }


}
