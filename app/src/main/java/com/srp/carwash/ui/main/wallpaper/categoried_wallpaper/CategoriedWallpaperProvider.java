package com.srp.carwash.ui.main.wallpaper.categoried_wallpaper;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class CategoriedWallpaperProvider {

    @ContributesAndroidInjector(modules = CategoriedWallpaperModule.class)
    abstract CategoriedWallpaperFragment provideCategoriedWallpaperDialog();
}
