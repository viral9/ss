package com.example.student;

import android.app.Activity;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class SimpleGestureFilter extends GestureDetector.SimpleOnGestureListener {
    public final static int SWIPE_UP = 0;
    public final static int SWIPE_DOWN = 1;
    public final static int SWIPE_LEFT = 2;
    public final static int SWIPE_RIGHT = 3;

    public final static int MODE_TRANCEFRENT = 0;
    public final static int MODE_SOLID = 1;
    public final static int MODE_DYNAMIC = 2;

    private final static int ACTION_FAKE = -13;
    private int swipe_Min_Distance = 50;
    private int swipe_Max_Distance = 250;
    private int swipe_Min_Velocity = 100;
    private int MODE = MODE_DYNAMIC;
    private boolean running = true;
    private boolean tapIndicator = false;

    private Activity context;
    private GestureDetector detector;
    //SimpleGestureFilter simpleGestureFilter;
    //private GestureDetector.SimpleOnGestureListener listener;
    private SimpleGestureListener listener;
    public SimpleGestureFilter(Activity context, SimpleGestureListener sgl)
    {
        this.context = context;
        this.detector = new GestureDetector(context,this);
        this.listener = sgl;

    }
    public void onTouchEvent(MotionEvent event)
    {
        if(!this.running)
        {
            return;
        }
        boolean result = this.detector.onTouchEvent(event);
        if(this.MODE == MODE_SOLID)
        {
            event.setAction(MotionEvent.ACTION_CANCEL);
        }
        else if(this.MODE == MODE_DYNAMIC)
        {
            if(event.getAction() == ACTION_FAKE)
            {
                event.setAction(MotionEvent.ACTION_UP);
            }
            else if(result)
            {
                event.setAction(MotionEvent.ACTION_CANCEL);
            }
            else if(this.tapIndicator)
            {
                event.setAction(MotionEvent.ACTION_DOWN);
                this.tapIndicator = false;
            }
        }
    }

    public int getSwipe_Min_Distance() {
        return swipe_Min_Distance;
    }

    public void setSwipe_Min_Distance(int swipe_Min_Distance) {
        this.swipe_Min_Distance = swipe_Min_Distance;
    }

    public int getSwipe_Max_Distance() {
        return swipe_Max_Distance;
    }

    public void setSwipe_Max_Distance(int swipe_Max_Distance) {
        this.swipe_Max_Distance = swipe_Max_Distance;
    }

    public int getSwipe_Min_Velocity() {
        return swipe_Min_Velocity;
    }

    public void setSwipe_Min_Velocity(int swipe_Min_Velocity) {
        this.swipe_Min_Velocity = swipe_Min_Velocity;
    }

    public int getMODE() {
        return MODE;
    }

    public void setMODE(int MODE) {
        this.MODE = MODE;
    }

    public void setEnabled(boolean status)
    {
        this.running = status;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {


        final float xDistance = Math.abs(e1.getX()- e2.getX());
        final float yDistance = Math.abs(e1.getY() - e2.getY());

        if(xDistance > this.swipe_Max_Distance || yDistance > this.swipe_Max_Distance)
        {
            return false;
        }
        velocityX = Math.abs(velocityX);
        velocityY = Math.abs(velocityY);
        boolean result = false;
        if(velocityX > this.swipe_Min_Velocity && xDistance > this.swipe_Min_Distance)
        {
            if(e1.getX() > e2.getX())
            {
                this.listener.onSwipe(SWIPE_LEFT);
            }
            else
            {
                this.listener.onSwipe(SWIPE_RIGHT);
            }
            result = true;
        }
        else if(velocityY > this.swipe_Min_Velocity && yDistance > this.swipe_Min_Distance)
        {
            if(e1.getY() > e2.getY())
            {
                this.listener.onSwipe(SWIPE_UP);
            }
            else
            {
                this.listener.onSwipe(SWIPE_DOWN);
            }
            result = true;
        }
        return result;

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        this.tapIndicator = true;
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        this.listener.onDoubleTap();
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        if(this.MODE == MODE_DYNAMIC)
        {
            e.setAction(ACTION_FAKE);
            this.context.dispatchTouchEvent(e);
        }
        return false;
    }

    static interface SimpleGestureListener
    {
        void onSwipe(int direction);
        void onDoubleTap();

    }
}
