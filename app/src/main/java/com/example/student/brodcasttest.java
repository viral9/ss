package com.example.student;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class brodcasttest extends AppCompatActivity {

    private static final String ACTION_CUSTOME_BRODCAST = "com.example.android.CUSTOME_BRODCAST";

    CoustomeReciver coustomeReciver = new CoustomeReciver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brodcasttest);
        LocalBroadcastManager.getInstance(this).registerReceiver(coustomeReciver,new IntentFilter(ACTION_CUSTOME_BRODCAST));
    }

    public void SendOnClickeLisner(View view) {
        Intent custbro = new Intent(ACTION_CUSTOME_BRODCAST);
        LocalBroadcastManager.getInstance(this).sendBroadcast(custbro);
    }
}
