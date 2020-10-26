package com.elsafty.retrofitdemo.data;

import com.elsafty.retrofitdemo.pojo.Post;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("posts")
    Single<List<Post>> getPosts();
}
