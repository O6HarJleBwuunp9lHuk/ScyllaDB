package com.scylladb.scylla.generation;

import com.scylladb.scylla.model.Chat;
import com.scylladb.scylla.model.Messages;
import com.scylladb.scylla.model.User;
import com.scylladb.scylla.model.UserChatLink;
import com.scylladb.scylla.repository.ChatRepository;
import com.scylladb.scylla.repository.MessagesRepository;
import com.scylladb.scylla.repository.UserChatLinkRepository;
import com.scylladb.scylla.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

@Component
public class RandomDataGenerator {

    private static final String[] NAMES = {"John", "Mike", "Emma", "Olivia", "Liam", "Sophia"};
    private static final String[] DOMAINS = {"gmail.com", "yahoo.com", "hotmail.com"};
    private static final String[] MESSAGES = {"Hello", "Hi", "How are you?", "What's up?", "I'm good", "See you later"};

    private static final Random RANDOM = new Random();

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessagesRepository messagesRepository;

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private UserChatLinkRepository userChatLinkRepository;

    public void generateRandomUsers(int count) {
        for (int i = 0; i < count; i++) {
            User user = new User();
            user.setId(UUID.randomUUID());
            user.setName(getRandomName());
            user.setEmail(getRandomEmail());
            userRepository.save(user);
        }
    }

    public void generateRandomMessages(int count) {
        for (int i = 0; i < count; i++) {
            Messages message = new Messages();
            message.setId(UUID.randomUUID());
            message.setText(getRandomMessage());
            LocalDateTime localDateTime = LocalDateTime.now();
            message.setTimestamp(Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant()));
            messagesRepository.save(message);
        }
    }

    public void generateRandomChat(int count) {
        for (int i = 0; i < count; i++) {
            Chat chat = new Chat();
            chat.setId(UUID.randomUUID());
            chat.setUserId(getRandomUserId());
            chat.setMessageId(getRandomMessageId());
            chatRepository.save(chat);
        }
    }
    public void generateRandomUserChatLinks(int count) {
        for (int i = 0; i < count; i++) {
            UserChatLink userChatLink = new UserChatLink();
            userChatLink.setUserId(getRandomUserId());
            userChatLink.setChatId(getRandomChatId());
            userChatLinkRepository.save(userChatLink);
        }
    }

    private String getRandomName() {
        return NAMES[RANDOM.nextInt(NAMES.length)];
    }

    private UUID getRandomMessageId() {
        return messagesRepository.findAll().get(RANDOM.nextInt((int) messagesRepository.count())).getId();
    }

    private String getRandomEmail() {
        return getRandomName() + "." + RANDOM.nextInt(1000) + "@" + DOMAINS[RANDOM.nextInt(DOMAINS.length)];
    }

    private String getRandomMessage() {
        return MESSAGES[RANDOM.nextInt(MESSAGES.length)];
    }

    private UUID getRandomUserId() {
        return userRepository.findAll().get(RANDOM.nextInt((int) userRepository.count())).getId();
    }

    private UUID getRandomChatId() {
        return chatRepository.findAll().get(RANDOM.nextInt((int) chatRepository.count())).getId();
    }
}
