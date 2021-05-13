package com.example.diyview.view.circle;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.diyview.R;

/**
 * @data on 2020/11/11 3:32 PM
 * @auther KC
 * @describe 自定义实心圆
 */
public class SolidCircleView extends View {
    /**
     * 文本
     */
    private String mCircleText;
    /**
     * 文本颜色
     */
    private int mCircleTextColor;
    /**
     * 文本字体大小
     */
    private int mCircleTextSize;
    /**
     * 圆的颜色
     */
    private int mCircleColor;
    /**
     * 圆的背景颜色
     */
    private int mCircleBackground;

    //圆心
    private int center_x;
    private int center_y;
    //半径
    private int r;
    //padding
    private int paddingLeft;
    private int paddingRight;
    private int paddingTop;
    private int paddingBottom;
    //画笔
    private Paint mPaint;
    private Paint mPaint2;

    //文本
    private int text_start;
    private int text_end;

    //文字宽高
    private Rect mBounds;

    public SolidCircleView(Context context) {
        super(context);
    }

    public SolidCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        /**
         *  获取我们所定义的自定义样式属性
         */

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SolidCircle);
        int n = a.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.SolidCircle_circle_color:  //圆的颜色，默认设置黑色
                    mCircleColor = a.getColor(attr, Color.BLACK);
                    break;
                case R.styleable.SolidCircle_circle_backgroud:  //背景颜色，默认设置白色
                    mCircleBackground = a.getColor(attr, Color.WHITE);
                    break;
                case R.styleable.SolidCircle_circle_text: //文本
                    mCircleText = a.getString(attr);
                    break;
                case R.styleable.SolidCircle_circle_textColor:  //字体颜色，默认设置绿色
                    mCircleTextColor = a.getColor(attr, Color.GREEN);
                    break;
                case R.styleable.SolidCircle_circle_textSize:  //字体大小，默认设置16sp
                    mCircleTextSize = a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
                    break;
            }
        }


        //回收
        a.recycle();
        //设置画笔
        mPaint = new Paint();
        mPaint2 = new Paint();  //画圆字体
        mPaint.setAntiAlias(true); //抗锯齿
        mPaint.setStyle(Paint.Style.FILL); //实心圆
        //mPaint.setColor(context.getResources().getColor(R.color.white)); //从绝对路径取颜色才可以，直接使用R.color.white会颜色错乱，得不到指定的颜色
        mPaint.setColor(mCircleColor);
        //设置padding
        paddingTop = getPaddingTop();
        paddingLeft = getPaddingLeft();
        paddingRight = getPaddingRight();
        paddingBottom = getPaddingBottom();

        //测量文字的宽高
        mBounds = new Rect();
        //改颜色，画字体
        mPaint2.setTextSize(mCircleTextSize);
        mPaint2.getTextBounds(mCircleText, 0, mCircleText.length(), mBounds); //必须设置在TextSize之后，否则字体不一定为居中，因为要根据字体大小测量字体的宽高！！！
        mPaint2.setColor(mCircleTextColor);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //获得圆心
        center_x = getMeasuredWidth() / 2;
        center_y = getMeasuredHeight() / 2;
        //取小的为半径
        r = Math.min((getMeasuredWidth() - paddingLeft - paddingRight) / 2, (getMeasuredHeight() - paddingTop - paddingBottom) / 2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //设置画布
        canvas.drawColor(mCircleBackground);
        canvas.drawCircle(center_x, center_y, r, mPaint);
        canvas.drawText(mCircleText, center_x - mBounds.right / 2, center_y + mBounds.bottom / 2, mPaint2);
    }
}
