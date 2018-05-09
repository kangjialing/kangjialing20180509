package com.example.zld.day02text.utils;

import com.example.zld.day02text.beans.Beans;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by zld on 2018/5/9.
 */

public interface ApiService {
    @GET("nba/")
    Observable<Beans> doGet(@Query("key") String key, @Query("num") int num);
}
