package com.example.tablayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.List;

public class CardFollowAdapter extends RecyclerView.Adapter<CardFollowAdapter.CardFollowViewHolder> {

    private List<CardFollow> listCardFollow;

    public void setData(List<CardFollow> list) {
        this.listCardFollow = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CardFollowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_follow_item, parent, false);
        return new CardFollowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardFollowViewHolder holder, int position) {
        CardFollow cardFollow = listCardFollow.get(position);
        if(cardFollow == null) {
            return;
        }

        holder.cardFollowAvatar.setImageResource(cardFollow.getCardFollowAvatar());
        holder.cardFollowName.setText(cardFollow.getCardFollowName());
        holder.cardFollowTag.setText(cardFollow.getCardFollowTag());
    }

    @Override
    public int getItemCount() {
        if(listCardFollow != null) {
            return listCardFollow.size();
        }
        return 0;
    }

    public class CardFollowViewHolder extends RecyclerView.ViewHolder {

        private ShapeableImageView cardFollowAvatar;
        private TextView cardFollowName, cardFollowTag;

        public CardFollowViewHolder(@NonNull View itemView) {
            super(itemView);

            cardFollowAvatar = itemView.findViewById(R.id.card_follow_avatar);
            cardFollowName = itemView.findViewById(R.id.card_follow_name);
            cardFollowTag = itemView.findViewById(R.id.card_follow_tag);
        }
    }
}
