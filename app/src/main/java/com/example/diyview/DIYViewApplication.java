package com.example.diyview;

import android.app.Application;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hjq.toast.ToastUtils;

/**
 * @data on 2020/11/11 5:16 PM
 * @auther armStrong
 * @describe 注册路由
 */
public class DIYViewApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this);
        ToastUtils.init(this);
    }
}
