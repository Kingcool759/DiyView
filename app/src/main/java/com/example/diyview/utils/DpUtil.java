package com.example.diyview.utils;

import android.content.Context;

/**
 * @data on 5/11/21 12:07 PM
 * @auther KC
 * @describe Android dp和px的转换 工具类
 */

public class DpUtil {
    public static int px2dp(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static int dp2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
