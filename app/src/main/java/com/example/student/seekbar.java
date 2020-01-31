package com.example.student;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class seekbar extends AppCompatActivity implements BottomSeek.Bottomtext {
    Button btnopenseek;
    TextView tvseek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekbar);
        btnopenseek = findViewById(R.id.btnopenseek);
        tvseek = findViewById(R.id.tvseek);
        btnopenseek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSeek bottomSeek = new BottomSeek();
                bottomSeek.show(getSupportFragmentManager(),"Bottmseekopen");

            }
        });
    }

    @Override
    public void OnClickeseekbtn(String text) {
        tvseek.setText(text);
    }
}
