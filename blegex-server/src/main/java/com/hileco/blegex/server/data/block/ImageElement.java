package com.hileco.blegex.server.data.block;

import com.hileco.blegex.server.data.Element;

public class ImageElement extends Element<ImageElement> {

    private String filename;
    private byte[] content;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

}
