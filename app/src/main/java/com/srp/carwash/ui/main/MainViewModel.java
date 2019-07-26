package com.srp.carwash.ui.main;

import com.srp.carwash.data.DataManager;
import com.srp.carwash.ui.base.BaseViewModel;
import com.srp.carwash.utils.rx.SchedulerProvider;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

public class MainViewModel extends BaseViewModel<MainNavigator> {

    public ObservableInt selectedPage = new ObservableInt(0);
    public ObservableBoolean isActionBarVisible = new ObservableBoolean(true);
    public ObservableBoolean isBottomBarVisible = new ObservableBoolean(true);
    public ObservableField<String> pageTitle = new ObservableField<>("");

    public MainViewModel(DataManager dataManager, SchedulerProvider schedulerProvider){
        super(dataManager, schedulerProvider);
    }

    public void onWallpaperIconClick(){
        selectedPage.set(5);
        pageTitle.set("والپیپر");
        isActionBarVisible.set(true);
        getNavigator().showWallpaperCatFragment();
    }

    public void setIsActionBarVisible(boolean vis){
        isActionBarVisible.set(vis);
    }

    public void setIsBottomBarVisible(boolean isBottomBarVisible) {
        this.isBottomBarVisible.set(isBottomBarVisible);
    }
}
