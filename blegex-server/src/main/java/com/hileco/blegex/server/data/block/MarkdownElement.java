package com.hileco.blegex.server.data.block;

import com.hileco.blegex.server.data.Element;

public class MarkdownElement extends Element<MarkdownElement> {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
