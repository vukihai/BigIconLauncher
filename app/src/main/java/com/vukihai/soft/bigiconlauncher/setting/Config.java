package com.vukihai.soft.bigiconlauncher.setting;
import android.content.Context;
import android.content.SharedPreferences;
public class Config {
    public static final String REF_NAME = "vukihai";
    public static final String WALLPAPER_ENABLE_REF_NAME = "wallpaper";

    private static Config instance;
    private boolean wallpaperEnable = false;
    public boolean isWallpaperEnable() {
        return wallpaperEnable;
    }
    public void setWallpaperEnable(boolean wallpaperEnable) {
        this.wallpaperEnable = wallpaperEnable;
    }
    private Config(){

    }
    public void loadConfig(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(REF_NAME, Context.MODE_PRIVATE);
        this.wallpaperEnable = sharedPreferences.getBoolean(WALLPAPER_ENABLE_REF_NAME, false);
    };
    public static Config getInstance(){
        if(instance == null){
            synchronized (Config.class){
                if(instance == null)
                    instance = new Config();
            }
        }
        return instance;
    }
}
