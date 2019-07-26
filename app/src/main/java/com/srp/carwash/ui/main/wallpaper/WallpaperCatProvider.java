package com.srp.carwash.ui.main.wallpaper;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class WallpaperCatProvider {

    @ContributesAndroidInjector(modules = WallpaperCatModule.class)
    abstract WallpaperCatFragment provideWallpaperCatFragment();
}
