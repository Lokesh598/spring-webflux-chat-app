package com.lokesh.chatappservice.controller;

import com.lokesh.chatappservice.model.Channel;
import com.lokesh.chatappservice.model.Message;
import com.lokesh.chatappservice.repository.ChannelRepository;
import com.lokesh.chatappservice.repository.MessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping(value = "/api/message")
public class MessageController {
    @Autowired
    ChannelRepository chatChannelRepo;
    @Autowired
    MessageRepository chatMessageRepo;
    @PostMapping("/chats")
    @ResponseStatus(HttpStatus.CREATED)
    public void postChat(@Validated @RequestBody Message chatMessage){
        chatMessageRepo.insert(chatMessage).subscribe();
    }
    @PostMapping("/channels")
    public Mono<Channel> createChannel(@Validated @RequestBody Channel channel){
        return chatChannelRepo.save(channel);
    }
    @GetMapping(value = "/chats/stream/{channelId}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Message> streamMessages(@RequestParam("channelId") String channelId){
        log.info("geting messages");
        return chatMessageRepo.findWithTailableCursorByChannelId(channelId);
    }
}
