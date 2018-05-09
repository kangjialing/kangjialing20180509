package com.bw.rikao0509.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bw.rikao0509.R;
import com.bw.rikao0509.bean.NewsBean;
import com.bw.rikao0509.persenter.IMain;
import com.bw.rikao0509.persenter.MainPersenter;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IMain{

    @BindView(R.id.recy_view)
    XRecyclerView recyView;
    private MainPersenter mainPersenter;
    int num=10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView(num);
        recyView.setPullRefreshEnabled(true);
        recyView.setLoadingMoreEnabled(true);
        recyView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        recyView.setLoadingMoreProgressStyle(ProgressStyle.Pacman);
        recyView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                num=10;
                initView(num);
                recyView.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                num+=10;
                initView(num);
                recyView.refreshComplete();
            }
        });
    }
    public  void  initView(int num){
        mainPersenter = new MainPersenter(this);
        String key="f04ad16366c2c564e2669df6b5c70a40";

        mainPersenter.getNews(key,num);
    }

    @Override
    public void onScuess(NewsBean newsBean) {

        MyAdapter myAdapter=new MyAdapter(MainActivity.this,newsBean);
        recyView.setAdapter(myAdapter);
        recyView.setLayoutManager(new LinearLayoutManager(this));
    }
}
