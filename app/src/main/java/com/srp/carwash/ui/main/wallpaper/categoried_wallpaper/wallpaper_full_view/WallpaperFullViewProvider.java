package com.srp.carwash.ui.main.wallpaper.categoried_wallpaper.wallpaper_full_view;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class WallpaperFullViewProvider {

    @ContributesAndroidInjector(modules = WallpaperFullViewModule.class)
    abstract WallpaperFullViewFragment provideWallpaperFullViewFragment();
}
