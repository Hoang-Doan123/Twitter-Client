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

public class MyCommunitiesPostAdapter extends RecyclerView.Adapter<MyCommunitiesPostAdapter.MyCommunitiesPostViewHolder> {
    private List<MyCommunitiesPost> listCommunitiesPost;

    public void setData(List<MyCommunitiesPost> list) {
        this.listCommunitiesPost = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyCommunitiesPostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_communities_post_item, parent, false);
        return new MyCommunitiesPostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyCommunitiesPostViewHolder holder, int position) {
        MyCommunitiesPost communitiesPost = listCommunitiesPost.get(position);
        if(communitiesPost == null) {
            return;
        }
        holder.communitiesPostAvatar.setImageResource(communitiesPost.getCommunitiesPostAvatar());
        holder.communitiesPostName.setText(communitiesPost.getCommunitiesPostName());
        holder.communitiesPostNumberMembers.setText(communitiesPost.getCommunitiesPostNumberMembers());
        holder.communitiesPostTopic.setText(communitiesPost.getCommunitiesPostTopic());
    }

    @Override
    public int getItemCount() {
        if (listCommunitiesPost != null) {
            return listCommunitiesPost.size();
        }
        return 0;
    }

    public class MyCommunitiesPostViewHolder extends RecyclerView.ViewHolder {

        private ShapeableImageView communitiesPostAvatar;
        private TextView communitiesPostName, communitiesPostNumberMembers, communitiesPostTopic;

        public MyCommunitiesPostViewHolder(@NonNull View itemView) {
            super(itemView);
            communitiesPostAvatar = itemView.findViewById(R.id.communities_post_avatar);
            communitiesPostName = itemView.findViewById(R.id.communities_post_name);
            communitiesPostNumberMembers = itemView.findViewById(R.id.communities_post_number_members);
            communitiesPostTopic = itemView.findViewById(R.id.communities_post_topic);
        }
    }
}
