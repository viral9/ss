package com.example.student;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.student.ui.secound.SecoundFragment;

public class secound extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secound_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, SecoundFragment.newInstance())
                    .commitNow();
        }
    }
}
