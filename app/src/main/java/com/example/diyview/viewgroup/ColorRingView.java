package com.example.diyview.viewgroup;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.diyview.R;

/**
 * @data on 5/11/21 3:28 PM
 * @auther
 * @describe 圆环
 */
public class ColorRingView extends View {

    private Paint mPaint;
    private int cirlceColor;//圆环颜色
    private int stokeWidth;//圆环宽度

    public ColorRingView(Context context) {
        this(context, null);
    }

    public ColorRingView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ColorRingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context,attrs,defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        //获取自定义属性
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.ColorRing);
        cirlceColor = ta.getColor(R.styleable.ColorRing_ring_color, Color.RED);
        stokeWidth = ta.getInt(R.styleable.ColorRing_ring_width, 10);
        ta.recycle();
        //初始化画笔
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setColor(cirlceColor);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(stokeWidth);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float radius = (Math.min(getMeasuredWidth(), getMeasuredHeight()) - mPaint.getStrokeWidth()) / 2;
//        Log.e("TTT", "getMeasuredWidth() is " + getMeasuredWidth() + ",getMeasuredHeight() is " + getMeasuredHeight());
        canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, radius, mPaint);
    }
}
