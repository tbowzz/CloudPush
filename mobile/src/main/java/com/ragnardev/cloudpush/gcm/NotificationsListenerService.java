package com.ragnardev.cloudpush.gcm;

import android.os.Bundle;

import com.google.android.gms.gcm.GcmListenerService;

/**
 * Created by tyler on 7/31/17.
 */

public class NotificationsListenerService extends GcmListenerService {

    @Override
    public void onMessageReceived(String s, Bundle bundle) {
        super.onMessageReceived(s, bundle);

        //TODO: Override to decide what to do with a message
    }
}
