package com.example.twitterclient.email_section;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.twitterclient.R;
import com.example.twitterclient.search_section.SearchPost;
import com.example.twitterclient.search_section.SearchPostAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class EmailFragment extends Fragment {

    private View view;
    private Toolbar toolbar;
    private TabLayout tabLayoutBot;
    private FloatingActionButton addFab, emailFab;

    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private EmailPostAdapter emailPostAdapter;
    private EmailDirectMessagesFragment emailDirectMessagesFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_email, container, false);

        toolbar = getActivity().findViewById(R.id.tool_bar);
        tabLayoutBot = getActivity().findViewById(R.id.tab_layout_bot);

        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh_layout_email);
        recyclerView = view.findViewById(R.id.recycler_view_email);

        addFab = getActivity().findViewById(R.id.add_fab);
        emailFab = view.findViewById(R.id.email_fab);

        emailPostAdapter = new EmailPostAdapter();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        emailPostAdapter.setData(getListEmailPost());
        recyclerView.setAdapter(emailPostAdapter);

        toolbar.setVisibility(View.GONE);
        addFab.setVisibility(View.GONE);

        emailFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EmailDirectMessagesFragment emailDirectMessagesFragment = new EmailDirectMessagesFragment();
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, emailDirectMessagesFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

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
                    emailFab.hide();
                } else {
                    tabLayoutBot.setVisibility(View.VISIBLE);
                    emailFab.show();
                }
                super.onScrolled(recyclerView, dx, dy);
            }
        });
        return view;
    }

    private void refreshData() {
        List<EmailPost> newData = getListEmailPost();
        emailPostAdapter.setData(newData);
        emailPostAdapter.notifyDataSetChanged();
    }

    private List<EmailPost> getListEmailPost() {
        List<EmailPost> list = new ArrayList<>();
        list.add(new EmailPost(R.drawable.dragon, "User1", "@user1", "12/2/19", "aaaaaaaaaaaaaaaaa"));
        list.add(new EmailPost(R.drawable.dragon, "User1", "@user1", "12/2/19", "aaaaaaaaaaaaaaaaa"));
        list.add(new EmailPost(R.drawable.dragon, "User1", "@user1", "12/2/19", "aaaaaaaaaaaaaaaaa"));
        list.add(new EmailPost(R.drawable.dragon, "User1", "@user1", "12/2/19", "aaaaaaaaaaaaaaaaa"));
        list.add(new EmailPost(R.drawable.dragon, "User1", "@user1", "12/2/19", "aaaaaaaaaaaaaaaaa"));
        list.add(new EmailPost(R.drawable.dragon, "User1", "@user1", "12/2/19", "aaaaaaaaaaaaaaaaa"));
        list.add(new EmailPost(R.drawable.dragon, "User1", "@user1", "12/2/19", "aaaaaaaaaaaaaaaaa"));
        list.add(new EmailPost(R.drawable.dragon, "User1", "@user1", "12/2/19", "aaaaaaaaaaaaaaaaa"));
        list.add(new EmailPost(R.drawable.dragon, "User1", "@user1", "12/2/19", "aaaaaaaaaaaaaaaaa"));
        list.add(new EmailPost(R.drawable.dragon, "User1", "@user1", "12/2/19", "aaaaaaaaaaaaaaaaa"));
        list.add(new EmailPost(R.drawable.dragon, "User1", "@user1", "12/2/19", "aaaaaaaaaaaaaaaaa"));


        return list;
    }


}