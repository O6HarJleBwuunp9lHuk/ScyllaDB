package com.scylladb.scylla.model;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import java.util.UUID;

@Table("user_chat_links")
public class UserChatLink {

    @PrimaryKey
    private UUID userId;

    private UUID chatId;

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public void setChatId(UUID chatId) {
        this.chatId = chatId;
    }

    public UUID getUserId() {
        return userId;
    }

    public UUID getChatId() {
        return chatId;
    }
}
