package com.hileco.blegex.data.sources.clipboard;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;

/**
 * An abstraction on the java libraries for managing the clipboard.
 * Makes it easier to be notified on clipboard content changes.
 */
public abstract class ClipboardChangeListener implements ClipboardOwner, Runnable {

    private static final Integer CLIPBOARD_PAUSE = 250;
    private static final Logger LOG = LoggerFactory.getLogger(ClipboardChangeListener.class);

    private Clipboard clipboard;

    protected ClipboardChangeListener() {
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    }

    public void run() {
        Transferable transferable = clipboard.getContents(this);
        regainOwnership(transferable);
    }

    public void lostOwnership(Clipboard clipboard, Transferable transferable) {
        try {
            Thread.sleep(CLIPBOARD_PAUSE);
            try {
                Transferable contents = clipboard.getContents(this);
                regainOwnership(contents);
            } catch (Exception e) {
                LOG.error("Erred while processing contents of clipboard.", e);
            }
        } catch (InterruptedException e) {
            LOG.warn("Interrupted while waiting for clipboard to fully load.", e);
        }
    }

    abstract void handleChange(Transferable transferable);

    void regainOwnership(Transferable transferable) {
        clipboard.setContents(transferable, this);
        handleChange(transferable);
    }

}