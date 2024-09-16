package com.example.tablayout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class HomeFragment extends Fragment {

    private View view;
    private ViewPager viewPager;
    private TabLayout tabLayoutTop;
    private FloatingActionButton addFab, imgFab, microFab, videocamFab;
    private TextView imgFabText, microFabText, videocamFabText;
    private Boolean isFabVisible = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);

        // Declare views
        tabLayoutTop = view.findViewById(R.id.tab_layout_top);
        viewPager = view.findViewById(R.id.home_view_pager);

        addFab = view.findViewById(R.id.add_fab);
        imgFab = view.findViewById(R.id.img_fab);
        microFab = view.findViewById(R.id.micro_fab);
        videocamFab = view.findViewById(R.id.videocam_fab);

        imgFabText = view.findViewById(R.id.img_fab_text);
        microFabText = view.findViewById(R.id.micro_fab_text);
        videocamFabText = view.findViewById(R.id.videocam_fab_text);

        // Add adapter to viewpager
        HomeViewPagerAdapter adapter = new HomeViewPagerAdapter(getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);
        tabLayoutTop.setupWithViewPager(viewPager);

        // Make floating buttons & their text disappear
        imgFab.setVisibility(View.GONE);
        imgFabText.setVisibility(View.GONE);
        microFab.setVisibility(View.GONE);
        microFabText.setVisibility(View.GONE);
        videocamFab.setVisibility(View.GONE);
        videocamFabText.setVisibility(View.GONE);

        // Add onClick event for addFab
        addFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isFabVisible) {
                    addFab.setImageResource(R.drawable.add_post_icon);
                    imgFab.setVisibility(View.VISIBLE);
                    imgFabText.setVisibility(View.VISIBLE);
                    microFab.setVisibility(View.VISIBLE);
                    microFabText.setVisibility(View.VISIBLE);
                    videocamFab.setVisibility(View.VISIBLE);
                    videocamFabText.setVisibility(View.VISIBLE);
                    isFabVisible = true;
                }
                else {
                    addFab.setImageResource(R.drawable.adding_icon);
                    imgFab.setVisibility(View.GONE);
                    imgFabText.setVisibility(View.GONE);
                    microFab.setVisibility(View.GONE);
                    microFabText.setVisibility(View.GONE);
                    videocamFab.setVisibility(View.GONE);
                    videocamFabText.setVisibility(View.GONE);
                    isFabVisible = false;
                }
            }
        });

        return view;
    }
}