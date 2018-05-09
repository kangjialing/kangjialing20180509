package com.example.zld.day02text.presenter;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by zld on 2018/5/9.
 */

public class BasePersenter<T> {
    protected Reference<T> mViewRef;//View接口类型弱引用
    public void attachView(T view) {
        mViewRef = new WeakReference<T>(view); //建立关联
    }
    protected T getView() {
        return mViewRef.get();//获取View
    }
    public boolean isViewAttached() {//判断是否与View建立了关联
        return mViewRef != null && mViewRef.get() != null;
    }
    public void detachView() {//解除关联
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }
}
