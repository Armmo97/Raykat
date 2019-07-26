package com.srp.carwash.data.remote;

import com.srp.carwash.BuildConfig;


public final class ApiEndPoint {


    public static final String ENDPOINT_WALLPAPERS = BuildConfig.BASE_URL + "wallpapers";

    public static final String ENDPOINT_RINGTONES = BuildConfig.BASE_URL + "ringtones";

    public static final String ENDPOINT_LAUNCHERS = BuildConfig.BASE_URL + "launchers";

    public static final String ENDPOINT_WALLPAPER_CATEFORIES = BuildConfig.BASE_URL + "wallpapersCategories";

    public static final String ENDPOINT_RINGTONES_CATEFORIES = BuildConfig.BASE_URL + "ringtonesCategories";

    public static final String ENDPOINT_LAUNCHERS_CATEFORIES = BuildConfig.BASE_URL + "launchersCategories";



    private ApiEndPoint() {
        // This class is not publicly instantiable
    }
}
