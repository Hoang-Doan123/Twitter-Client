package com.example.twitterclient.search_section;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.twitterclient.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SearchPostAdapter extends RecyclerView.Adapter<SearchPostAdapter.SearchPostViewHolder>{

    private List<SearchPost> listSearchPost;

    public void setData(List<SearchPost> list) {
        this.listSearchPost = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SearchPostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_post_item, parent, false);
        return new SearchPostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchPostViewHolder holder, int position) {
        SearchPost searchPost = listSearchPost.get(position);
        if (searchPost == null) {
            return;
        }
        holder.subtitle1.setText(searchPost.getSubtitle1());
        holder.title.setText(searchPost.getTitle());
        holder.subtitle2.setText(searchPost.getSubtitle2());
    }

    @Override
    public int getItemCount() {
        if (listSearchPost != null) {
            return listSearchPost.size();
        }
        return 0;
    }

    public class SearchPostViewHolder extends RecyclerView.ViewHolder {

        private TextView subtitle1, title, subtitle2;

        public SearchPostViewHolder(@NotNull View itemView) {
            super(itemView);
            subtitle1 = itemView.findViewById(R.id.search_post_item_subtitle1);
            title = itemView.findViewById(R.id.search_post_item_title);
            subtitle2 = itemView.findViewById(R.id.search_post_item_subtitle2);
        }
    }
}