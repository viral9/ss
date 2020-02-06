package com.example.student;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.github.pwittchen.swipe.library.rx2.SimpleSwipeListener;
import com.github.pwittchen.swipe.library.rx2.Swipe;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class up_seek extends AppCompatActivity implements SimpleGestureFilter.SimpleGestureListener {

    private SimpleGestureFilter detector;

    BottomSheetBehavior bottomSheetBehavior;
    TextView tvstatsus;
    Button btnexpand,btncollapse;

    //Swipe swipe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_seek);
        View bottomsheet = findViewById(R.id.bottom_sheet);
        detector = new SimpleGestureFilter(this,this);

        /*swipe = new Swipe();
        swipe.setListener(new SimpleSwipeListener() {
            @Override
            public void onSwipingLeft(MotionEvent event) {
                //Toast.makeText(up_seek.this, "swipe left", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSwipingRight(MotionEvent event) {
                //Toast.makeText(up_seek.this, "swipe right", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSwipingUp(MotionEvent event) {
                //Toast.makeText(up_seek.this, "swipe up", Toast.LENGTH_SHORT).show();
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

            }

            @Override
            public void onSwipingDown(MotionEvent event) {
                //Toast.makeText(up_seek.this, "swipe down", Toast.LENGTH_SHORT).show();
            }
        });*/



        bottomSheetBehavior = BottomSheetBehavior.from(bottomsheet);
        tvstatsus = findViewById(R.id.tvstatus);
        btnexpand = findViewById(R.id.btn_expand);
        btncollapse = findViewById(R.id.btn_collapse);

        int a ;
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);



        btnexpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bottomSheetBehavior.getState()==4)
                {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                    btnexpand.setText("collapse");
                }
                else
                {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                    btnexpand.setText("expand");
                }


            }
        });
        btncollapse.setVisibility(View.GONE);

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

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        this.detector.onTouchEvent(ev);
        //swipe.dispatchTouchEvent(ev);
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public void onSwipe(int direction) {
        String str = "";
        switch (direction)
        {
            case SimpleGestureFilter.SWIPE_RIGHT:
                str = "swipe_right";
                break;
            case SimpleGestureFilter.SWIPE_LEFT:
                str = "swipe_left";
                break;
            case SimpleGestureFilter.SWIPE_UP:
                str = "swipe_up";
                break;
            case SimpleGestureFilter.SWIPE_DOWN:
                str = "swipe_down";
                break;
        }
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onDoubleTap() {
        Toast.makeText(this, "Double tap", Toast.LENGTH_SHORT).show();

    }
}
