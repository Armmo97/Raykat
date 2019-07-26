package com.srp.carwash.ui.main.wallpaper.categoried_wallpaper;

import com.srp.carwash.data.model.api.Wallpaper;

public interface CategoriedWallpaperNavigator {

    void handleMessage(String msg);

    void back();

    void showWallpaperFullView(Wallpaper wallpaper);
}
