package com.srp.carwash.ui.main.wallpaper;

import com.srp.carwash.data.DataManager;
import com.srp.carwash.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class WallpaperCatModule {

    @Provides
    WallpaperCatViewModel provideWallpaperCatViewModel(DataManager dataManager, SchedulerProvider schedulerProvider){
        return new WallpaperCatViewModel(dataManager, schedulerProvider);
    }
}
