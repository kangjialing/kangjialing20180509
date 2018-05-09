package com.example.zld.day02text.presenter;

import com.example.zld.day02text.beans.Beans;
import com.example.zld.day02text.model.MainMolder;
import com.example.zld.day02text.view.IMain;

/**
 * Created by zld on 2018/5/9.
 */

public class Mainpersenter  extends  BasePersenter implements  Ipersenter{
    private  MainMolder mainMolder;
    private IMain iMain;
    public Mainpersenter(IMain iMain) {
        this.iMain=iMain;
        mainMolder = new MainMolder(this);
    }
    @Override
    public void getCartData(String key, int num) {
        mainMolder.getCartData( key, num);
    }

    @Override
    public void unsubcribe() {
        mainMolder.unsubcribe();
    }

    @Override
    public void onSuccess(Beans beans) {
        iMain.onSuccess(beans);
    }

    @Override
    public void onError(Throwable throwable) {
        iMain.onError(throwable);
    }
}
