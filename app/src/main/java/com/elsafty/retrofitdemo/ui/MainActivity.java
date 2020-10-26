package com.elsafty.retrofitdemo.ui;

import android.os.Bundle;
import android.view.View;

import com.elsafty.retrofitdemo.R;
import com.elsafty.retrofitdemo.pojo.Post;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private RecyclerView postsRecyclerView;
    private PostsAdapter mAdapter;
    private List<Post> mPosts;
    private PostViewModel postViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        postsRecyclerView = findViewById(R.id.posts_recyclerView);
        mAdapter = new PostsAdapter(this);
        postsRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        postsRecyclerView.setAdapter(mAdapter);

        postViewModel =  new ViewModelProvider(this).get(PostViewModel.class);
        postViewModel.getPosts();
        postViewModel.postListMutableLiveData.observe(this, new Observer<List<Post>>() {
            @Override
            public void onChanged(List<Post> posts) {
                mAdapter.setList(posts);
            }
        });


    }
}