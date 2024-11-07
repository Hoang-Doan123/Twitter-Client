package com.example.twitterclient.community_section;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class CommunityViewPagerAdapter extends FragmentStatePagerAdapter {
    public CommunityViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return new MyCommunitiesFragment();
            case 1: return new ExploreFragment();
            default: return new MyCommunitiesFragment();
        }
    }

    @Override
    public int getCount() {return 2;}

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0: return "My Communities";
            case 1: return "Explore";
            default: return "My Communities";
        }
    }
}
