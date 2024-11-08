package com.example.twitterclient.search_section;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import com.example.twitterclient.MainActivity;
import com.example.twitterclient.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class SearchFragment extends Fragment {

    private View view;
    private ViewPager viewPager;
    private TabLayout tabLayoutTop;
    private Toolbar toolbar;
    private FloatingActionButton addFab;

    private ImageView accountIcon;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_search, container, false);
        toolbar = getActivity().findViewById(R.id.tool_bar);
        tabLayoutTop = view.findViewById(R.id.search_tab_layout_top);
        viewPager = view.findViewById(R.id.search_view_pager);
        addFab = getActivity().findViewById(R.id.add_fab);
        accountIcon = getActivity().findViewById(R.id.account_icon);

        // Add adapter to viewpager
        SearchViewPagerAdapter adapter = new SearchViewPagerAdapter(getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);
        tabLayoutTop.setupWithViewPager(viewPager);

        accountIcon.setOnClickListener(v -> {
            if (getActivity() instanceof MainActivity) {
                ((MainActivity) getActivity()).openDrawer();
            }
        });

        toolbar.setVisibility(View.VISIBLE);
        addFab.setVisibility(View.VISIBLE);

        return view;
    }
}