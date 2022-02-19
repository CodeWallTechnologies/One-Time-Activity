package com.turorials.onetimeactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.turorials.onetimeactivity.pagerAdapter.ViewPagerAdapterMain;

public class MainActivity2 extends AppCompatActivity {


    BottomNavigationView navigationView;
    ViewPager viewPagerMain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().hide();

        navigationView = findViewById(R.id.bottom_nav);
        viewPagerMain = findViewById(R.id.view_pager_main);

        ViewPagerAdapterMain viewPagerAdapterMain = new ViewPagerAdapterMain(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
       viewPagerMain.setAdapter(viewPagerAdapterMain);

       viewPagerMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
           @Override
           public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

           }

           @Override
           public void onPageSelected(int position) {
               switch (position){
                   case 0:
                       navigationView.getMenu().findItem(R.id.home).setChecked(true);
                       break;
                   case 1:
                       navigationView.getMenu().findItem(R.id.lessons).setChecked(true);
                       break;
                   case 2:
                       navigationView.getMenu().findItem(R.id.blogs).setChecked(true);
                       break;
                   case 3:
                       navigationView.getMenu().findItem(R.id.tips).setChecked(true);
                       break;

               }
           }

           @Override
           public void onPageScrollStateChanged(int state) {

           }
       });


        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        viewPagerMain.setCurrentItem(0);
                        break;
                    case R.id.lessons:
                        viewPagerMain.setCurrentItem(1);
                        break;
                    case  R.id.blogs:
                        viewPagerMain.setCurrentItem(2);
                        break;
                    case  R.id.tips:
                        viewPagerMain.setCurrentItem(3);
                        break;

                }
                return true;
            }
        });


    }



}