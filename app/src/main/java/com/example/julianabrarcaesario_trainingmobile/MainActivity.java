package com.example.julianabrarcaesario_trainingmobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    TextView username;
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    PageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.tv_username);
        tabLayout = findViewById(R.id.tab_layout);
        viewPager2 = findViewById(R.id.view_pager);


        setViewPager2(viewPager2);

        new TabLayoutMediator(tabLayout, viewPager2, ((tab, position) -> {
            tab.setText(pageAdapter.getFragmentTitle(position));
        })).attach();
    }

    private void setViewPager2(ViewPager2 viewPager2){
        if(pageAdapter == null){
            pageAdapter = new PageAdapter(this);
            pageAdapter.addFragment(new HomeFragment(), "Home");
            pageAdapter.addFragment(new SecondFragment(),"Content");
            viewPager2.setAdapter(pageAdapter);

        }
    }
}