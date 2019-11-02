package com.vishal.ardemo;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class PointerDrawable extends Drawable {

    private final Paint paint = new Paint();
    private boolean enabled;

    @Override
    public void draw(@NonNull Canvas canvas) {
        // we can also use canvas.getWidth(); or canvas.getHeight();
        float cx = getBounds().width()/2;
        float cy = getBounds().height()/2;
        if (isEnabled()){
            paint.setColor(Color.GREEN);
            canvas.drawCircle(cx, cy, 10.0f, paint);
        }else {
            paint.setColor(Color.GRAY);
            canvas.drawText("X", cx, cy, paint);
        }
    }

    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return PixelFormat.OPAQUE;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}