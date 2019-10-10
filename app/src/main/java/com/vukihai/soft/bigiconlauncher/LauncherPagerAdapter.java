package com.vukihai.soft.bigiconlauncher;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import com.vukihai.soft.bigiconlauncher.widget.FirstPageFragment;
import com.vukihai.soft.bigiconlauncher.widget.MyWidget;

import java.util.List;

public class LauncherPagerAdapter extends FragmentStatePagerAdapter {
    public LauncherPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new FirstPageFragment();
    }

    @Override
    public int getCount() {
        return 3+2;
    }
}
