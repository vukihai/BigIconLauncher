package com.vukihai.soft.bigiconlauncher;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.vukihai.soft.bigiconlauncher.list_app.ListActivity;
import com.vukihai.soft.bigiconlauncher.setting.Config;
import com.vukihai.soft.bigiconlauncher.setting.SettingActivity;
import com.vukihai.soft.bigiconlauncher.utils.DefaultLauncherSetter;
import com.vukihai.soft.bigiconlauncher.widget.FirstPageFragment;

public class LauncherActivity extends AppCompatActivity implements FirstPageFragment.OnFragmentInteractionListener {
    public final String TAG = "Launcher activity";
    public final Config config = Config.getInstance();
    ViewPager viewPager;
    LauncherPagerAdapter pagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        config.loadConfig(this);
        if(config.isWallpaperEnable())
            setTheme(R.style.Wallpaper);
        else
            setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_launcher);
        getSupportActionBar().hide();

        if(!isMyAppLauncherDefault())
            new DefaultLauncherSetter(this).launchHomeOrClearDefaultsDialog();

        /**
         * for test only
         */
        viewPager = findViewById(R.id.view_pager_main_launcher);
        pagerAdapter = new LauncherPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(1,false);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            Boolean first = false;
            Boolean last = false;

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
            {}

            @Override
            public void onPageSelected(int position)
            {
                if (position == 0)
                {
                    first = true;
                    last = false;
                }
                else if (position ==4)
                {
                    first = false;
                    last = true;
                }
                else
                {
                    first = false;
                    last = false;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state)
            {
                if (first && state == ViewPager.SCROLL_STATE_IDLE)
                {
                    viewPager.setCurrentItem(3,false);
                }
                if(last && state == ViewPager.SCROLL_STATE_IDLE)
                {
                    viewPager.setCurrentItem(1,false);
                }
            }
        });
        Button b = findViewById(R.id.btn_setting);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(getBaseContext(), SettingActivity.class);
//                startActivityForResult(i, SettingActivity.REQUEST_CODE);
                Intent i = new Intent(getBaseContext(), ListActivity.class);
                startActivity(i);
            }
        });
        /**
         *
         */
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == SettingActivity.REQUEST_CODE) {
            if(resultCode != Activity.RESULT_CANCELED) {
                // do something
                finish();
            }
        }
    }

    private boolean isMyAppLauncherDefault() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        ResolveInfo resolveInfo = getPackageManager().resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
        String currentHomePackage = resolveInfo.activityInfo.packageName;
        Log.d(TAG, currentHomePackage);
        return currentHomePackage.equals(getPackageName());
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
