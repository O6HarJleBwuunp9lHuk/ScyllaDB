package com.scylladb.scylla.service;

import com.scylladb.scylla.model.User;
import com.scylladb.scylla.model.UserJPA;
import com.scylladb.scylla.repository.UserJPARepository;
import com.scylladb.scylla.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserJPAService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserJPARepository userJPARepository;

    public void migrateUsers() {
        List<User> user = userRepository.findAll();
        List<UserJPA> users = user.stream().map(this::mapUserCqlToUser).collect(Collectors.toList());
        System.out.println("Number of users to migrate: " + users.size());
        userJPARepository.saveAll(users);
    }

    private UserJPA mapUserCqlToUser(User userCql) {
        UserJPA user = new UserJPA();
        user.setId(userCql.getId());
        user.setName(userCql.getName());
        user.setEmail(userCql.getEmail());
        return user;
    }

    public List<UserJPA> findAll() {
        return userJPARepository.findAll();
    }

    public UserJPA findById(UUID id) {
        return userJPARepository.findById(id).orElse(null);
    }

    public UserJPA save(UserJPA user) {
        return userJPARepository.save(user);
    }

    public void deleteById(UUID id) {
        userJPARepository.deleteById(id);
    }
}
