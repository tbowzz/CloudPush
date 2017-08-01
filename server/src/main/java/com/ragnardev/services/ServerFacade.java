package com.ragnardev.services;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Notification;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;
import com.ragnardev.dto.Results;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by tyler on 7/31/17.
 */

public class ServerFacade {

    private static final String device = "eaKsWMp0Q6w:APA91bGIu6VWAUPcs3UE0ueAN7IhqmujRLl4Pc6p5VGLPxtH-xEYeQ_FRpGDvdwQaqjW15DYR3crDSAzijik-xaK23NWV1t8TGAIQbUimlnYVzbYfCg0pBXzwuMnSCifPyPkNLVtnXBO";

    public Results notifyClient(String clientName, String message, File file) {


        Sender sender = new Sender("AIzaSyDr5PUXQc-RYLEwGo453nqe6mzED6LRsjA");
        Message msg = new Message.Builder()
                .addData("message", "this is the message")
                .build();

        Result result = null;
        try {
            result = sender.send(msg, device, 1);
            System.out.println("Message Result: " + result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Use this code to send notification message to multiple devices
        ArrayList<String> devicesList = new ArrayList<String>();
        //add your devices RegisterationID, one for each device
        devicesList.add(device);
//        devicesList.add("APA91bEVcqKmPnESzgnGpEstHHymcpOwv52THv6u6u2Rl-PaMI4mU3Wkb9bZtuHp4NLs4snBl7aXXVkNn-IPEInGO2jEBnBI_oKEdrEoTo9BpY0i6a0QHeq8LDZd_XRzGRSv_R0rjzzZ1b6jXY60QqAI4P3PL79hMg");

        //Use this code for multicast messages
        MulticastResult multicastResult = null;
        try {
            multicastResult = sender.send(msg, devicesList, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Message Result: "+multicastResult.toString());//Print multicast message result on console




        return null;
    }
}
