package vn.edu.usth.usth.twitterclient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();

            case 1:
                return new TrendingFragment();

            case 2:
                return new NewsFragment();

            case 3:
                return new SportFragment();

            case 4:
                return new EntertainmentFragment();

            default:
                return new HomeFragment();
        }
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position) {
            case 0:
                title = "For You";
                break;
            case 1:
                title = "Trending";
                break;
            case 2:
                title = "News";
                break;
            case 3:
                title = "Sport";
                break;
            case 4:
                title = "Entertainment";
                break;
        }
        return title;
   }
}
