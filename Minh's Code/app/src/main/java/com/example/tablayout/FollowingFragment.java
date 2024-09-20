package com.example.tablayout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

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

    private FollowingDataAdapter followingDataAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_following, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_following);
        followingDataAdapter = new FollowingDataAdapter();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        followingDataAdapter.setData(getContext(), getFollowingData());
        recyclerView.setAdapter(followingDataAdapter);
        return view;
    }

    private List<FollowingData> getFollowingData() {
        List<FollowingData> followingData = new ArrayList<>();

        List<Post> posts = new ArrayList<>();
        posts.add(new Post(R.drawable.flying, R.drawable.img1, "User Name 1", "Subtitle 1", "1.2K", "2K"));
        posts.add(new Post(R.drawable.dragon, R.drawable.img1, "User Name 1", "Subtitle 1", "1.2K", "2K"));
        posts.add(new Post(R.drawable.dark, R.drawable.img1, "User Name 1", "Subtitle 1", "1.2K", "2K"));

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