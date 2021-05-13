package com.example.diyview.show;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.diyview.R;
import com.example.diyview.arout.ARouterPath;
import com.example.diyview.viewgroup.flow.FlowLayoutView;

import java.util.ArrayList;
import java.util.Arrays;

@Route(path = ARouterPath.diyView4)
//自定义View实现流式布局（带点击事件）
public class Show4 extends AppCompatActivity {
    private ArrayList<String> datas;

    private final String[] tagTextArray = new String[]{"天猫精灵", "充电台灯", "睡衣", "手表", "创意水杯", "夏天T恤男", "灯光机械键盘",
            "计算机原理", "学霸笔记本", "可口可乐", "跑步机", "旅行箱", "竹浆卫生纸", "吹风机", "洗面奶", "窗帘"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show4);

        //将数组转成list，因为一般都是从api接口接收的数据都是list
        datas = new ArrayList();
        datas.addAll(Arrays.asList(tagTextArray));
        initView();
    }

    private void initView() {
        //自定义ViewGroup
        FlowLayoutView flowLayoutView = findViewById(R.id.flowlayout);
        for (int i = 0; i < datas.size(); i++) {
            View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.flow_tv_content, null);
            TextView tvContent = view.findViewById(R.id.flow_tv);
            tvContent.setText(datas.get(i));
            flowLayoutView.addView(view);

            //点击事件
            tvContent.setOnClickListener((View)->{
                Toast.makeText(this,tvContent.getText()+"",Toast.LENGTH_SHORT).show();
                tvContent.setSelected(!tvContent.isSelected()); //取反
                if (tvContent.isSelected()){
                    tvContent.setTextColor(getColor(R.color.white));
                }else {
                    tvContent.setTextColor(0xcc000000);
                }
            });
        }
    }
}