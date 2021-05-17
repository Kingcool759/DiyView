package com.example.diyview.show

import android.graphics.drawable.AnimationDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.annotation.RequiresApi
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.diyview.dialog.LoadingDialog
import com.example.diyview.arout.RouterPath
import com.example.diyview.databinding.ActivityShow6Binding

@Route(path = RouterPath.diyView6)
class Show6 : AppCompatActivity() {

    private val vBinding by lazy {
        ActivityShow6Binding.inflate(layoutInflater)
    }
    private val loadingDialog by lazy {
        LoadingDialog(this)
    }

    @RequiresApi(Build.VERSION_CODES.N)  //setProgress(i,true)需要用到的版本api容错
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(vBinding.root)
        vBinding.showLoading1.setOnClickListener {
            loadingDialog.show()
        }

        vBinding.showLoading2.setOnClickListener {
            for (i in 0..100 step 1) {
                vBinding.pgbarHor1.setProgress(i, true)  //动态附带动画效果
            }
            vBinding.pgbarHor1.progress = 0
        }
        vBinding.showLoading3.setOnClickListener {
            val ad = vBinding.aminImage.drawable as AnimationDrawable
            vBinding.aminImage.postDelayed(Runnable {
                ad.start()
            }, 100)
        }
    }
}