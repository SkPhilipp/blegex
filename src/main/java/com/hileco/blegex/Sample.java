package com.hileco.blegex;

import com.hileco.blegex.sources.clipboard.ClipboardSource;

public class Sample {

    public static void main(String[] args) {
        ClipboardSource source = new ClipboardSource();
        new Thread(source).start();
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}