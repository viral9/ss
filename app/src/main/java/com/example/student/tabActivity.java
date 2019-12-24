package com.example.student;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.student.ui.first.FirstFragment;
import com.example.student.ui.secound.SecoundFragment;
import com.google.android.material.tabs.TabLayout;

public class tabActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager  viewPager;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        viewPager = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tabLayout);
        //toolbar = findViewById(R.id.toolbar2);
        //setSupportActionBar(toolbar);
        tabLayout.addTab(tabLayout.newTab().setText("first"));
        tabLayout.addTab(tabLayout.newTab().setText("second"));
        //tabLayout.addTab(tabLayout.newTab().setText("main"));

        //setTitle("tab view");

        final pageAdapter adapter = new pageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        /*tabLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(tabActivity.this, "it is clickable", Toast.LENGTH_SHORT).show();
                /*Fragment f ;
                f = adapter.getItem(0);
                viewPager.setCurrentItem(0);
            }
        });*/
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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
        });
        /*tabLayout.setupWithViewPager(viewPager);
        //setupViewPager(viewPager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new FirstFragment(),"first");
        viewPagerAdapter.addFragment(new SecoundFragment(),"second");
        viewPagerAdapter.getItem(0);

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //Intent i = new Intent(tabActivity.this,FirstFragment.class);
                //startActivity(i);
                viewPager.getCurrentItem();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                viewPager.getCurrentItem();

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });*/

    }

    private void setSupportActionBar(Toolbar toolbar) {

    }
    /*public void setupViewPager(ViewPager viewPager)  {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new FirstFragment(),"first");
        viewPagerAdapter.addFragment(new SecoundFragment(),"second");
        viewPagerAdapter.getItem(0);

        viewPager.setAdapter(viewPagerAdapter);

    }*/
}

