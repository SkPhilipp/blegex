package com.hileco.blegex.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
public class Block {

    public enum Type {
        MDX, MD, IMAGE
    }

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    @GeneratedValue
    private UUID id;

    @Column(name = "draft", nullable = false)
    @NotNull
    private UUID draft;

    @Column(name = "type", nullable = false)
    @NotNull
    private Type type;

    @Column(name = "data", nullable = true)
    private String data;

    public UUID getDraft() {
        return draft;
    }

    public void setDraft(UUID draft) {
        this.draft = draft;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
