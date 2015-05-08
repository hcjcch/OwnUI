package com.hcjcch.ownui.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by hcjcch on 2015/3/27.
 */

public class DiffusionCircleView extends View implements Runnable {
    private Paint paint;
    private int radius;
    private int alpha = 51;
    private int laterestRadius;

    public DiffusionCircleView(Context context) {
        super(context);
    }

    public DiffusionCircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public DiffusionCircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initPaint() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(10);
        paint.setAlpha(alpha);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        laterestRadius = getWidth();
        getCircleAlpha();
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, radius, paint);
    }

    @Override
    public void run() {
        while (true) {
            try {
            /*
             * 如果半径小于200则自加否则大于200后重置半径值以实现往复
             */
                if (radius <= (getWidth() - 10) / 2) {
                    radius += 5;
                    // 刷新View
                    postInvalidate();
                } else {
                    radius = 0;
                }

                // 每执行一次暂停40毫秒
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void getCircleAlpha() {
        alpha = (int) ((0.2 + radius * 1.0 / laterestRadius) * 255);
        paint.setAlpha(alpha);
    }
}