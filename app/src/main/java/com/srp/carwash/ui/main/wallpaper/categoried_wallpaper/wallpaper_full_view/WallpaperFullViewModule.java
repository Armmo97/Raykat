package com.srp.carwash.ui.main.wallpaper.categoried_wallpaper.wallpaper_full_view;

import com.srp.carwash.data.DataManager;
import com.srp.carwash.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class WallpaperFullViewModule {

    @Provides
    WallpaperFullViewModel provideWallpaperFullViewModel(DataManager dataManager, SchedulerProvider schedulerProvider){
        return new WallpaperFullViewModel(dataManager, schedulerProvider);
    }
}
