package com.lokesh.chatappservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Getter
@Setter
@Document(collection = "messages")
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    @Id
    @Field("message")
    private String message;
    @Field("sender")
    private String sender;
    @Field("receiver")
    private String receiver;
    @Field("channel_id")
    private String channelId;
}
