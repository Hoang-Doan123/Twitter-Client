package com.example.twitterclient.search_section;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.twitterclient.R;
import com.example.twitterclient.home_section.Post;
import com.example.twitterclient.home_section.PostAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class SearchForYouFragment extends Fragment {

    private View view;
    private TabLayout tabLayoutTop, tabLayoutBot;
    private FloatingActionButton addFab;

    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private SearchPostAdapter searchPostAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search_for_you, container, false);

        tabLayoutBot = getActivity().findViewById(R.id.tab_layout_bot);

        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh_layout_search_for_you);
        recyclerView = view.findViewById(R.id.recycler_view_search_for_you);
        addFab = getActivity().findViewById(R.id.add_fab);

        searchPostAdapter = new SearchPostAdapter();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        searchPostAdapter.setData(getListSearchPost());
        recyclerView.setAdapter(searchPostAdapter);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshData();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0) {
                    tabLayoutBot.setVisibility(View.INVISIBLE);
                    addFab.hide();
                } else {
                    tabLayoutBot.setVisibility(View.VISIBLE);
                    addFab.show();
                }
                super.onScrolled(recyclerView, dx, dy);
            }
        });
        return view;
    }

    private void refreshData() {
        List<SearchPost> newData = getListSearchPost();
        searchPostAdapter.setData(newData);
        searchPostAdapter.notifyDataSetChanged();
    }

    private List<SearchPost> getListSearchPost() {
        List<SearchPost> list = new ArrayList<>();
        list.add(new SearchPost("Gaming - Trending", "VALORANT", "39K posts"));
        list.add(new SearchPost("Video games - Trending", "Halo", "63.7K posts"));
        list.add(new SearchPost("Video games - Trending", "Roblox", "38.9K posts"));
        list.add(new SearchPost("Trending", "TenZ", "25.3K posts"));
        list.add(new SearchPost("Music - Trending", "carti", "35.1K posts"));
        list.add(new SearchPost("Trending in Music", "#IRENE", "32K posts"));
        list.add(new SearchPost("Trending in Sports", "Mexicans", "14.4K posts"));
        list.add(new SearchPost("Gaming - Trending", "VALORANT", "39K posts"));
        list.add(new SearchPost("Video games - Trending", "Halo", "63.7K posts"));
        list.add(new SearchPost("Video games - Trending", "Roblox", "38.9K posts"));
        list.add(new SearchPost("Trending", "TenZ", "25.3K posts"));
        list.add(new SearchPost("Music - Trending", "carti", "35.1K posts"));
        list.add(new SearchPost("Trending in Music", "#IRENE", "32K posts"));

        return list;
    }
}