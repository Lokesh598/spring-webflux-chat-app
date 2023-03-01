package com.lokesh.chatappservice.repository;

import com.lokesh.chatappservice.model.Message;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface MessageRepository extends ReactiveMongoRepository<Message, String> {
    @Tailable
    public Flux<Message> findWithTailableCursorByChannelId(String channelId);
}
