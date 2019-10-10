package com.vukihai.soft.bigiconlauncher;

import android.graphics.drawable.Drawable;

public class AppInfo {
    private Drawable icon;
    private CharSequence label;
    private CharSequence packageName;

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public CharSequence getLabel() {
        return label;
    }

    public void setLabel(CharSequence label) {
        this.label = label;
    }

    public CharSequence getPackageName() {
        return packageName;
    }

    public void setPackageName(CharSequence packageName) {
        this.packageName = packageName;
    }
}
