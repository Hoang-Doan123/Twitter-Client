package com.example.twitterclient.community_section;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.twitterclient.R;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.List;

public class ExplorePostAdapter extends RecyclerView.Adapter<ExplorePostAdapter.ExplorePostViewHolder> {
    
    private List<ExplorePost> listPost;
    
    public void setData(List<ExplorePost> list) {
        this.listPost = list;
        notifyDataSetChanged();
    }
    
    @NonNull
    @Override
    public ExplorePostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.explore_post_item, parent, false);
        return new ExplorePostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExplorePostAdapter.ExplorePostViewHolder holder, int position) {
        ExplorePost post = listPost.get(position);
        if(post == null) {
            return;
        }
        holder.explorePostUserAvatar.setImageResource(post.getExplorePostUserAvatar());
        holder.explorePostImg.setImageResource(post.getExplorePostImg());
        holder.communityName.setText(post.getCommunityName());
        holder.explorePostUserName.setText(post.getExplorePostUserName());
        holder.explorePostTag.setText(post.getExplorePostTag());
        holder.explorePostStatus.setText(post.getExplorePostStatus());
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

    public class ExplorePostViewHolder extends RecyclerView.ViewHolder {
        private ShapeableImageView explorePostUserAvatar, explorePostImg;
        private TextView communityName, explorePostUserName, explorePostTag, explorePostStatus, commentAmount, likeAmount;

        public ExplorePostViewHolder(@NonNull View itemView) {
            super(itemView);
            explorePostUserAvatar = itemView.findViewById(R.id.explore_post_user_avatar);
            explorePostImg = itemView.findViewById(R.id.explore_post_img);
            communityName = itemView.findViewById(R.id.community_name);
            explorePostUserName = itemView.findViewById(R.id.explore_post_user_name);
            explorePostTag = itemView.findViewById(R.id.explore_post_tag);
            explorePostStatus = itemView.findViewById(R.id.explore_post_status);
            commentAmount = itemView.findViewById(R.id.comment_amount);
            likeAmount = itemView.findViewById(R.id.like_amount);
        }
    }
}
