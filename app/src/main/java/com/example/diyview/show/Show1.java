package com.example.diyview.show;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.diyview.arout.RouterPath;
import com.example.diyview.R;

@Route(path = RouterPath.diyView1)
public class Show1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show1);
    }
}