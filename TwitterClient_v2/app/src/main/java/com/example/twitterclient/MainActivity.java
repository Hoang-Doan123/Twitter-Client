package com.example.twitterclient;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.android.car.ui.toolbar.Tab;
import com.example.twitterclient.community_section.CommunityFragment;
import com.example.twitterclient.drawer_fragments.BookmarksFragment;
import com.example.twitterclient.drawer_fragments.ProfileFragment;
import com.example.twitterclient.email_section.EmailFragment;
import com.example.twitterclient.home_section.HomeFragment;
import com.example.twitterclient.notification_section.NotificationFragment;
import com.example.twitterclient.search_section.SearchFragment;
import com.example.twitterclient.slash_section.SlashFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private View overlay;
    private Toolbar toolbar;
    private FloatingActionButton addFab, imgFab, microFab, videocamFab;
    private TextView imgFabText, microFabText, videocamFabText, addPostFabText;
    private Boolean isFabVisible = false;
    private TabLayout tabLayoutBot;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.tool_bar);
        tabLayoutBot = findViewById(R.id.tab_layout_bot);
        overlay = findViewById(R.id.overlay);

        addFab = findViewById(R.id.add_fab);
        imgFab = findViewById(R.id.img_fab);
        microFab = findViewById(R.id.micro_fab);
        videocamFab = findViewById(R.id.videocam_fab);

        addPostFabText = findViewById(R.id.add_post_fab_text);
        imgFabText = findViewById(R.id.img_fab_text);
        microFabText = findViewById(R.id.micro_fab_text);
        videocamFabText = findViewById(R.id.videocam_fab_text);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);

        // Thay đổi màu biểu tượng
        ColorStateList iconColorStateList = new ColorStateList(
                new int[][]{
                        new int[]{android.R.attr.state_selected}, // Trạng thái được chọn
                        new int[]{}                               // Trạng thái không được chọn
                },
                new int[]{
                        Color.parseColor("#e6e6e6"), // Màu đỏ khi được chọn
                        Color.parseColor("#4d4d4d")  // Màu xám khi không được chọn
                }
        );

        tabLayoutBot.setTabIconTint(iconColorStateList);

// Thay đổi màu gạch chân
        tabLayoutBot.setSelectedTabIndicatorColor(Color.parseColor("#ffffff")); // Màu đỏ cho gạch chân

//        setSupportActionBar(toolbar);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.app_OpenDrawer,R.string.app_CloseDrawer);
//        drawerLayout.addDrawerListener(toggle);
//        toggle.syncState();

        // Handle Navigation Item Clicks
        navigationView.setNavigationItemSelectedListener(item -> {
            Fragment fragment;
            if (item.getItemId() == R.id.Profile) {
                fragment = new ProfileFragment();
            }
//            else if (item.getItemId() == R.id.Jobs) {
//                fragment = new JobsFragment();
//            }
//            else if (item.getItemId() == R.id.Premium) {
//                fragment = new PremiumFragment();
//            }
            else if (item.getItemId() == R.id.Bookmarks) {
                fragment = new BookmarksFragment();
            }
//            else if (item.getItemId() == R.id.Lists) {
//                fragment = new ListsFragment();
//            }
//            else if (item.getItemId() == R.id.Spaces) {
//                fragment = new SpacesFragment();
//            }
//            else if (item.getItemId() == R.id.Monetization) {
//                fragment = new MonetizationFragment();
//            }
            else {
                fragment = new Fragment();
            }

            replaceFragment(fragment);
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });

        tabLayoutBot.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment;
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new HomeFragment();
                        break;
                    case 1:
                        fragment = new SearchFragment();
                        break;
                    case 2:
                        fragment = new SlashFragment();
                        break;
                    case 3:
                        fragment = new CommunityFragment();
                        break;
                    case 4:
                        fragment = new NotificationFragment();
                        break;
                    case 5:
                        fragment = new EmailFragment();
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
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new HomeFragment())
                    .commit();
        }

        addFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isFabVisible) {
                    overlay.setVisibility(View.VISIBLE);
                    addFab.setImageResource(R.drawable.add_post_icon);
                    addPostFabText.setVisibility(View.VISIBLE);
                    imgFab.setVisibility(View.VISIBLE);
                    imgFabText.setVisibility(View.VISIBLE);
                    microFab.setVisibility(View.VISIBLE);
                    microFabText.setVisibility(View.VISIBLE);
                    videocamFab.setVisibility(View.VISIBLE);
                    videocamFabText.setVisibility(View.VISIBLE);
                    isFabVisible = true;
                }
//                else {
//                    addFab.setImageResource(R.drawable.adding_icon);
//                    addPostFabText.setVisibility(View.GONE);
//                    imgFab.setVisibility(View.GONE);
//                    imgFabText.setVisibility(View.GONE);
//                    microFab.setVisibility(View.GONE);
//                    microFabText.setVisibility(View.GONE);
//                    videocamFab.setVisibility(View.GONE);
//                    videocamFabText.setVisibility(View.GONE);
//                    isFabVisible = false;
//                }
            }
        });

        overlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isFabVisible) {
                    overlay.setVisibility(View.GONE);
                    addFab.setImageResource(R.drawable.adding_icon);
                    addPostFabText.setVisibility(View.GONE);
                    imgFab.setVisibility(View.GONE);
                    imgFabText.setVisibility(View.GONE);
                    microFab.setVisibility(View.GONE);
                    microFabText.setVisibility(View.GONE);
                    videocamFab.setVisibility(View.GONE);
                    videocamFabText.setVisibility(View.GONE);
                    isFabVisible = false;
                }
            }
        });
    }
    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }

    // Method to open the Drawer
    public void openDrawer() {
        if (drawerLayout != null) {
            drawerLayout.openDrawer(GravityCompat.START);
        }
    }

    // Method to close the Drawer (optional)
    public void closeDrawer() {
        if (drawerLayout != null && drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }
}