package vn.edu.usth.usth.twitterclient;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class TwitterClient extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("ID", "onStart");
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_twitter_client);

        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.view_pager);


        //Set up viewPager with adapter
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mViewPager.setAdapter(viewPagerAdapter);

        //Tablayout
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        mTabLayout.getTabAt(1).setIcon(R.drawable.ic_search);
        mTabLayout.getTabAt(2).setIcon(R.drawable.ic_slash);
        mTabLayout.getTabAt(3).setIcon(R.drawable.ic_friend);
        mTabLayout.getTabAt(4).setIcon(R.drawable.ic_notification);
        mTabLayout.getTabAt(5).setIcon(R.drawable.ic_mail);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        //Create a new Fragment to be placed in the activity
        ClientFragment FirstFragment = new ClientFragment();

        //Add the fragment to the 'container' FrameLayout
        getSupportFragmentManager().beginTransaction().add(
                R.id.container, FirstFragment).commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ID", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ID", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ID", "onPause");
    }

    @Override
    protected  void onStop() {
        super.onStop();
        Log.i("ID", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ID", "onDestroy");
    }
}