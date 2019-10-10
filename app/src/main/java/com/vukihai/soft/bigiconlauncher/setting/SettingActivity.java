package com.vukihai.soft.bigiconlauncher.setting;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.vukihai.soft.bigiconlauncher.R;

public class SettingActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        getSupportActionBar().hide();
        Button enableButton = findViewById(R.id.btn_enable);
        enableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences(Config.REF_NAME, MODE_PRIVATE);
                sharedPreferences.edit().putBoolean(Config.WALLPAPER_ENABLE_REF_NAME, true).apply();
                setResult(1);
                finish();
            }
        });
        Button disableButton = findViewById(R.id.btn_disable);
        disableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences(Config.REF_NAME, MODE_PRIVATE);
                sharedPreferences.edit().putBoolean(Config.WALLPAPER_ENABLE_REF_NAME, false).apply();
                setResult(1);
                finish();
            }
        });
    }
}
