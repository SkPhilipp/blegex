package com.hileco.blegex.server.data.sources.clipboard;

import com.hileco.blegex.server.data.sources.ActiveSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class ClipboardSource extends ClipboardChangeListener implements ActiveSource {

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
