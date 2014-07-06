package com.hileco.blegex.server.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

// TODO: Assign users an "active" draft
@Document(indexName = "user", type = "user", shards = 1, replicas = 0, refreshInterval = "-1")
public class User {

    @Id
    private String id;

    private String username;

    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}