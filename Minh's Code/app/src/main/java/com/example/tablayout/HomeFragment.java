package com.example.tablayout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import android.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class HomeFragment extends Fragment {

    private View view, overlay;
    private ViewPager viewPager;
    private TabLayout tabLayoutTop;
    private FloatingActionButton addFab, imgFab, microFab, videocamFab;
    private TextView imgFabText, microFabText, videocamFabText, addPostFabText;
    private Boolean isFabVisible = false;

    private TabLayout tabLayoutBot;
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private PostAdapter postAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);

        // Declare views
        overlay = getActivity().findViewById(R.id.overlay);
        tabLayoutTop = view.findViewById(R.id.tab_layout_top);
        viewPager = view.findViewById(R.id.home_view_pager);

        addFab = getActivity().findViewById(R.id.add_fab);
        imgFab = getActivity().findViewById(R.id.img_fab);
        microFab = getActivity().findViewById(R.id.micro_fab);
        videocamFab = getActivity().findViewById(R.id.videocam_fab);

        addPostFabText = getActivity().findViewById(R.id.add_post_fab_text);
        imgFabText = getActivity().findViewById(R.id.img_fab_text);
        microFabText = getActivity().findViewById(R.id.micro_fab_text);
        videocamFabText = getActivity().findViewById(R.id.videocam_fab_text);

        // Add adapter to viewpager
        HomeViewPagerAdapter adapter = new HomeViewPagerAdapter(getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);
        tabLayoutTop.setupWithViewPager(viewPager);

        addFab.setVisibility(View.VISIBLE);

        // Make floating buttons & their text disappear
//        addPostFabText.setVisibility(View.GONE);
//        imgFab.setVisibility(View.GONE);
//        imgFabText.setVisibility(View.GONE);
//        microFab.setVisibility(View.GONE);
//        microFabText.setVisibility(View.GONE);
//        videocamFab.setVisibility(View.GONE);
//        videocamFabText.setVisibility(View.GONE);

        // Add onClick event for addFab
        addFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isFabVisible) {
                    overlay.setVisibility(View.VISIBLE);
                    addFab.setImageResource(R.drawable.add_post_icon);
                    addPostFabText.setVisibility(View.VISIBLE);
                    imgFab.setVisibility(View.VISIBLE);
                    imgFabText.setVisibility(View.VISIBLE);
                    microFab.setVisibility(View.VISIBLE);
                    microFabText.setVisibility(View.VISIBLE);
                    videocamFab.setVisibility(View.VISIBLE);
                    videocamFabText.setVisibility(View.VISIBLE);
                    isFabVisible = true;
                }
//                else {
//                    addFab.setImageResource(R.drawable.adding_icon);
//                    addPostFabText.setVisibility(View.GONE);
//                    imgFab.setVisibility(View.GONE);
//                    imgFabText.setVisibility(View.GONE);
//                    microFab.setVisibility(View.GONE);
//                    microFabText.setVisibility(View.GONE);
//                    videocamFab.setVisibility(View.GONE);
//                    videocamFabText.setVisibility(View.GONE);
//                    isFabVisible = false;
//                }
            }
        });

        overlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isFabVisible) {
                    overlay.setVisibility(View.GONE);
                    addFab.setImageResource(R.drawable.adding_icon);
                    addPostFabText.setVisibility(View.GONE);
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