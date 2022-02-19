package com.turorials.onetimeactivity.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.turorials.onetimeactivity.R;
import com.turorials.onetimeactivity.pagerAdapter.BlogPagerAdapter;

public class BlogPagerFragment extends Fragment {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private  View view;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



         view = inflater.inflate(R.layout.fragment_blog_pager,container,false);
        viewPager = view.findViewById(R.id.new_feed_viewpager);

        // setting up the adapter
        BlogPagerAdapter blogPagerAdapter = new BlogPagerAdapter(getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(blogPagerAdapter);


        // The Page (fragment) titles will be displayed in the
        // tabLayout hence we need to  set the page viewer
        // we use the setupWithViewPager().
        tabLayout = view.findViewById(R.id.tab_layout);


        tabLayout.setupWithViewPager(viewPager);
        return view;
    }


//
//    }
}