package com.hileco.blegex.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

@Component
public class ClipboardSource extends ClipboardChangeListener {

    private static final Logger LOG = LoggerFactory.getLogger(ClipboardSource.class);

    @Override
    void handleChange(Transferable transferable) {
        try {
            Object transferData = transferable.getTransferData(DataFlavor.stringFlavor);
            if (transferData instanceof String) {
                LOG.info("{}", transferData);
            }
        } catch (UnsupportedFlavorException | IOException e) {
            LOG.warn("Unable to process a clipboard change", e);
        }
    }

}
