package com.turorials.onetimeactivity.pagerAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.turorials.onetimeactivity.fragment.CheatSheetFragment;
import com.turorials.onetimeactivity.fragment.OriginalWebsitesFragment;

public class ExtraPagerAdapter extends FragmentStatePagerAdapter {
    public ExtraPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 1:
                return new OriginalWebsitesFragment();
            case 0:
            default:
                return new CheatSheetFragment();
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
                return "Official Websites";
            case 0:
            default:
                return "Cheat Sheets";

        }
    }
}
