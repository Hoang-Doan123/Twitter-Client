package com.example.twitterclient.community_section;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.twitterclient.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MyCommunitiesFragment extends Fragment {

    private View view;
    private TabLayout tabLayoutTop, tabLayoutBot;
    private FloatingActionButton addFab;

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private MyCommunitiesPostAdapter myCommunitiesPostAdapterAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_my_communities, container, false);

        tabLayoutBot = getActivity().findViewById(R.id.tab_layout_bot);

        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh_layout_my_communities);
        recyclerView = view.findViewById(R.id.recycler_view_my_communities);
        addFab = getActivity().findViewById(R.id.add_fab);

        myCommunitiesPostAdapterAdapter = new MyCommunitiesPostAdapter();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        myCommunitiesPostAdapterAdapter.setData(getListCommunitiesPost());
        recyclerView.setAdapter(myCommunitiesPostAdapterAdapter);

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
        List<MyCommunitiesPost> newData = getListCommunitiesPost();
        myCommunitiesPostAdapterAdapter.setData(newData);
        myCommunitiesPostAdapterAdapter.notifyDataSetChanged();
    }

    private List<MyCommunitiesPost> getListCommunitiesPost() {
        List<MyCommunitiesPost> list = new ArrayList<>();
        list.add(new MyCommunitiesPost(R.drawable.dragon, "Apple", "10M Members", "Technology"));
        list.add(new MyCommunitiesPost(R.drawable.dark, "Software Engineering", "5M Members", "Software"));
        list.add(new MyCommunitiesPost(R.drawable.electric, "Xbox Community", "1M Members", "Gaming"));
        list.add(new MyCommunitiesPost(R.drawable.dragon, "Apple", "10M Members", "Technology"));
        list.add(new MyCommunitiesPost(R.drawable.dark, "Software Engineering", "5M Members", "Software"));
        list.add(new MyCommunitiesPost(R.drawable.electric, "Xbox Community", "1M Members", "Gaming"));


        return list;
    }
}