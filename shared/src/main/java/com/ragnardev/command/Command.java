package com.ragnardev.command;

import java.io.Serializable;

/**
 * Created by tyler on 7/31/17.
 */

public class Command implements Serializable {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public static final String NOTIFY_CLIENT = "NotifyClient";
}
