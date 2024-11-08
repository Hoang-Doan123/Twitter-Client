package com.example.twitterclient.notification_section;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;

import com.example.twitterclient.MainActivity;
import com.example.twitterclient.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class NotificationFragment extends Fragment {

    private View view;
    private ViewPager viewPager;
    private TabLayout tabLayoutTop;
    private FloatingActionButton addFab;
    private ImageView moreIcon, notificationAccountIcon;
    private Toolbar toolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_notification, container, false);

        toolbar = getActivity().findViewById(R.id.tool_bar);
        tabLayoutTop = view.findViewById(R.id.notification_tab_layout_top);
        viewPager = view.findViewById(R.id.notification_view_pager);
        addFab = getActivity().findViewById(R.id.add_fab);
        notificationAccountIcon = view.findViewById(R.id.notification_account_icon);
        moreIcon = view.findViewById(R.id.notification_more_icon);

        // Add adapter to viewpager
        NotificationViewPagerAdapter adapter = new NotificationViewPagerAdapter(getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);
        tabLayoutTop.setupWithViewPager(viewPager);

        notificationAccountIcon.setOnClickListener(v -> {
            if (getActivity() instanceof MainActivity) {
                ((MainActivity) getActivity()).openDrawer();
            }
        });

        toolbar.setVisibility(View.GONE);
        addFab.setVisibility(View.VISIBLE);

        moreIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationSettingFragment notificationSettingFragment = new NotificationSettingFragment();
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, notificationSettingFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return view;
    }
}