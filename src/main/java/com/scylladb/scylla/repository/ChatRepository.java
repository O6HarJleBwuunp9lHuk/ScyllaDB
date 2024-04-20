package com.scylladb.scylla.repository;

import com.scylladb.scylla.model.Chat;
import org.springframework.data.cassandra.repository.CassandraRepository;
import java.util.UUID;

public interface ChatRepository extends CassandraRepository<Chat, UUID> {
}
