package com.scylladb.scylla.repository;

import com.scylladb.scylla.model.Messages;
import org.springframework.data.cassandra.repository.CassandraRepository;
import java.util.UUID;

public interface MessagesRepository extends CassandraRepository<Messages, UUID> {
}
