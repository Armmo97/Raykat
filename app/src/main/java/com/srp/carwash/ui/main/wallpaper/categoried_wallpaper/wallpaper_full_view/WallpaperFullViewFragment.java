package com.srp.carwash.ui.main.wallpaper.categoried_wallpaper.wallpaper_full_view;

import android.os.Bundle;
import android.view.View;

import com.srp.carwash.BR;
import com.srp.carwash.R;
import com.srp.carwash.data.model.api.Wallpaper;
import com.srp.carwash.databinding.FragmentWallpaperFullViewBinding;
import com.srp.carwash.ui.base.BaseFragment;


import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class WallpaperFullViewFragment extends BaseFragment<FragmentWallpaperFullViewBinding, WallpaperFullViewModel> implements WallpaperFullViewNavigator {

    private static final String TAG = WallpaperFullViewFragment.class.getSimpleName();

    @Inject
    WallpaperFullViewModel mViewModel;

    public static WallpaperFullViewFragment newInstance(Wallpaper wallpaper) {
        WallpaperFullViewFragment fragment = new WallpaperFullViewFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("wallpaper", wallpaper);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_wallpaper_full_view;
    }

    @Override
    public WallpaperFullViewModel getViewModel() {
        return mViewModel;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel.setNavigator(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getViewDataBinding().setItem(getArguments().getParcelable("wallpaper"));
    }

    public static String getFragmentTag(){
        return TAG;
    }

    @Override
    public void back() {
        getFragmentManager().popBackStack();
    }
}
