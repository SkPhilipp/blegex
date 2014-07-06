package com.hileco.blegex.server.model;

import com.hileco.blegex.server.data.Element;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "element", type = "element", shards = 1, replicas = 0, refreshInterval = "-1")
public class ContentElement {

    @Id
    private String id;

    private String draft;

    private Element<?> element;

    public String getDraft() {
        return draft;
    }

    public void setDraft(String draft) {
        this.draft = draft;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Element<?> getElement() {
        return element;
    }

    public void setElement(Element<?> element) {
        this.element = element;
    }

}
