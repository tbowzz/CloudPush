package com.ragnardev.network;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ragnardev.command.Command;
import com.ragnardev.command.servercmds.NotifyClientCmdData;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.UUID;

/**
 * Created by tyler on 7/31/17.
 */

public class Server {

    private static final int MAX_WAITING_CONNECTIONS = 12;

    private void run(String portNumber) {

        System.out.println("Initializing HTTP Server");

        HttpServer server;
        try
        {
            server = HttpServer.create(new InetSocketAddress(Integer.parseInt(portNumber)), MAX_WAITING_CONNECTIONS);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return;
        }

        server.setExecutor(null);

        System.out.println("Creating contexts");
        server.createContext("/", new Handler());

        System.out.println("Starting server");
        server.start();
        System.out.println("Server started");

//        ServerFacade.loadPersistencePlugin(persistencePluginName);

//        ServerFacade serverFacade = new ServerFacade();


    }

    public static void main(String[] args) {

        if(args.length < 1) {
            System.out.println("USAGE: <port>");
            return;
        }

        String portNumber = args[0];
//        new Server().run(portNumber);

        Handler handler = new Handler();
        NotifyClientCmdData data = new NotifyClientCmdData();
        data.setType(Command.NOTIFY_CLIENT);
        data.setClientName("218234789-908-098");
        data.setMessage("This is a test command");
//        data.setFile();

        String jsonInString = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            jsonInString = mapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        handler.processCommand(jsonInString);

    }
}
