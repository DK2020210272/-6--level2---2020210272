package com.example.level2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import fragment.BlankFragment;

public class TabLayoutDemoActivity extends AppCompatActivity {

    private String[]tabs={"页面1","页面2","页面3"};
    private List<BlankFragment>blankFragmentList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout_demo);
        TabLayout tabLayout=findViewById(R.id.tl_tab_layout);
        ViewPager viewPager=findViewById(R.id.vp_tab_layout);
        for(int i=0;i<tabs.length;i++){
            tabLayout.addTab(tabLayout.newTab().setText(tabs[i]));
            blankFragmentList.add(BlankFragment.newInstance(tabs[i]));
        }
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager(),FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return blankFragmentList.get(position);
            }

            @Override
            public int getCount() {
                return blankFragmentList.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return tabs[position];
            }
        });
        tabLayout.setupWithViewPager(viewPager,false);
    }
}