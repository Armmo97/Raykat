package com.srp.carwash.ui.main.wallpaper.categoried_wallpaper.wallpaper_full_view;

import android.os.Handler;

import com.srp.carwash.data.DataManager;
import com.srp.carwash.ui.base.BaseViewModel;
import com.srp.carwash.utils.rx.SchedulerProvider;


import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;

public class WallpaperFullViewModel extends BaseViewModel<WallpaperFullViewNavigator> {

    public ObservableBoolean isMenuVisible = new ObservableBoolean(true);

    public WallpaperFullViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        new Handler().postDelayed(() -> isMenuVisible.set(false), 3000);
    }

    public void onBackClicked(){
        getNavigator().back();
    }

    public void setIsMenuVisible(){
        isMenuVisible.set(!isMenuVisible.get());
    }
}
