package Community_tablayout;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class CommunityViewPagerAdapter extends FragmentStatePagerAdapter {

    private Context context;
    public CommunityViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return new tab1_community();
            case 1: return new tab2_community();
            default: return new tab1_community();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case  0:
                return "My Communities";
            case  1:
                return "Explore";
            default:
                return "My Communities";


        }
    }
}


