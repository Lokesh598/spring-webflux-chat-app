package com.lokesh.chatappservice.repository;

import com.lokesh.chatappservice.model.Channel;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelRepository extends ReactiveMongoRepository<Channel, String> {
}
