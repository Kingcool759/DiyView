package com.example.diyview.main;

import com.example.diyview.base.BaseMvvmActivity;
import com.example.diyview.databinding.ActivityMainBinding;

public class MainActivity extends BaseMvvmActivity<ActivityMainBinding,MainViewModel>{

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        ActivityMainBinding dataBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
//        MainViewModel viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
//        dataBinding.setViewModel(viewModel);
//        dataBinding.setLifecycleOwner(this);
//    }

    @Override
    public boolean isFitsSystemWindows() {
        return true;  //防止顶部布局和状态栏重叠
    }
}