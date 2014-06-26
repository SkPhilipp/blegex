package com.hileco.blegex.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.UUID;

// TODO: Give drafts a "created" date property, set when created
// TODO: Give drafts a "updated" date property, set when updated
@Entity
public class Draft {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    @GeneratedValue
    private UUID id;

    @Column(name = "title", nullable = false)
    @NotNull
    private String title;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
