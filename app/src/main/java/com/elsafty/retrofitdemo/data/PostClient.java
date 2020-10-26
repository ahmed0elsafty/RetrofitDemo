package com.elsafty.retrofitdemo.data;

import com.elsafty.retrofitdemo.pojo.Post;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostClient {
    private final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private static PostClient INSTANCE;
    private ApiInterface apiInterface;

    public PostClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        apiInterface = retrofit.create(ApiInterface.class);
    }

    public static PostClient getIntanceClient() {
        if (INSTANCE==null){
            INSTANCE = new PostClient();
            return INSTANCE;
        }
        return INSTANCE;
    }
    public Single<List<Post>> getPosts(){
        return apiInterface.getPosts();
    }
}
