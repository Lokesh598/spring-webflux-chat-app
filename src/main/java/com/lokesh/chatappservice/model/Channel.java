package com.lokesh.chatappservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Getter
@Setter
@Document(collection = "channels")
@NoArgsConstructor
@AllArgsConstructor
public class Channel {
    @Id
    private String channelId;
    @Field("first_user")
    private String firstUser;
    @Field("second_user")
    private String secondUser;
}
