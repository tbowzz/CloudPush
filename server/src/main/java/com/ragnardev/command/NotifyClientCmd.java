package com.ragnardev.command;

import com.ragnardev.command.servercmds.NotifyClientCmdData;
import com.ragnardev.dto.Results;
import com.ragnardev.services.ServerFacade;

/**
 * Created by tyler on 7/31/17.
 */

public class NotifyClientCmd extends NotifyClientCmdData implements IServerCommand {
    @Override
    public Results execute() {
        return new ServerFacade().notifyClient(super.getClientName(), super.getMessage(), super.getFile());
    }
}