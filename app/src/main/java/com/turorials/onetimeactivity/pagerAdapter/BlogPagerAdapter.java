package com.turorials.onetimeactivity.pagerAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.turorials.onetimeactivity.fragment.OurBlogFragment;
import com.turorials.onetimeactivity.fragment.DailyBlogFragment;

public class BlogPagerAdapter extends FragmentStatePagerAdapter {


    public BlogPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 1:
                return new OurBlogFragment();
            case 0:
            default:
                return new DailyBlogFragment();
        }

    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 1:
                return "Our Blogs";
            case 0:
            default:
                return "Daily Blogs";
        }

    }
}
