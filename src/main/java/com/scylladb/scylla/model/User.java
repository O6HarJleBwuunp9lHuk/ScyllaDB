package com.scylladb.scylla.model;

import  org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import java.util.UUID;

@Table("users")
public class User {

    @PrimaryKey
    private UUID id;
    private String name;
    private String email;

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) { this.email = email; }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public UUID getId() {
        return id;
    }
}
