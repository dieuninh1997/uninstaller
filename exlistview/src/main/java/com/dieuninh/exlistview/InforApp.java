package com.dieuninh.exlistview;

import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;

public class InforApp {

    private String nameApp;
    private Drawable iconApp;
    private String packageName;

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public InforApp() {
    }

    public InforApp(String nameApp, Drawable iconApp) {
        this.nameApp = nameApp;
        this.iconApp = iconApp;
    }

    public void setNameApp(String nameApp) {
        this.nameApp = nameApp;
    }

    public void setIconApp(Drawable iconApp) {
        this.iconApp = iconApp;
    }

    public String getNameApp() {
        return nameApp;
    }

    public Drawable getIconApp() {
        return iconApp;
    }
}
