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

package com.srp.carwash.utils;

import android.content.Context;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.Slide;
import androidx.transition.TransitionManager;

import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.widget.ANImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rx2androidnetworking.Rx2AndroidNetworking;
import com.srp.carwash.BuildConfig;
import com.srp.carwash.R;
import com.srp.carwash.ui.main.wallpaper.WallpaperCatAdapter;
import com.srp.carwash.ui.main.wallpaper.categoried_wallpaper.CategoriedWallpaperViewModel;
import com.srp.carwash.ui.main.wallpaper.categoried_wallpaper.WallpaperAdapter;

/**
 * Created by amitshekhar on 11/07/17.
 */

public final class BindingUtils {

    private BindingUtils() {
        // This class is not publicly instantiable
    }



    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        if (url==null||url.equals("")||url.isEmpty())
            imageView.setImageResource(R.drawable.ic_no_image);
        else {
            RequestOptions requestOptions=new RequestOptions();
            requestOptions.placeholder(R.drawable.ic_no_image);
            requestOptions.error(R.drawable.ic_image_error);
            Glide.with(imageView.getContext()).setDefaultRequestOptions(requestOptions).load(BuildConfig.BASE_IMAGE_URL + url + ".jpg").into(imageView);
        }

    }

    @BindingAdapter("adapter")
    public static void setAdapter(RecyclerView recyclerView, WallpaperCatAdapter adapter){
        recyclerView.setAdapter(adapter);
    }

    @BindingAdapter("adapter")
    public static void setAdapter(RecyclerView recyclerView, WallpaperAdapter adapter){
        GridLayoutManager layoutManager = new GridLayoutManager(recyclerView.getContext(), 2, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @BindingAdapter("customSlideFromTopVisibility")
    public static void setCustomSlideFromTopVisibility(View view, boolean visibility) {
        Animation slideAnim;
        if (visibility) {
            slideAnim = AnimationUtils.loadAnimation(view.getContext(), R.anim.slide_down_show);
            slideAnim.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    view.setVisibility(View.VISIBLE);
                }

                @Override
                public void onAnimationEnd(Animation animation) {

                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
        }else {
            slideAnim = AnimationUtils.loadAnimation(view.getContext(), R.anim.slide_up_hide);
            slideAnim.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    view.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
        }
        view.startAnimation(slideAnim);
//        Slide slide = new Slide();
//        slide.setInterpolator(new DecelerateInterpolator());
//        slide.setSlideEdge(Gravity.TOP);
//        TransitionManager.beginDelayedTransition(((ViewGroup) view.getParent()), slide);
//        view.setVisibility(visibility ? View.VISIBLE : View.GONE);
    }

    @BindingAdapter("customSlideFromBottomVisibility")
    public static void setCustomSlideFromBottomVisibility(View view, boolean visibility) {
        Animation slideAnim;
        if (visibility) {
            slideAnim = AnimationUtils.loadAnimation(view.getContext(), R.anim.slide_up_show);
            slideAnim.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    view.setVisibility(View.VISIBLE);
                }

                @Override
                public void onAnimationEnd(Animation animation) {

                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
        }else {
            slideAnim = AnimationUtils.loadAnimation(view.getContext(), R.anim.slide_down_hide);
            slideAnim.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    view.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
        }
        view.startAnimation(slideAnim);
//        Slide slide = new Slide();
//        slide.setInterpolator(new DecelerateInterpolator());
//        slide.setSlideEdge(Gravity.BOTTOM);
//        slide.setDuration(150);
//        TransitionManager.beginDelayedTransition(((ViewGroup) view.getParent()), slide);
//        view.setVisibility(visibility ? View.VISIBLE : View.GONE);
    }
}
