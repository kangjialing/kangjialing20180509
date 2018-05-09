package com.example.zld.day02text.model;

import com.example.zld.day02text.beans.Beans;
import com.example.zld.day02text.presenter.Ipersenter;
import com.example.zld.day02text.utils.RetrofitUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by zld on 2018/5/9.
 */

public class MainMolder implements  BaseModel{
    private Ipersenter ipersenter;
    private Disposable d;

    public MainMolder(Ipersenter ipersenter) {
        this.ipersenter=ipersenter;
    }
    @Override
    public void getCartData(String key, int num) {
        RetrofitUtil.getService().doGet(key,num)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Beans>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        MainMolder.this.d=d;
                    }

                    @Override
                    public void onNext(Beans beans) {
                        ipersenter.onSuccess(beans);
                    }

                    @Override
                    public void onError(Throwable e) {
                        ipersenter.onError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void unsubcribe() {
        d.dispose();//接除订阅
    }
}
