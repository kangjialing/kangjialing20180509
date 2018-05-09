package com.example.zld.day02text.presenter;

import com.example.zld.day02text.beans.Beans;

/**
 * Created by zld on 2018/5/9.
 */

public interface Ipersenter {
    void getCartData(String key, int num);
    void unsubcribe();
    void onSuccess(Beans beans);
    void onError(Throwable throwable);
}
