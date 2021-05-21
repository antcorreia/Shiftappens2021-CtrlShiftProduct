package com.example.shiftappens2021;

import android.view.MotionEvent;

import com.journeyapps.barcodescanner.CaptureActivity;

public class Capture extends CaptureActivity {
    float x1, x2, y1, y2;

    public boolean onTouchEvent (MotionEvent touchevent){
        switch (touchevent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = touchevent.getX();
                y1 = touchevent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchevent.getX();
                y2 = touchevent.getY();
                if (x1 > x2){
                    finish();
                }
                break;
        }
        return false;
    }
}