package com.example.tablayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class SearchViewPagerAdapter extends FragmentStatePagerAdapter {

    public SearchViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return new ForYou2Fragment();
            case 1: return new TrendingFragment();
            case 2: return new NewsFragment();
            case 3: return new SportFragment();
            case 4: return new EntertainmentFragment();
            default: return new ForYouFragment();
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
