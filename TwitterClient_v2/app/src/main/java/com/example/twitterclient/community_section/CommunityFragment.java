package com.example.twitterclient.community_section;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.twitterclient.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class CommunityFragment extends Fragment {

    private View view;
    private ViewPager viewPager;
    private TabLayout tabLayoutTop;
    private Toolbar toolbar;
    private FloatingActionButton addFab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_community, container, false);

        toolbar = getActivity().findViewById(R.id.tool_bar);
        tabLayoutTop = view.findViewById(R.id.community_tab_layout_top);
        viewPager = view.findViewById(R.id.community_view_pager);
        addFab = getActivity().findViewById(R.id.add_fab);

        CommunityViewPagerAdapter adapter = new CommunityViewPagerAdapter(getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);
        tabLayoutTop.setupWithViewPager(viewPager);

        toolbar.setVisibility(View.GONE);
        addFab.setVisibility(View.VISIBLE);
        return view;
    }
}