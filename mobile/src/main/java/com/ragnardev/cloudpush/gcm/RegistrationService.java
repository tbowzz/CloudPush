package com.ragnardev.cloudpush.gcm;

import android.app.IntentService;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.gcm.GcmPubSub;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;
import com.ragnardev.cloudpush.R;

import java.io.IOException;

/**
 * Created by tyler on 7/31/17.
 */

public class RegistrationService extends IntentService {

    private static final String TAG = "RegIntentService";
    private static final String[] TOPICS = {"global"};

    public RegistrationService() {
        super(TAG);
    }

    @Override
    public void onHandleIntent(Intent intent) {
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        InstanceID instanceID = InstanceID.getInstance(this);
        String token = null;
        try {
            token = instanceID.getToken(getString(R.string.gcm_defaultSenderId),
                    GoogleCloudMessaging.INSTANCE_ID_SCOPE, null);

        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.i(TAG, "GCM Registration Token: " + token);
        Toast.makeText(getApplicationContext(), "GCM Registration Token: " + token, Toast.LENGTH_LONG).show();

//        GcmPubSub subscription = GcmPubSub.getInstance(this);
//        try {
//            subscription.subscribe(token, "/topics/my_little_topic", null);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

}
