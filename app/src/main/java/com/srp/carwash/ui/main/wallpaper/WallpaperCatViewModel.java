package com.srp.carwash.ui.main.wallpaper;

import com.androidnetworking.error.ANError;
import com.srp.carwash.data.DataManager;
import com.srp.carwash.data.model.api.WallpaperCategory;
import com.srp.carwash.ui.base.BaseViewModel;
import com.srp.carwash.utils.rx.SchedulerProvider;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;

public class WallpaperCatViewModel extends BaseViewModel<WallpaperCatNavigator> {

    public ObservableList<WallpaperCategory> categoryList = new ObservableArrayList<>();
    public WallpaperCatAdapter mAdapter = new WallpaperCatAdapter(categoryList, new AdapterCallback() {
        @Override
        public void onItemClick(String categoryId, String categoryName) {
            getNavigator().showWallpapersOfCategory(categoryId, categoryName);
        }
    });

    public WallpaperCatViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        fetchData();
    }

    private void fetchData(){
        getCompositeDisposable().add(getDataManager()
        .doGetAllWallpaperCategoriesApiCall("123456")
        .subscribeOn(getSchedulerProvider().io())
        .observeOn(getSchedulerProvider().ui())
        .subscribe(wallpaperCategories -> {
            categoryList.clear();
            categoryList.addAll(wallpaperCategories);
            mAdapter.notifyDataSetChanged();
        }, throwable -> {
            ANError error = (ANError) throwable;
            getNavigator().handleMessage(error.getErrorBody());
        }));
    }

}
