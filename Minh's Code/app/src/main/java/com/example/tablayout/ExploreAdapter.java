package com.example.tablayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ExploreAdapter extends RecyclerView.Adapter<ExploreAdapter.ExploreViewHodel> {

    private List<Explore> mListExplore;

    public ExploreAdapter(List<Explore> mListFood) {
        this.mListExplore = mListFood;
    }

    @NonNull
    @Override
    public ExploreViewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_explore,parent,false);
        return new ExploreViewHodel(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ExploreViewHodel holder, int position) {
        Explore explore= mListExplore.get(position);
        if (explore == null){
            return;
        }

        holder.imgExplore.setImageResource(explore.getImage());

    }

    @Override
    public int getItemCount() {
        if (mListExplore != null ){
            return mListExplore.size();
        }
        return 0;
    }

    public class ExploreViewHodel extends RecyclerView.ViewHolder{

        private ImageView imgExplore;


        public ExploreViewHodel(@NonNull View itemView) {
            super(itemView);

            imgExplore = itemView.findViewById(R.id.img_explore);
        }
    }
}
