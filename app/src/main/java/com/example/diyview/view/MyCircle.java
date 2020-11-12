package com.example.diyview.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.diyview.R;

/**
 * @data on 2020/11/11 3:32 PM
 * @auther armStrong
 * @describe 自定义实心圆
 */
public class MyCircle extends View {
    private Context context;
    private Paint paint = new Paint();;
    //圆心
    private int center_x;
    private int center_y;
    //半径
    private int r;
    //圆的颜色
    private int circleColor;
    //背景色
    private int bgColor;
    //padding
    private int paddingLeft;
    private int paddingRight;
    private int paddingTop;
    private int paddingBottom;

    public MyCircle(Context context) {
        super(context);
    }

    public MyCircle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        //获取属性值
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.MyCircle);
        circleColor = typedArray.getColor(R.styleable.MyCircle_circle_color,Color.BLACK);
        bgColor = typedArray.getColor(R.styleable.MyCircle_background_color,Color.WHITE);
        //回收
        typedArray.recycle();
        //设置画笔
        paint.setAntiAlias(true); //抗锯齿
        paint.setStyle(Paint.Style.FILL); //实心圆
        //paint.setColor(context.getResources().getColor(R.color.white)); //从绝对路径取颜色才可以，直接使用R.color.white会颜色错乱，得不到指定的颜色
        paint.setColor(circleColor);
        //设置padding
        paddingTop = getPaddingTop();
        paddingLeft = getPaddingLeft();
        paddingRight = getPaddingRight();
        paddingBottom = getPaddingBottom();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //获得圆心
        center_x = getMeasuredWidth() / 2 ;
        center_y = getMeasuredHeight() / 2 ;
        //取小的为半径
        r = Math.min((getMeasuredWidth()-paddingLeft-paddingRight) / 2, (getMeasuredHeight()-paddingTop-paddingBottom) / 2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //设置画布
        canvas.drawColor(bgColor);
        canvas.drawCircle(center_x, center_y, r, paint);
    }
}
