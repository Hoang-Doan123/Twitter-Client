package com.example.tablayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FollowingDataAdapter extends RecyclerView.Adapter<FollowingDataAdapter.FollowingDataViewHolder> {

    public static final int TYPE_CARD_FOLLOW = 1;
    public static final int TYPE_POST = 2;

    private List<FollowingData> listFollowingData;
    private Context context;

    public void setData(Context context, List<FollowingData> list) {
        this.context = context;
        this.listFollowingData = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return listFollowingData.get(position).getType();
    }

    @NonNull
    @Override
    public FollowingDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.following_data, parent, false);
        return new FollowingDataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FollowingDataViewHolder holder, int position) {
        FollowingData followingData = listFollowingData.get(position);
        if (followingData == null) {
            return;
        }
        if (TYPE_CARD_FOLLOW == holder.getItemViewType()) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);
            holder.rcvItem.setLayoutManager(linearLayoutManager);
            holder.rcvItem.setFocusable(false);

            CardFollowAdapter cardFollowAdapter = new CardFollowAdapter();
            cardFollowAdapter.setData(followingData.getListCardFollow());

            holder.rcvItem.setAdapter(cardFollowAdapter);

        } else if (TYPE_POST == holder.getItemViewType()) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, RecyclerView.VERTICAL, false);
            holder.rcvItem.setLayoutManager(linearLayoutManager);
            holder.rcvItem.setFocusable(false);

            PostAdapter postAdapter = new PostAdapter();
            postAdapter.setData(followingData.getListPost());

            holder.rcvItem.setAdapter(postAdapter);
        }
    }

    @Override
    public int getItemCount() {
        if (listFollowingData != null) {
            return listFollowingData.size();
        }
        return 0;
    }

    public class FollowingDataViewHolder extends RecyclerView.ViewHolder {

        private RecyclerView rcvItem;

        public FollowingDataViewHolder(@NonNull View itemView) {
            super(itemView);

            rcvItem = itemView.findViewById(R.id.rcv_item);
        }
    }
}
