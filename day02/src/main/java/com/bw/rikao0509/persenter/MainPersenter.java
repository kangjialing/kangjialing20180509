package com.bw.rikao0509.persenter;

import com.bw.rikao0509.bean.NewsBean;
import com.bw.rikao0509.model.Ipersenter;
import com.bw.rikao0509.model.MainModel;


public class MainPersenter implements Ipersenter{

    private  MainModel mainModel;
    private  IMain iMain;

    public MainPersenter(IMain iMain) {
        this.iMain=iMain;
        mainModel = new MainModel(this);
    }

    public void getNews(String key, int num) {
        mainModel.getNews( key,  num);
    }

    @Override
    public void onScuess(NewsBean newsBean) {
        iMain.onScuess(newsBean);
    }
}
