package com.example.diyview.dialog

import android.app.Dialog
import android.content.Context
import com.example.diyview.databinding.BaseLoadingDialogBinding

/**
 * @data on 5/17/21 10:41 AM
 * @auther KC
 * @describe 自定义加载Loading
 *
 * ProgressBar加载Loading
 * 背景为半透明状态！！！，打开Loading则整个activity的背景都变为半透明
 *
 */
class LoadingDialog(context: Context) : Dialog(context) {

    private val vBinding by lazy {
        BaseLoadingDialogBinding.inflate(layoutInflater)
    }

    init {
        setContentView(vBinding.root)
    }
}