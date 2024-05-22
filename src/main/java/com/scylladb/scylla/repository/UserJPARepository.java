package com.scylladb.scylla.repository;

import com.scylladb.scylla.model.User;
import com.scylladb.scylla.model.UserJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserJPARepository extends JpaRepository<UserJPA, UUID> {
}