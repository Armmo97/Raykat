package com.srp.carwash.data.remote;

import com.rx2androidnetworking.Rx2AndroidNetworking;
import com.srp.carwash.data.model.api.Launcher;
import com.srp.carwash.data.model.api.LauncherCategory;
import com.srp.carwash.data.model.api.Ringtone;
import com.srp.carwash.data.model.api.RingtoneCategory;
import com.srp.carwash.data.model.api.UpdateProductRequest;
import com.srp.carwash.data.model.api.UpdateProductRespone;
import com.srp.carwash.data.model.api.Wallpaper;
import com.srp.carwash.data.model.api.WallpaperCategory;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;


@Singleton
public class AppApiHelper implements ApiHelper {

    private ApiHeader mApiHeader;

    @Inject
    public AppApiHelper(ApiHeader apiHeader) {
        mApiHeader = apiHeader;
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHeader;
    }

    @Override
    public Single<List<Wallpaper>> doGetAllWallpapersApiCall(String token) {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_WALLPAPERS)
                .addHeaders("Authorization", token)
                .build()
                .getObjectListSingle(Wallpaper.class);
    }

    @Override
    public Single<List<Ringtone>> doGetAllRingtonesApiCall(String token) {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_RINGTONES)
                .addHeaders("Authorization", token)
                .build()
                .getObjectListSingle(Ringtone.class);
    }

    @Override
    public Single<List<Launcher>> doGetAllLaunchersApiCall(String token) {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_LAUNCHERS)
                .addHeaders("Authorization", token)
                .build()
                .getObjectListSingle(Launcher.class);
    }

    @Override
    public Single<List<WallpaperCategory>> doGetAllWallpaperCategoriesApiCall(String token) {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_WALLPAPER_CATEFORIES)
                .addHeaders("Authorization", token)
                .build()
                .getObjectListSingle(WallpaperCategory.class);
    }

    @Override
    public Single<List<RingtoneCategory>> doGetAllRingtoneCategoriesApiCall(String token) {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_RINGTONES_CATEFORIES)
                .addHeaders("Authorization", token)
                .build()
                .getObjectListSingle(RingtoneCategory.class);
    }

    @Override
    public Single<List<LauncherCategory>> doGetAllLauncherCategoriesApiCall(String token) {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_LAUNCHERS_CATEFORIES)
                .addHeaders("Authorization", token)
                .build()
                .getObjectListSingle(LauncherCategory.class);
    }

    @Override
    public Single<UpdateProductRespone> doUpdateWallpaperApiCall(String token, UpdateProductRequest request) {
        return Rx2AndroidNetworking.put(ApiEndPoint.ENDPOINT_WALLPAPERS)
                .addBodyParameter(request)
                .addHeaders("Authorization", token)
                .build()
                .getObjectSingle(UpdateProductRespone.class);
    }

    @Override
    public Single<UpdateProductRespone> doUpdateRingtoneApiCall(String token, UpdateProductRequest request) {
        return Rx2AndroidNetworking.put(ApiEndPoint.ENDPOINT_RINGTONES)
                .addBodyParameter(request)
                .addHeaders("Authorization", token)
                .build()
                .getObjectSingle(UpdateProductRespone.class);
    }

    @Override
    public Single<UpdateProductRespone> doUpdateLauncherApiCall(String token, UpdateProductRequest request) {
        return Rx2AndroidNetworking.put(ApiEndPoint.ENDPOINT_LAUNCHERS)
                .addBodyParameter(request)
                .addHeaders("Authorization", token)
                .build()
                .getObjectSingle(UpdateProductRespone.class);
    }

    @Override
    public Single<List<Wallpaper>> doGetWallpapersOfCategoryApiCall(String token, String categoryId) {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_WALLPAPERS)
                .addHeaders("Authorization", token)
                .addQueryParameter("categoryId", categoryId)
                .build()
                .getObjectListSingle(Wallpaper.class);
    }


}
