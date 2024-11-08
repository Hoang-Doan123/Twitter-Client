package com.example.twitterclient.email_section;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.twitterclient.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import android.graphics.Color;

public class EmailDirectMessagesFragment extends Fragment {

    private View view;
    private Toolbar toolbar;
    private TabLayout tabLayoutBot;
    private FloatingActionButton addFab, emailFab;
    private ImageView arrowBackIcon;

    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private EmailDirectMessagesPostAdapter emailDirectMessagesPostAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_email_direct_messages, container, false);
        tabLayoutBot = getActivity().findViewById(R.id.tab_layout_bot);
        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh_layout_email_direct_mess);
        recyclerView = view.findViewById(R.id.recycler_view_email_direct_mess);

//        SearchView searchView = view.findViewById(R.id.direct_messages_search_view);

//        ImageView searchIcon = searchView.findViewById(androidx.appcompat.R.id.search_mag_icon);
//        searchIcon.setColorFilter(Color.WHITE); // Đổi màu icon kính lúp
//        searchIcon.getLayoutParams().height = 60; // Thay đổi chiều cao của icon
//        searchIcon.getLayoutParams().width = 60;
        addFab = getActivity().findViewById(R.id.add_fab);
        emailFab = view.findViewById(R.id.email_fab);
        arrowBackIcon = view.findViewById(R.id.email_direct_mess_arrow_back_icon);

        emailDirectMessagesPostAdapter = new EmailDirectMessagesPostAdapter();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        emailDirectMessagesPostAdapter.setData(getListEmailDirectMessagesPost());
        recyclerView.setAdapter(emailDirectMessagesPostAdapter);

//        tabLayoutBot.setVisibility(View.GONE);
        addFab.setVisibility(View.GONE);

        arrowBackIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().getSupportFragmentManager().popBackStack();
            }
        });

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshData();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
        return view;
    }

    private void refreshData() {
        List<EmailDirectMessagesPost> newData = getListEmailDirectMessagesPost();
        emailDirectMessagesPostAdapter.setData(newData);
        emailDirectMessagesPostAdapter.notifyDataSetChanged();
    }

    private List<EmailDirectMessagesPost> getListEmailDirectMessagesPost() {
        List<EmailDirectMessagesPost> list = new ArrayList<>();
        list.add(new EmailDirectMessagesPost(R.drawable.dark, "User1", "@user1"));
        list.add(new EmailDirectMessagesPost(R.drawable.flying, "User2", "@user2"));

        return list;
    }
}