package com.example.twitterclient.notification_section;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class NotificationViewPagerAdapter extends FragmentStatePagerAdapter {
    public NotificationViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return new NotificationAllFragment();
            case 1: return new NotificationVerifiedFragment();
            case 2: return new NotificationMentionsFragment();
            default: return new NotificationAllFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0: return "All";
            case 1: return "Verified";
            case 2: return "Mentions";
            default: return "All";
        }
    }
}
