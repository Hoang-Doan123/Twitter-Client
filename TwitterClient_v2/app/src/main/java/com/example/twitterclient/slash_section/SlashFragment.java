package com.example.twitterclient.slash_section;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.twitterclient.MainActivity;
import com.example.twitterclient.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class SlashFragment extends Fragment {

    private View view;
    private TabLayout tabLayoutTop, tabLayoutBot;
    private FloatingActionButton addFab;
    private Toolbar toolbar;
    private SwipeRefreshLayout swipeRefreshLayout;

    private ScrollView scrollView;
    private DrawerLayout drawerLayout;

    private ImageView slashAccountIcon;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_slash, container, false);

        tabLayoutBot = getActivity().findViewById(R.id.tab_layout_bot);
        drawerLayout = getActivity().findViewById(R.id.drawer_layout);
        addFab = getActivity().findViewById(R.id.add_fab);

        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh_layout_slash);
        scrollView = view.findViewById(R.id.scroll_view_main_screen);

        slashAccountIcon = view.findViewById(R.id.slash_account_icon);

        addFab.setVisibility(View.VISIBLE);

        slashAccountIcon.setOnClickListener(v -> {
            if (getActivity() instanceof MainActivity) {
                ((MainActivity) getActivity()).openDrawer();
            }
        });

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY > oldScrollY) {
                    // Người dùng đang cuộn xuống
                    tabLayoutBot.setVisibility(View.INVISIBLE);
                    addFab.hide();
                } else {
                    // Người dùng đang cuộn lên
                    tabLayoutBot.setVisibility(View.VISIBLE);
                    addFab.show();
                }
            }
        });

        return view;
    }
}
