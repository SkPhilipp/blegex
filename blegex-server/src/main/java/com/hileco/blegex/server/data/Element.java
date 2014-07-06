package com.hileco.blegex.server.data;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.hileco.blegex.server.data.block.*;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ImageElement.class, name = "image"),
        @JsonSubTypes.Type(value = MarkdownElement.class, name = "markdown"),
        @JsonSubTypes.Type(value = RegexElement.class, name = "regex"),
        @JsonSubTypes.Type(value = RemoteImageElement.class, name = "remote-image")})
public abstract class Element<T extends Element<T>> {

    public String asMarkdown() {
        return null;
    }

    public boolean isVisible() {
        return true;
    }

    public boolean isEditable() {
        return false;
    }

}
