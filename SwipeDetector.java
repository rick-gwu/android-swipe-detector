package com.anjosoft.swipedetector;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class SwipeDetector implements View.OnTouchListener {

    private final GestureDetector gestureDetector;

    public SwipeDetector(Context context) {
        gestureDetector = new GestureDetector(context, new GestureListener());
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return gestureDetector.onTouchEvent(motionEvent);
    }

    public void onSwipeToRight() {
    }

    public void onSwipeToLeft() {
    }

    public void onSwipeToTop() {
    }

    public void onSwipeToBottom() {
    }

    private final class GestureListener extends GestureDetector.SimpleOnGestureListener {
        private static final int velocity = 100;
        private static final int swipeThreshold = 100;

        @Override
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override
        public boolean onFling(MotionEvent motionEvent1, MotionEvent motionEvent2, float speedX, float speedY) {
            float y = motionEvent2.getY() - motionEvent1.getY();
            float x = motionEvent2.getX() - motionEvent1.getX();

            if (Math.abs(x) > Math.abs(y)) {
                if (Math.abs(x) > swipeThreshold && Math.abs(speedX) > velocity) {
                    if (x > 0) {
                        onSwipeToRight();
                    } else {
                        onSwipeToLeft();
                    }
                }
            } else if (Math.abs(y) > swipeThreshold && Math.abs(speedY) > velocity) {
                if (y > 0) {
                    onSwipeToBottom();
                } else {
                    onSwipeToTop();
                }
            }
            return true;
        }
    }
}
