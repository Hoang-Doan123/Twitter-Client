package com.example.twitterclient;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.twitterclient.community_section.CommunityFragment;
import com.example.twitterclient.email_section.EmailFragment;
import com.example.twitterclient.home_section.HomeFragment;
import com.example.twitterclient.notification_section.NotificationFragment;
import com.example.twitterclient.search_section.SearchFragment;
import com.example.twitterclient.slash_section.SlashFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return new HomeFragment();
            case 1: return new SearchFragment();
            case 2: return new SlashFragment();
            case 3: return new CommunityFragment();
            case 4: return new NotificationFragment();
            case 5: return new EmailFragment();
            default: return new HomeFragment();
        }
    }

    @Override
    public int getCount() {
        return 6;
    }
}