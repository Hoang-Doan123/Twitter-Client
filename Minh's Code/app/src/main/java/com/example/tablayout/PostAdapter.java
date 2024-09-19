package com.example.tablayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private List<Post> listPost;

    public void setData(List<Post> list) {
        this.listPost = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Post post = listPost.get(position);
        if(post == null) {
            return;
        }
        holder.userAvatar.setImageResource(post.getUserAvatar());
        holder.postImg.setImageResource(post.getPostImg());
        holder.userName.setText(post.getUserName());
        holder.postTitle.setText(post.getPostTitle());
        holder.commentAmount.setText(post.getCommentAmount());
        holder.likeAmount.setText(post.getLikeAmount());
    }

    @Override
    public int getItemCount() {
        if (listPost != null) {
            return listPost.size();
        }
        return 0;
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {

        private ShapeableImageView userAvatar, postImg;
        private TextView userName, postTitle, commentAmount, likeAmount;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            userAvatar = itemView.findViewById(R.id.user_avatar);
            postImg = itemView.findViewById(R.id.post_img);
            userName = itemView.findViewById(R.id.user_name);
            postTitle = itemView.findViewById(R.id.post_title);
            commentAmount = itemView.findViewById(R.id.comment_amount);
            likeAmount = itemView.findViewById(R.id.like_amount);
        }
    }
}
