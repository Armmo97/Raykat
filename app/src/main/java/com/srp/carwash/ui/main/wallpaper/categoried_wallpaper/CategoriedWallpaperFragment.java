package com.srp.carwash.ui.main.wallpaper.categoried_wallpaper;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.srp.carwash.BR;
import com.srp.carwash.R;
import com.srp.carwash.data.model.api.Wallpaper;
import com.srp.carwash.databinding.FragmentWallpapersBinding;
import com.srp.carwash.ui.base.BaseFragment;
import com.srp.carwash.ui.main.MainActivity;

import javax.inject.Inject;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class CategoriedWallpaperFragment extends BaseFragment<FragmentWallpapersBinding, CategoriedWallpaperViewModel> implements CategoriedWallpaperNavigator {

    private static final String TAG = CategoriedWallpaperFragment.class.getSimpleName();

    @Inject
    CategoriedWallpaperViewModel mViewModel;

    public static CategoriedWallpaperFragment newInstance(String categoryId, String categoryName) {
        CategoriedWallpaperFragment fragment = new CategoriedWallpaperFragment();
        Bundle bundle = new Bundle();
        bundle.putString("catId", categoryId);
        bundle.putString("catName", categoryName);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_wallpapers;
    }

    @Override
    public CategoriedWallpaperViewModel getViewModel() {
        return mViewModel;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel.setNavigator(this);
        mViewModel.fetchData(getArguments().getString("catId"));
        mViewModel.setPageTitle(getArguments().getString("catName"));
    }

    public static String getFragmentTag(){
        return TAG;
    }


    @Override
    public void handleMessage(String msg) {
        showMessage(msg);
    }

    @Override
    public void back() {
        getFragmentManager().popBackStack();
    }

    @Override
    public void showWallpaperFullView(Wallpaper wallpaper) {
        ((MainActivity)getBaseActivity()).showWallpaperFullView(wallpaper);
    }
}
