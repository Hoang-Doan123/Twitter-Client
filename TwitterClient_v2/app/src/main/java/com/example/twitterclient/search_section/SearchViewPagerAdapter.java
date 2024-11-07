package com.example.twitterclient.search_section;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.twitterclient.home_section.FollowingFragment;
import com.example.twitterclient.home_section.ForYouFragment;

public class SearchViewPagerAdapter extends FragmentStatePagerAdapter {
    public SearchViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return new SearchForYouFragment();
            case 1: return new SearchTrendingFragment();
            case 2: return new SearchNewsFragment();
            case 3: return new SearchSportFragment();
            case 4: return new SearchEntertainmentFragment();
            default: return new SearchForYouFragment();
        }
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0: return "For You";
            case 1: return "Trending";
            case 2: return "News";
            case 3: return "Sport";
            case 4: return "Entertainment";
            default: return "For You";
        }
    }
}
