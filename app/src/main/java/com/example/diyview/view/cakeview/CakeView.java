package com.example.diyview.view.cakeview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.diyview.utils.DpUtil;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * @data on 5/11/21 11:29 AM
 * @auther KC
 * @describe 饼状图
 */
public class CakeView extends View {
    //数据源（文本）
    ArrayList<CakeBean> dataList;
    /**
     * 精度不一样，Rect是使用int类型作为数值，RectF是使用float类型作为数值
     * 两个类型提供的方法也不是完全一致
     */
    //画背景矩形
    RectF rectF1;
    //画圆右边的矩形
    RectF rectF2;
    //画笔
    Paint mPaint;

    private int mRWidth, mRHeight;
    private float rotateDegree;//每个圆弧的起始角度
    private float sumValue = 0;//所有值的和
    private float diameter;//圆的直径
    private float textY;//绘制文字的Y坐标

    private float mRectHeight = 40;//矩形高度
    private float mRectWidth = 80;//矩形宽度
    private float mMargin = 40;//矩形和圆的距离
    private Context mContext;


    public CakeView(Context context) {
        //CakeView cakeView=new CakeView(context);
        // 在代码中new CakeView()会调用这个构造函数
        super(context);
    }

    public CakeView(Context context, @Nullable AttributeSet attrs) {
        //InflateLayoutManager时会调用这个构造函数
        super(context, attrs);
        mContext = context;
        init();
    }

    public CakeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //初始化
    private void init() {
        dataList = new ArrayList<>();
        rectF1 = new RectF();
        rectF2 = new RectF();
        mPaint = new Paint();
        mPaint.setAntiAlias(true); //抗锯齿
        mPaint.setDither(true);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //MeasureSpec封装了父View传递给子View的布局要求
        int wMode = MeasureSpec.getMode(widthMeasureSpec);
        int wSize = MeasureSpec.getSize(widthMeasureSpec);
        int hMode = MeasureSpec.getMode(heightMeasureSpec);
        int hSize = MeasureSpec.getSize(heightMeasureSpec);
        switch (wMode) {
            case MeasureSpec.EXACTLY:
                //相当于match_parent或者一个具体值
                mRWidth = wSize;
                break;
            case MeasureSpec.AT_MOST:
                // 相当于wrap_content 默认会充满父View
                // 可以根据子View的大小来计算父View大小，这里先写死大小
                mRWidth = (int) DpUtil.dp2px(mContext, 400f);
                break;
            case MeasureSpec.UNSPECIFIED:
                //很少会用到
                break;
            default:
                break;
        }
        switch (hMode) {
            case MeasureSpec.EXACTLY:
                //相当于match_parent或者一个具体值
                mRHeight = hSize;
                break;
            case MeasureSpec.AT_MOST:
                // 相当于wrap_content 默认会充满父View
                // 可以根据子View的大小来计算父View大小，这里先写死大小
                mRHeight = (int) DpUtil.dp2px(mContext, 200f);
                break;
            case MeasureSpec.UNSPECIFIED:
                //很少会用到
                break;
            default:
                break;
        }
        //存储测量好的宽和高
        setMeasuredDimension(wSize, hSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        textY = 0f;
        //设置圆形绘制的范围
        rectF1.set(0, 0, diameter, diameter);
        //画布中心X坐标向右移动（控件宽度-圆直径）之差的八分之一的距离
        //画布中心Y坐标向下移动（控件宽度-圆直径）之差的二分之一的距离
        canvas.translate((mRWidth - diameter) / 8, (mRHeight - diameter) / 2);
        if (dataList.size() > 0 && Float.compare(sumValue, 0.0f) != 0) {
            for (int i = 0; i < dataList.size(); i++) {
                CakeBean bean = dataList.get(i);
                //画圆弧
                mPaint.setColor(bean.mColor);
                canvas.drawArc(rectF1, rotateDegree, bean.degree, true, mPaint);
                rotateDegree += bean.degree;
                //画矩形和文字
                drawRectAndText(canvas, bean);
            }
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        diameter = Math.min(mRWidth, mRHeight);
    }

    private void drawRectAndText(Canvas canvas, CakeBean bean) {
        //设置画矩形的范围
        float left = diameter + mMargin;
        float right = diameter + mMargin + mRectWidth;
        float bottom = textY + mRectHeight;
        rectF2.set(left, textY, right, bottom);
        canvas.drawRect(rectF2, mPaint);
        //设置颜色
        mPaint.setColor(Color.BLACK);
        //设置文字大小
        mPaint.setTextSize(30);
        //画文字
        canvas.drawText(bean.name + "(" + new DecimalFormat(".00").format(bean.value / sumValue * 100) + "%)", right + 10, textY + 30, mPaint);
        textY += mRectHeight;
    }

    /**
     * 饼状图添加数据
     *
     * @param beans CakeBean数据
     */
    public void setData(ArrayList<CakeBean> beans) {
        if (beans == null || beans.size() <= 0) return;
        for (int i = 0; i < beans.size(); i++) {
            sumValue += beans.get(i).value;
        }
        for (int i = 0; i < beans.size(); i++) {
            beans.get(i).degree = beans.get(i).value / sumValue * 360;
            if (!beans.get(i).name.isEmpty()) {
                dataList.add(beans.get(i));
            }
        }
        invalidate();
    }

    /**
     * @param startDegree 设置起始角度
     */
    public void setStartDegree(float startDegree) {
        this.rotateDegree = startDegree;
        invalidate();
    }
}
