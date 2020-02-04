package com.example.student;

import android.app.Activity;
import android.view.GestureDetector;

public class SimpleGestureFilter extends GestureDetector.SimpleOnGestureListener {
    public final static int SWIPE_UP = 0;
    public final static int SWIPE_DOWN = 1;
    public final static int SWIPE_LEFT = 2;
    public final static int SWIPE_RIGHT = 3;

    public final static int MODE_TRANCEFRENT = 0;
    public final static int MODE_SOLID = 1;
    public final static int MODE_DYNAMIC = 2;

    private final static int ACTION_FAKE = -13;
    private int swipe_Min_Distance = 100;
    private int swipe_Max_Distance = 350;
    private int swipe_Min_Velocity = 100;

    private int MODE = MODE_DYNAMIC;
    private boolean running = true;
    private boolean tapIndicator = false;

    private Activity context;
    private GestureDetector detector;
    //private
}
