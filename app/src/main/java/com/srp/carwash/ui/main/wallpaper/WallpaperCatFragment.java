package com.srp.carwash.ui.main.wallpaper;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.srp.carwash.BR;
import com.srp.carwash.R;
import com.srp.carwash.databinding.FragmentWallpaperCatBinding;
import com.srp.carwash.ui.base.BaseFragment;
import com.srp.carwash.ui.main.MainActivity;
import com.srp.carwash.ui.main.wallpaper.categoried_wallpaper.CategoriedWallpaperFragment;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;



public class WallpaperCatFragment extends BaseFragment<FragmentWallpaperCatBinding, WallpaperCatViewModel> implements WallpaperCatNavigator {

    private static final String TAG = WallpaperCatFragment.class.getSimpleName();

    @Inject
    WallpaperCatViewModel mViewModel;

    public static WallpaperCatFragment newInstance(){
        WallpaperCatFragment fragment = new WallpaperCatFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_wallpaper_cat;
    }

    @Override
    public WallpaperCatViewModel getViewModel() {
        return mViewModel;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel.setNavigator(this);
    }

    public static String getFragmentTag(){
        return TAG;
    }

    @Override
    public void handleMessage(String msg) {
        showMessage(msg);
    }

    @Override
    public void showWallpapersOfCategory(String categoryId, String categoryName) {
        ((MainActivity)getBaseActivity()).showWallpapersFragment(categoryId, categoryName);
    }
}
