package com.srp.carwash.ui.main.wallpaper.categoried_wallpaper;

import com.androidnetworking.error.ANError;
import com.srp.carwash.data.DataManager;
import com.srp.carwash.data.model.api.Wallpaper;
import com.srp.carwash.ui.base.BaseViewModel;
import com.srp.carwash.utils.rx.SchedulerProvider;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;

public class CategoriedWallpaperViewModel extends BaseViewModel<CategoriedWallpaperNavigator> {

    public ObservableField<String> pageTitle = new ObservableField<>("");

    public ObservableList<Wallpaper> wallpaperList = new ObservableArrayList<>();
    public WallpaperAdapter mAdapter = new WallpaperAdapter(wallpaperList, new WallpaperAdapterCallback() {
        @Override
        public void onItemClick(Wallpaper wallpaper) {
            getNavigator().showWallpaperFullView(wallpaper);
        }
    });

    public CategoriedWallpaperViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void fetchData(String categoryId){
        getCompositeDisposable().add(getDataManager()
        .doGetWallpapersOfCategoryApiCall("123456", categoryId)
        .subscribeOn(getSchedulerProvider().io())
        .observeOn(getSchedulerProvider().ui())
        .subscribe(wallpapers -> {
            wallpaperList.clear();
            wallpaperList.addAll(wallpapers);
            mAdapter.notifyDataSetChanged();
        }, throwable -> {
            ANError error = (ANError) throwable;
            getNavigator().handleMessage(error.getErrorBody());
        }));
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle.set(pageTitle);
    }

    public void onBackClicked(){
        getNavigator().back();
    }
}
