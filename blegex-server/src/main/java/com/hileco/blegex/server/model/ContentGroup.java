package com.hileco.blegex.server.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

// TODO: Give drafts a "created" date property, set when created
// TODO: Give drafts a "updated" date property, set when updated
@Document(indexName = "group", type = "group", shards = 1, replicas = 0, refreshInterval = "-1")
public class ContentGroup {

    @Id
    private String id;

    private String title;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
