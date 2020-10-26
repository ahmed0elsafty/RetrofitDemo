package com.elsafty.retrofitdemo.ui;

import com.elsafty.retrofitdemo.data.PostClient;
import com.elsafty.retrofitdemo.pojo.Post;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PostViewModel extends ViewModel {
    MutableLiveData<List<Post>> postListMutableLiveData = new MutableLiveData<>();

    public void getPosts(){
        Single<List<Post>> observable = PostClient.getIntanceClient().getPosts()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new SingleObserver<List<Post>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(List<Post> posts) {
                postListMutableLiveData.setValue(posts);
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }
}
