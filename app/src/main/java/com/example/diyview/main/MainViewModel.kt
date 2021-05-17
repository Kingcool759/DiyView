package com.example.diyview.main

import android.app.Application
import androidx.databinding.ObservableArrayList
import com.alibaba.android.arouter.launcher.ARouter
import com.example.diyview.BR
import com.example.diyview.databean.Item
import com.example.diyview.R
import com.example.diyview.arout.RouterPath
import com.example.diyview.base.BaseViewModel
import me.tatarka.bindingcollectionadapter2.ItemBinding

/**
 * @data on 5/17/21 10:58 AM
 * @auther KC
 * @describe
 */
class MainViewModel(application: Application) : BaseViewModel(application) {

    val items = ObservableArrayList<Item>()
    val itemBinding = ItemBinding.of<Item>(BR.item, R.layout.base_item_binding)
            .bindExtra(BR.viewModel, this)

    init {
        items.add(Item("01自定义View系列：实心圆+文字", 1))
        items.add(Item("02自定义View系列：饼状图+数据", 2))
        items.add(Item("03自定义View系列：圆环", 3))
        items.add(Item("04自定义View系列：奥运五环", 4))
        items.add(Item("05自定义View系列：流式布局", 5))
        items.add(Item("06自定义View系列：加载Loading", 6))
        items.add(Item("0*自定义View系列：***", 7))
        items.add(Item("0*自定义View系列：***", 8))
        items.add(Item("0*自定义View系列：***", 9))
        items.add(Item("0*自定义View系列：***", 10))
        items.add(Item("0*自定义View系列：***", 11))
        items.add(Item("0*自定义View系列：***", 12))
        items.add(Item("0*自定义View系列：***", 13))
        items.add(Item("0*自定义View系列：***", 14))
    }

    fun onClickItem(item: Item) {
        ARouter.getInstance().build(RouterPath.basePath.plus(item.positon)).navigation()
    }
}