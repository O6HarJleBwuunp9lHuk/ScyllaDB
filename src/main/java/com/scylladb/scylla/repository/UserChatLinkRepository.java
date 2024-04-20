package com.scylladb.scylla.repository;

import com.scylladb.scylla.model.UserChatLink;
import org.springframework.data.cassandra.repository.CassandraRepository;
import java.util.UUID;

public interface UserChatLinkRepository extends CassandraRepository<UserChatLink, UUID> {
}
