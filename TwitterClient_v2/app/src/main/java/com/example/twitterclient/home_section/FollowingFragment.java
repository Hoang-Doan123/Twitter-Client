package com.example.twitterclient.home_section;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.twitterclient.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class FollowingFragment extends Fragment {
    private View view;
    private ScrollView scrollView;
    private TabLayout tabLayoutTop, tabLayoutBot;
    private FloatingActionButton addFab;

    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private FollowingDataAdapter followingDataAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_following, container, false);

        tabLayoutTop = getActivity().findViewById(R.id.home_tab_layout_top);
        tabLayoutBot = getActivity().findViewById(R.id.tab_layout_bot);

        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh_layout_following);
        recyclerView = view.findViewById(R.id.recycler_view_following);
        addFab = getActivity().findViewById(R.id.add_fab);

        followingDataAdapter = new FollowingDataAdapter();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        followingDataAdapter.setData(getContext(), getFollowingData());
        recyclerView.setAdapter(followingDataAdapter);

        tabLayoutBot.setVisibility(View.VISIBLE);
        addFab.show();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                if (!recyclerView.canScrollVertically(-1)) {
                    // RecyclerView đã đạt đỉnh, SwipeRefreshLayout sẽ hoạt động
                    swipeRefreshLayout.setEnabled(true);
                } else {
                    swipeRefreshLayout.setEnabled(false);
                }

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

    private List<FollowingData> getFollowingData() {
        List<FollowingData> followingData = new ArrayList<>();

        List<com.example.twitterclient.home_section.Post> posts = new ArrayList<>();
        posts.add(new Post("User Name 7", "June 23","Subtitle 7", 3, 0, 1));
        posts.add(new Post("User Name 7", "June 23","Subtitle 7", 1, 3, 10));
        posts.add(new Post("User Name 7", "June 23","Subtitle 7", 2, 1, 9));

        List<CardFollow> cardFollows = new ArrayList<>();
        cardFollows.add(new CardFollow(R.drawable.ghost, "User Name 1", "@UserName1"));
        cardFollows.add(new CardFollow(R.drawable.dragon, "User Name 1", "@UserName1"));
        cardFollows.add(new CardFollow(R.drawable.dark, "User Name 1", "@UserName1"));
        cardFollows.add(new CardFollow(R.drawable.ghost, "User Name 1", "@UserName1"));
        cardFollows.add(new CardFollow(R.drawable.dragon, "User Name 1", "@UserName1"));
        cardFollows.add(new CardFollow(R.drawable.dark, "User Name 1", "@UserName1"));

        followingData.add(new FollowingData(FollowingDataAdapter.TYPE_POST, null, posts));
        followingData.add(new FollowingData(FollowingDataAdapter.TYPE_CARD_FOLLOW, cardFollows, null));
        followingData.add(new FollowingData(FollowingDataAdapter.TYPE_POST, null, posts));

        return followingData;
    }
}