package com.ragnardev.network;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.ragnardev.command.Command;
import com.ragnardev.command.IServerCommand;
import com.ragnardev.command.NotifyClientCmd;
import com.ragnardev.dto.Results;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by tyler on 7/31/17.
 */

public class Handler implements HttpHandler {

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String query = httpExchange.getRequestURI().getPath();

        //get the request body
        String request = readString(httpExchange.getRequestBody());

        //get the authToken
        Headers reqHeaders = httpExchange.getRequestHeaders();
        if (reqHeaders.containsKey("Authorization")) {
            //get the authToken
            String authToken = reqHeaders.getFirst("Authorization");
//            User user = ServerModel.getInstance().validateUser(authToken);
//            if(user != null) ServerModel.getInstance().setTempUser(user);
        }

        //handle the command
        Results results = processCommand(request);

        //serialize the results
//        String response = Serializer.serializeResults(results);

        //send the result back to the client
//        httpExchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, response.length());

//        writeString(httpExchange, response);
    }

    public Results processCommand(String request) {

        ObjectMapper mapper = new ObjectMapper();
        Results results = null;
        Gson gson = new Gson();
        try {
            String type = gson.fromJson(request, Command.class).getType();

            switch (type) {
                case Command.NOTIFY_CLIENT:
                    NotifyClientCmd notifyClientCmd = mapper.readValue(request, NotifyClientCmd.class);
                    notifyClientCmd.execute();
                    break;
                default:
                    System.out.println("Unknown command type");
                    break;
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        return results;
    }

    private String readString(InputStream is) {

        Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    private void writeString(HttpExchange exchange, String response) throws IOException {

        BufferedOutputStream out = new BufferedOutputStream(exchange.getResponseBody());
        ByteArrayInputStream bis = new ByteArrayInputStream(response.getBytes());

        byte [] buffer = new byte [4096];
        int count;
        while ((count = bis.read(buffer)) != -1)
        {
            out.write(buffer, 0, count);
        }
        out.flush();
        out.close();
    }
}
