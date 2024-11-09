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

public class ExploreFoodFragment extends Fragment {

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
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_explore_food, container, false);

        tabLayoutTop = getActivity().findViewById(R.id.explore_tab_layout_top);
        tabLayoutBot = getActivity().findViewById(R.id.tab_layout_bot);

        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh_layout_explore_food);
        recyclerView = view.findViewById(R.id.recycler_view_explore_food);
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
        list.add(new Post("Nguyen Phuong\n", "June 23","beef balls", 132, 45, 123));
        list.add(new Post("Hania\n", "June 23","Smash or pass ", 891, 12, 451));
        list.add(new Post("Thu Trang", "June 23","Honey Grilled chicken ", 993, 7, 234));
        list.add(new Post("New Dawn", "June 23","How many eggs do you eat in one sitting?", 126, 5, 123));
        list.add(new Post("\uD83D\uDD25\uD83C\uDF36\uFE0FCarl Sian\uD83C\uDF36\uFE0F\uD83D\uDD25", "June 23","\uD83D\uDD25Rise and shine, Hot Peppers Crew! \uD83C\uDF36\uFE0F☀\uFE0F ", 44, 34, 12312));
        list.add(new Post("Rane", "June 23","Good food today", 122, 1, 1256));
        list.add(new Post("BRASIL ", "June 23","Good morning: Italian Cappuccino. Enjoy ☕\uD83C\uDF05", 134, 0, 331));

        return list;
    }
}