package com.bw.rikao0509.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.rikao0509.R;
import com.bw.rikao0509.bean.NewsBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
   private Context context;
   private NewsBean newsBean;
  private static  int  YUNAXING =0;
    private static  int  YUNAJIAO =1;


    public MyAdapter(Context context,NewsBean newsBean) {
        this.context = context;
        this.newsBean = newsBean;
    }

    @Override
    public int getItemViewType(int position) {
          if (position % 2==0){
            return  YUNAXING;
          }else {
            return  YUNAJIAO;
          }

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == YUNAXING) {
            view = View.inflate(context, R.layout.yuanxing, null);
            YuanHolder yuanHolder = new YuanHolder(view);
            return yuanHolder;
        } else  {

            view = View.inflate(context, R.layout.yuanjiao, null);
            MyHolder myHolder = new MyHolder(view);
            return myHolder;
        }


    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        List<NewsBean.NewslistBean> newslist = newsBean.getNewslist();
        if (holder instanceof  YuanHolder){
            String picUrl =newslist .get(position).getPicUrl();
            ((YuanHolder) holder).yuanxing_view.setImageURI(picUrl);
           ((YuanHolder) holder).tvTitle.setText(newsBean.getNewslist().get(position).getTitle());
        }else if (holder instanceof  MyHolder){
            String picUrl = newslist.get(position).getPicUrl();
            ((MyHolder) holder).simple_view.setImageURI(picUrl);
            ((MyHolder) holder).text_title.setText(newslist.get(position).getTitle());
        }

    }

    @Override
    public int getItemCount() {

        if(newsBean.getNewslist() != null &&  newsBean.getNewslist().size() > 0){
            return  newsBean.getNewslist().size();
        }
        return 0;
    }
}
class MyHolder extends RecyclerView.ViewHolder {

    public   SimpleDraweeView simple_view;
    public   TextView text_title;

    public MyHolder(View itemView) {
        super(itemView);
        simple_view = itemView.findViewById(R.id.simple_view);
        text_title = itemView.findViewById(R.id.text_title);


    }

}
class YuanHolder extends RecyclerView.ViewHolder {

    public SimpleDraweeView yuanxing_view;
    public TextView tvTitle;

    public YuanHolder(View itemView) {
        super(itemView);
        yuanxing_view = itemView.findViewById(R.id.yuanxing_view);
        tvTitle = itemView.findViewById(R.id.tvTitle);
    }
}