package com.ragnardev.command.servercmds;

import com.ragnardev.command.Command;

import java.io.File;
import java.io.Serializable;
import java.util.UUID;

/**
 * Created by tyler on 7/31/17.
 */

public class NotifyClientCmdData extends Command implements Serializable {
    private String clientName;
    private File file;
    private String message;

    public NotifyClientCmdData() {
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
