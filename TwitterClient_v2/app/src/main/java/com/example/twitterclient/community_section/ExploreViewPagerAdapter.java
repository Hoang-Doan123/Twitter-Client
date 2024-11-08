package com.example.twitterclient.community_section;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ExploreViewPagerAdapter extends FragmentStatePagerAdapter {
    public ExploreViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return new ExploreFoodFragment();
            case 1: return new ExploreAnimalFragment();
            case 2: return new ExploreTechFragment();
            case 3: return new ExploreGamingFragment();
            case 4: return new ExploreSportsFragment();
            case 5: return new ExploreArtFragment();
            default: return new ExploreFoodFragment();
        }
    }

    @Override
    public int getCount() {return 6;}

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0: return "Food";
            case 1: return "Animal";
            case 2: return "Tech";
            case 3: return "Gaming";
            case 4: return "Sports";
            case 5: return "Art";
            default: return "Food";
        }
    }
}
