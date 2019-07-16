package com.fortiate.simulatorwskafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
public class TickService {

    @Autowired
    private SimpMessagingTemplate template;

    //@Scheduled(fixedDelay = 1000)
    public void tick() {
        String currentTime = DateTimeFormatter.ISO_DATE_TIME.format(LocalDateTime.now());
        log.info("Message send to client: {}", currentTime);
        template.convertAndSend("/topic/tick", currentTime);
    }


    @KafkaListener(topics = "topic-generated-data", groupId = "simulator-ws-kafka") 
    public void transactions(String message) {
     
    	log.info("Message from kafka - ", message);
        template.convertAndSend("/topic/generated-data", message);
    }
}