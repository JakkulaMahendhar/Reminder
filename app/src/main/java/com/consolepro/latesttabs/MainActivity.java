package com.consolepro.latesttabs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;

    private TabAdapter adapter;
    private ViewPager viewPager;
    RelativeLayout rl_topbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            this.tabLayout = findViewById(R.id.tabLayout);
            this.viewPager = findViewById(R.id.viewPager);
            this.rl_topbar = findViewById(R.id.rl_topbar);


            adapter = new TabAdapter(getSupportFragmentManager());
            adapter.addFragment(new FirstFragment(), "Upcoming List");
            adapter.addFragment(new SecondFragment(), "Completed List");

            viewPager.setAdapter(adapter);
            tabLayout.setupWithViewPager(viewPager);

            AnimationDrawable animationDrawable = (AnimationDrawable) rl_topbar.getBackground();
            animationDrawable.setEnterFadeDuration(5);
            animationDrawable.setExitFadeDuration(5000);
            animationDrawable.start();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
