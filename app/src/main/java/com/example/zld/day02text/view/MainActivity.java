package com.example.zld.day02text.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.example.zld.day02text.R;
import com.example.zld.day02text.beans.Beans;
import com.example.zld.day02text.dapter.MyAdapter;
import com.example.zld.day02text.presenter.Mainpersenter;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IMain{
    int num = 10;
    @BindView(R.id.xre)
    XRecyclerView xrecy;
    private Mainpersenter mainpersenter;
    private List<Beans.NewslistBean> newslist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData(num);
        xrecy.setPullRefreshEnabled(true);
        xrecy.setLoadingMoreEnabled(true);
        xrecy.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        xrecy.setLoadingMoreProgressStyle(ProgressStyle.Pacman);
        xrecy.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                num=10;
                initData(num);
                xrecy.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                num+=10;
                initData(num);
                xrecy.refreshComplete();
            }
        });
    }

    private void initData(int num) {
        mainpersenter = new Mainpersenter(this);

        mainpersenter.getCartData("71e58b5b2f930eaf1f937407acde08fe",num);
    }

    @Override
    public void onSuccess(Beans beans) {
        newslist = beans.getNewslist();
        //适配器
        MyAdapter myAdapter=new MyAdapter(MainActivity.this,newslist);
        xrecy.setAdapter(myAdapter);
        xrecy.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onError(Throwable throwable) {
        Log.d("iiii",throwable.getMessage());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mainpersenter!=null){
            mainpersenter.unsubcribe();
        }
    }
}
