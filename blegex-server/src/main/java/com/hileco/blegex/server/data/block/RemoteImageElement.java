package com.hileco.blegex.server.data.block;

import com.hileco.blegex.server.data.Element;

public class RemoteImageElement extends Element<RemoteImageElement> {

    private String provider;
    private String url;

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
