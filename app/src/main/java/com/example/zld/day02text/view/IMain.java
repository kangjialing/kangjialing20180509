package com.example.zld.day02text.view;

import com.example.zld.day02text.beans.Beans;

/**
 * Created by zld on 2018/5/9.
 */

public interface IMain {
    void onSuccess(Beans beans);
    void onError(Throwable throwable);
}
