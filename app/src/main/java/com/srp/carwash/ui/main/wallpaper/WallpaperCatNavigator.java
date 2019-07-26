package com.srp.carwash.ui.main.wallpaper;

public interface WallpaperCatNavigator {

    void handleMessage(String msg);

    void showWallpapersOfCategory(String categoryId, String categoryName);
}
