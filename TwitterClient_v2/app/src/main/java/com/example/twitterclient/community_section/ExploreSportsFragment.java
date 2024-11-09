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

public class ExploreSportsFragment extends Fragment {

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

        view = inflater.inflate(R.layout.fragment_explore_sports, container, false);

        tabLayoutTop = getActivity().findViewById(R.id.explore_tab_layout_top);
        tabLayoutBot = getActivity().findViewById(R.id.tab_layout_bot);

        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh_layout_explore_sports);
        recyclerView = view.findViewById(R.id.recycler_view_explore_sports);
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
        list.add(new Post("Zara", "June 23","Have a blessed day Blues \uD83D\uDC99", 129, 45, 123));
        list.add(new Post("NBA", "June 23","CRASH THE GLASS.\n" + "WIN THE GAME.", 151, 12, 451));
        list.add(new Post("SportsCenter", "June 23","Anthony Edwards has hit the third-most threes EVER through the first nine games of a season — behind only Steph Curry \uD83D\uDE33\uD83D\uDD25", 323, 7, 237));
        list.add(new Post("User Name 4", "June 23","Subtitle 4", 611, 5, 132));
        list.add(new Post("User Name 5", "June 23","Subtitle 5", 442, 34, 1234));
        list.add(new Post("User Name 6", "June 23","Subtitle 6", 123, 1, 120));
        list.add(new Post("User Name 7", "June 23","Subtitle 7", 386, 0, 176));

        return list;
    }
}