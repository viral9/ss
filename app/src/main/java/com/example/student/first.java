package com.example.student;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.student.ui.first.FirstFragment;

public class first extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, FirstFragment.newInstance())
                    .commitNow();
        }
    }
}
