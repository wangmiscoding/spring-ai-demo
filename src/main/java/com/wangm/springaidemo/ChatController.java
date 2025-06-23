package com.wangm.springaidemo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @author wangmeng
 * @since 2025/6/23
 */
@RestController
public class ChatController {

    @Autowired
    private ChatClient chatClient;


    @GetMapping(value = "chat",produces = "text/html;charset=UTF-8")
    public Flux<String> chat(@RequestParam(value = "msg", defaultValue = "你是谁") String msg) {
        // 设置提示词
        return chatClient.prompt() // 提示词
                .user(msg) // 用户输入信息
                .stream().content();
    }

}
