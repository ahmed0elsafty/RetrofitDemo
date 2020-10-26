package com.elsafty.retrofitdemo.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.elsafty.retrofitdemo.R;
import com.elsafty.retrofitdemo.pojo.Post;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostsViewHolder> {
    private List<Post> items = new ArrayList<>();
    private Context mContext;

    public PostsAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public PostsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostsViewHolder holder, int position) {
        Post post = items.get(position);
        holder.titleTextView.setText(post.getTitle());
        holder.bodyTextView.setText(post.getBody());
        holder.userIdTextView.setText(String.valueOf(post.getUserId()));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setList(List<Post> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public class PostsViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTextView, bodyTextView, userIdTextView;

        public PostsViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.txt_title);
            bodyTextView = itemView.findViewById(R.id.txt_body);
            userIdTextView = itemView.findViewById(R.id.txt_userId);
        }
    }
}