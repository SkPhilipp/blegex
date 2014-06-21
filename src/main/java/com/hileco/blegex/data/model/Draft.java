package com.hileco.blegex.data.model;

import java.util.Date;
import java.util.UUID;

public class Draft {

    private UUID draft;
    private String title;
    private Date created;
    private Date updated;

    public UUID getDraft() {
        return draft;
    }

    public void setDraft(UUID draft) {
        this.draft = draft;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

}
