package com.example.twitterclient.community_section;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.twitterclient.R;
import com.example.twitterclient.home_section.Post;
import com.example.twitterclient.home_section.PostAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ExploreGamingFragment extends Fragment {

    private View view;
    private TabLayout tabLayoutTop, tabLayoutBot;
    private FloatingActionButton addFab;

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private PostAdapter postAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_explore_gaming, container, false);

        tabLayoutTop = getActivity().findViewById(R.id.explore_tab_layout_top);
        tabLayoutBot = getActivity().findViewById(R.id.tab_layout_bot);

        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh_layout_explore_gaming);
        recyclerView = view.findViewById(R.id.recycler_view_explore_gaming);
        addFab = getActivity().findViewById(R.id.add_fab);

        postAdapter = new PostAdapter();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        postAdapter.setData(getListPost());
        recyclerView.setAdapter(postAdapter);

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
        List<Post> newData = getListPost();
        postAdapter.setData(newData);
        postAdapter.notifyDataSetChanged();
    }

    private List<Post> getListPost() {
        List<Post> list = new ArrayList<>();
        list.add(new Post("User Name 1", "June 23","Subtitle 1", 12, 45, 123));
        list.add(new Post("User Name 2", "June 23","Subtitle 2", 1, 12, 45));
        list.add(new Post("User Name 3", "June 23","Subtitle 3", 3, 7, 23));
        list.add(new Post("User Name 4", "June 23","Subtitle 4", 6, 5, 13));
        list.add(new Post("User Name 5", "June 23","Subtitle 5", 44, 34, 123));
        list.add(new Post("User Name 6", "June 23","Subtitle 6", 12, 1, 12));
        list.add(new Post("User Name 7", "June 23","Subtitle 7", 3, 0, 1));

        return list;
    }
}