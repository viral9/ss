package com.example.student;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class up_seek extends AppCompatActivity {

    BottomSheetBehavior bottomSheetBehavior;
    TextView tvstatsus;
    Button btnexpand,btncollapse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_seek);
        View bottomsheet = findViewById(R.id.bottom_sheet);

        bottomSheetBehavior = BottomSheetBehavior.from(bottomsheet);
        tvstatsus = findViewById(R.id.tvstatus);
        btnexpand = findViewById(R.id.btn_expand);
        btncollapse = findViewById(R.id.btn_collapse);
        btnexpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });
        btncollapse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
        });

        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int i) {
                switch (i)
                {
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        tvstatsus.setText("collapse");
                        break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        tvstatsus.setText("dragging");
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                        tvstatsus.setText("expanded");
                        break;
                    case BottomSheetBehavior.STATE_HALF_EXPANDED:
                        tvstatsus.setText("half_expanded");
                        break;
                    case BottomSheetBehavior.STATE_HIDDEN:
                        tvstatsus.setText("hidden");
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        tvstatsus.setText("settling");
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View view, float v) {
                tvstatsus.setText("sliding");

            }
        });
    }
}
