package com.bw.rikao0509.utils;

import com.bw.rikao0509.bean.NewsBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiService {
 @GET("wxnew/")
 Observable<NewsBean> doGet(@Query("key") String key, @Query("num") String num);
}
