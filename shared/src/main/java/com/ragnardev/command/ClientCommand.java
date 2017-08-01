package com.ragnardev.command;

import java.io.Serializable;

/**
 * Created by tyler on 7/31/17.
 */

public class ClientCommand extends Command implements Serializable
{
    private int commandNumber;

    public int getCommandNumber() {
        return commandNumber;
    }

    public void setCommandNumber(int commandNumber) {
        this.commandNumber = commandNumber;
    }
}
