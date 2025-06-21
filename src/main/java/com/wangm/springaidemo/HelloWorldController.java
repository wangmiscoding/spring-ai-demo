package com.wangm.springaidemo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @author wangmeng
 * @since 2025/6/21
 */
@RestController
public class HelloWorldController {

    private ChatClient chatClient;


    public HelloWorldController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }


    @GetMapping("/hello")
    public String hello(@RequestParam(value = "input", defaultValue = "讲一个笑话") String input) {

        return chatClient.prompt(input).call().content();

    }


    @GetMapping(value = "/hello/stream", produces = "text/html;charset=UTF-8")
    public Flux<String> helloStream(@RequestParam(value = "input", defaultValue = "讲一个笑话") String input) {
        return chatClient.prompt(input).stream().content();

    }
}
