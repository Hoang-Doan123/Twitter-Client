package com.example.tablayout;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TableLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayoutBot = findViewById(R.id.tab_layout_bot);
        TabLayout tabLayoutTop = findViewById(R.id.tab_layout_top);
        FrameLayout frameLayout = findViewById(R.id.fragment_container);

        ViewPager viewPager = findViewById(R.id.view_pager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);

        tabLayoutTop.setupWithViewPager(viewPager);

        tabLayoutTop.getTabAt(0).setText("For You");
        tabLayoutTop.getTabAt(1).setText("Following");


        tabLayoutBot.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment;
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new HomeFragment();
                        tabLayoutTop.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        tabLayoutTop.setVisibility(View.GONE);
                        frameLayout.setVisibility(View.VISIBLE);
                        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
                        layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
                        frameLayout.setLayoutParams(layoutParams);
                        fragment = new SearchFragment();
                        break;
                    case 2:
                        fragment = new SlashFragment();
//                        tabLayoutTop.setVisibility(View.GONE);
                        break;
                    case 3:
                        fragment = new CommunityFragment();
                        tabLayoutTop.setVisibility(View.GONE);
                        break;
                    case 4:
                        fragment = new NotificationFragment();
                        tabLayoutTop.setVisibility(View.GONE);
                        break;
                    case 5:
                        fragment = new EmailFragment();
                        tabLayoutTop.setVisibility(View.GONE);
                        break;
                    default:
                        fragment = new HomeFragment();
                        break;
                }
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, fragment);
                transaction.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.fragment_container, new HomeFragment())
//                    .commit();

// TODO: Xem xét việc xóa logic của tab_layout_top ở MainActivity và thêm vào HomeFragment
//        }
    }
}