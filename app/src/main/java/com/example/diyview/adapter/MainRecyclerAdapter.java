package com.example.diyview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.diyview.R;

/**
 * @data on 2020/11/11 4:43 PM
 * @auther armStrong
 * @describe mainActivity布局构架
 */
public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.MyViewHolder> {
    private String[] date;

    public MainRecyclerAdapter(String[] date) {
        this.date = date;
    }

    @NonNull
    @Override
    public MainRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_recycler_item_tv, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MainRecyclerAdapter.MyViewHolder holder, int position) {
        holder.contentTv.setText(date[position]);
        holder.contentTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                String path = String.format("/show/diyView%s", position + "");
//                ToastUtils.show("item" + path);
                ARouter.getInstance().build(path).navigation();
            }
        });
    }

    @Override
    public int getItemCount() {
        return date.length;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView contentTv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            contentTv = itemView.findViewById(R.id.contentTv);
        }
    }
}
