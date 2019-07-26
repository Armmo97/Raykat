/*
 *  Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://mindorks.com/license/apache-v2
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License
 */

package com.srp.carwash.data.remote;

import com.srp.carwash.data.model.api.Launcher;
import com.srp.carwash.data.model.api.LauncherCategory;
import com.srp.carwash.data.model.api.Ringtone;
import com.srp.carwash.data.model.api.RingtoneCategory;
import com.srp.carwash.data.model.api.UpdateProductRequest;
import com.srp.carwash.data.model.api.UpdateProductRespone;
import com.srp.carwash.data.model.api.Wallpaper;
import com.srp.carwash.data.model.api.WallpaperCategory;

import java.util.List;

import io.reactivex.Single;



public interface ApiHelper {





    ApiHeader getApiHeader();

    Single<List<Wallpaper>> doGetAllWallpapersApiCall(String token);

    Single<List<Ringtone>> doGetAllRingtonesApiCall(String token);

    Single<List<Launcher>> doGetAllLaunchersApiCall(String token);

    Single<List<WallpaperCategory>> doGetAllWallpaperCategoriesApiCall(String token);

    Single<List<RingtoneCategory>> doGetAllRingtoneCategoriesApiCall(String token);

    Single<List<LauncherCategory>> doGetAllLauncherCategoriesApiCall(String token);

    Single<UpdateProductRespone> doUpdateWallpaperApiCall(String token, UpdateProductRequest request);

    Single<UpdateProductRespone> doUpdateRingtoneApiCall(String token, UpdateProductRequest request);

    Single<UpdateProductRespone> doUpdateLauncherApiCall(String token, UpdateProductRequest request);

    Single<List<Wallpaper>> doGetWallpapersOfCategoryApiCall(String token, String categoryId);
}
