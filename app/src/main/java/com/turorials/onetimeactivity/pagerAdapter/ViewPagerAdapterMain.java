package com.turorials.onetimeactivity.pagerAdapter;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.turorials.onetimeactivity.UserProfile;
import com.turorials.onetimeactivity.fragment.CodeWallLessonsPageFragment;
import com.turorials.onetimeactivity.fragment.BlogPagerFragment;
import com.turorials.onetimeactivity.fragment.Online_Class_Fragment;
import com.turorials.onetimeactivity.fragment.ExtraInfoPagerFragment;

public class ViewPagerAdapterMain extends FragmentStatePagerAdapter {


    public ViewPagerAdapterMain(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 1:
                return new Online_Class_Fragment();
            case 2:
                return new BlogPagerFragment();
            case 3:
                return new ExtraInfoPagerFragment();
            case 4:
                return new UserProfile();
            case 0:
            default:
               return new CodeWallLessonsPageFragment();
        }

    }

    @Override
    public int getCount() {
        return 5;
    }
}
