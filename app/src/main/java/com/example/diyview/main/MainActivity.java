package com.example.diyview.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.diyview.adapter.MainRecyclerAdapter;
import com.example.diyview.R;

public class MainActivity extends AppCompatActivity {
    private LinearLayoutManager layoutManager;
    private MainRecyclerAdapter adapter;
    private RecyclerView recycler;
    private String[] items = new String[]{
            "00自定义View：圆",  //0
            "00自定义View：圆",  //0
            "00自定义View：圆",  //0
            "00自定义View：圆",  //0
            "00自定义View：圆",  //0
            "00自定义View：圆",  //0
            "00自定义View：圆",  //0
            "00自定义View：圆",  //0
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler = findViewById(R.id.mainRecycler);
        setRecycle();
    }

    private void setRecycle(){
        layoutManager = new LinearLayoutManager(this);
        adapter = new MainRecyclerAdapter(items);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(adapter);
        recycler.setItemAnimator(new DefaultItemAnimator());
    }
}