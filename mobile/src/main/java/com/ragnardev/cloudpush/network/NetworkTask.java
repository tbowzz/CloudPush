package com.ragnardev.cloudpush.network;

import android.content.Context;
import android.os.AsyncTask;

/**
 * Created by tyler on 7/28/17.
 */

public class NetworkTask extends AsyncTask {

    private Object _objectToSend;
    private Context _context;

    NetworkTask(Object objectToSend, Context context) {
        this._objectToSend = objectToSend;
        this._context = context;
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
    }
}
