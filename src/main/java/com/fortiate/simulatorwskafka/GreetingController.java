package com.fortiate.simulatorwskafka;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.util.HtmlUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@CrossOrigin
public class GreetingController {


    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

    @SendTo("/topic/tick")
    @MessageMapping("/from-client")
    public String fromClient(String content) throws Exception {
        log.info("Message from client: {}", content);
        Thread.sleep(1000);
        return "Hello, " + content;
    }
    
   
}