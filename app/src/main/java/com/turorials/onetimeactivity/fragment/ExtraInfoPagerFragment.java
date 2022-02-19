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
import com.turorials.onetimeactivity.pagerAdapter.ExtraPagerAdapter;

public class ExtraInfoPagerFragment extends Fragment {
   // private ViewPagerAdapter viewPagerAdapter;
    private ViewPager viewPager1;
    private TabLayout tabLayout1;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.fragment_extra_info_pager,container,false);
        viewPager1 = view.findViewById(R.id.viewpager1);
        tabLayout1 = view.findViewById(R.id.tab_layout1);

        ExtraPagerAdapter extraPagerAdapter = new ExtraPagerAdapter(getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager1.setAdapter(extraPagerAdapter);

        tabLayout1.setupWithViewPager(viewPager1);

        return view;
    }

}