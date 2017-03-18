package com.example.mytom.projectprm391;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.mytom.projectprm391.Adapter.ViewPaperAdapter;

/**
 * Created by Mytom on 3/7/2017.
 */

public class HomeActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {
    private TabLayout tabLayout;
    private Toolbar toolbar;
    //This is our viewPager
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Adding toolbar to the activity



        //Initializing the tablayout
        tabLayout = (TabLayout) findViewById(R.id.tablayout_home);

//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //Adding the tabs using addTab() method
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.getTabAt(0).setIcon(getResources().getDrawable(R.drawable.exam_icon));
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.getTabAt(1).setIcon(getResources().getDrawable(R.drawable.history_icon));
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.getTabAt(2).setIcon(getResources().getDrawable(R.drawable.sesstion_icon));
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.getTabAt(3).setIcon(getResources().getDrawable(R.drawable.add_icon));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //Initializing viewPager
        viewPager = (ViewPager) findViewById(R.id.viewpaper_home);

        //Creating our pager adapter
        ViewPaperAdapter adapter = new ViewPaperAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        //Adding adapter to pager
        viewPager.setAdapter(adapter);

        //Adding onTabSelectedListener to swipe views
        tabLayout.setOnTabSelectedListener(this);
//        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
