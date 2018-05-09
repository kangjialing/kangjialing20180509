package com.bw.rikao0509.model;

import com.bw.rikao0509.bean.NewsBean;
import com.bw.rikao0509.utils.RetrofitUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;



public class MainModel {
    private  Ipersenter ipersenter;

    public MainModel(Ipersenter ipersenter) {
        this.ipersenter=ipersenter;
    }

    public void getNews(String key, int num) {
        RetrofitUtil.getService().doGet(key, String.valueOf(num))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<NewsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NewsBean newsBean) {
                      ipersenter.onScuess(newsBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
