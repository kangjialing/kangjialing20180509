package com.example.zld.day02text.dapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zld.day02text.R;
import com.example.zld.day02text.beans.Beans;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zld on 2018/5/9.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Beans.NewslistBean> list;
    private static int YUNAXING = 0;
    private static int YUNAJIAO = 1;

    public MyAdapter(Context context, List<Beans.NewslistBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return YUNAXING;
        } else {
            return YUNAJIAO;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == YUNAXING) {
            View view = View.inflate(context, R.layout.rieate_layout, null);
            YuanHolder yuanHolder = new YuanHolder(view);
            return yuanHolder;
        } else {
            View view = View.inflate(context, R.layout.left_layout, null);
            MyHolder myHolder = new MyHolder(view);
            return myHolder;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof YuanHolder) {
            ((YuanHolder) holder).r_img.setImageURI(list.get(position).getPicUrl());
          ((YuanHolder) holder).r_tv.setText(list.get(position).getTitle());
        } else if (holder instanceof MyHolder) {
            ((MyHolder) holder).left_img.setImageURI(list.get(position).getPicUrl());
            ((MyHolder) holder).left_tv.setText(list.get(position).getTitle());
        }
    }

    @Override
    public int getItemCount() {

     if (list!=null&& list.size()>0){
         return  list.size();
     }
        return 0;

    }

    class MyHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView left_img;
        private final TextView left_tv;

        public MyHolder(View itemView) {
            super(itemView);
            left_img = itemView.findViewById(R.id.left_img);
            left_tv = itemView.findViewById(R.id.left_tv);
        }
    }

    class YuanHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView r_img;
        private final TextView r_tv;

        public YuanHolder(View itemView) {
            super(itemView);
            r_img = itemView.findViewById(R.id.r_img);
            r_tv = itemView.findViewById(R.id.r_tv);
        }
    }
}