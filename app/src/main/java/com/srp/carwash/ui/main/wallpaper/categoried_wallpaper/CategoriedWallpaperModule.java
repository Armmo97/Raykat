package com.srp.carwash.ui.main.wallpaper.categoried_wallpaper;

import com.srp.carwash.data.DataManager;
import com.srp.carwash.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class CategoriedWallpaperModule {

    @Provides
    CategoriedWallpaperViewModel provideCategoriedWallpaperViewModel(DataManager dataManager, SchedulerProvider schedulerProvider){
        return new CategoriedWallpaperViewModel(dataManager, schedulerProvider);
    }
}
