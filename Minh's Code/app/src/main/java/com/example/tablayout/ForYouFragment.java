package com.example.tablayout;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ForYouFragment extends Fragment {

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
        view = inflater.inflate(R.layout.fragment_for_you, container, false);

        // toolbar = getActivity().findViewById(R.id.tool_bar);
        tabLayoutTop = getActivity().findViewById(R.id.tab_layout_top);
        tabLayoutBot = getActivity().findViewById(R.id.tab_layout_bot);

        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh_layout_for_you);
        recyclerView = view.findViewById(R.id.recycler_view_for_you);
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
        list.add(new Post(R.drawable.dragon, R.drawable.img1, "User Name 1", "Subtitle 1", "1.2K", "2K"));
        list.add(new Post(R.drawable.dark, R.drawable.img2, "User Name 2", "Subtitle 2", "11K", "15K"));
        list.add(new Post(R.drawable.electric, R.drawable.img3, "User Name 3", "Subtitle 3", "17K", "30K"));
        list.add(new Post(R.drawable.ghost, R.drawable.img4, "User Name 4", "Subtitle 4", "1.5K", "3K"));
        list.add(new Post(R.drawable.flying, R.drawable.img5, "User Name 5", "Subtitle 5", "3.6K", "4K"));
        list.add(new Post(R.drawable.dragon, R.drawable.img6, "User Name 6", "Subtitle 6", "570", "1K"));
        list.add(new Post(R.drawable.electric, R.drawable.img7, "User Name 7", "Subtitle 7", "10K", "15K"));

        return list;
    }
}