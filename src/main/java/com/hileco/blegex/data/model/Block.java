package com.hileco.blegex.data.model;

import java.util.UUID;

public class Block {

    private UUID draft;
    private UUID id;
    private BlockType type;
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

    public BlockType getType() {
        return type;
    }

    public void setType(BlockType type) {
        this.type = type;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
