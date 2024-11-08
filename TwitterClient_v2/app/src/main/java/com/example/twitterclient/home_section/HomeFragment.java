package com.example.twitterclient.home_section;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import com.example.twitterclient.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class HomeFragment extends Fragment {

    private View view;
    private ViewPager viewPager;
    private TabLayout tabLayoutTop;
    private FloatingActionButton addFab;
    private Toolbar toolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);

        // Declare views
        toolbar = getActivity().findViewById(R.id.tool_bar);
        tabLayoutTop = view.findViewById(R.id.home_tab_layout_top);
        viewPager = view.findViewById(R.id.home_view_pager);
        addFab = getActivity().findViewById(R.id.add_fab);

        // Add adapter to viewpager
        HomeViewPagerAdapter adapter = new HomeViewPagerAdapter(getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);
        tabLayoutTop.setupWithViewPager(viewPager);

        toolbar.setVisibility(View.VISIBLE);
        addFab.setVisibility(View.VISIBLE);

        return view;
    }
}