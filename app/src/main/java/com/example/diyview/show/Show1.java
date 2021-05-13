package com.example.diyview.show;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.diyview.arout.ARouterPath;
import com.example.diyview.R;
import com.example.diyview.view.cakeview.CakeBean;
import com.example.diyview.view.cakeview.CakeView;

import java.util.ArrayList;

@Route(path = ARouterPath.diyView1)
public class Show1 extends AppCompatActivity {
    private ArrayList<CakeBean> beans;
    private final String[] names = {"php", "object-c", "c", "c++", "java", "android", "linux"};
    private final float[] values = {2f, 2f, 3f, 4f, 5f, 6f, 7f};  //比例
    private final int[] colArrs = {
            Color.RED,
            Color.parseColor("#4ebcd3"),
            Color.MAGENTA,
            Color.YELLOW,
            Color.GREEN,
            Color.parseColor("#f68b2b"),
            Color.parseColor("#6fb30d")
    };//圆弧颜色

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show1);
        beans = new ArrayList<>();
        initView();
    }

    /**
     * 初始化数据
     */
    private void initData() {
        for (int i = 0; i < 7; i++) {
            CakeBean bean = new CakeBean();
            bean.name = names[i];
            bean.value = values[i];
            bean.mColor = colArrs[i];
            beans.add(bean);
        }
    }

    /**
     * 初始化视图
     */
    private void initView() {
        initData();
        CakeView cv = findViewById(R.id.cake_view);
        cv.setData(beans);
    }
}