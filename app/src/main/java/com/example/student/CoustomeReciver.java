package com.example.student;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CoustomeReciver extends BroadcastReceiver {

    private static final String ACTION_CUSTOME_BRODCAST = "com.example.android.CUSTOME_BRODCAST";

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //throw new UnsupportedOperationException("Not yet implemented");
        String intentAction = intent.getAction();
        String tostmsg = " ";
        switch (intentAction)
        {
            case Intent.ACTION_POWER_CONNECTED:
                tostmsg = "power_connected";
                break;
            case Intent.ACTION_POWER_DISCONNECTED:
                tostmsg = "power_disconnected";
                break;
            case ACTION_CUSTOME_BRODCAST:
                tostmsg = "custom_bro";
                break;
            case "android.net.conn.CONNECTIVITY_CHANGE":
                tostmsg = "connection_change";
                break;


        }
        Toast.makeText(context, tostmsg, Toast.LENGTH_SHORT).show();
    }
}
