package com.scylladb.scylla.repository;

import com.scylladb.scylla.model.User;
import org.springframework.data.cassandra.repository.CassandraRepository;
import java.util.UUID;

public interface UserRepository extends CassandraRepository<User, UUID> {
}
