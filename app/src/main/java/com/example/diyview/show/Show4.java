package com.example.diyview.show;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.diyview.R;
import com.example.diyview.arout.RouterPath;

@Route(path = RouterPath.diyView4)
public class Show4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show4);
    }
}