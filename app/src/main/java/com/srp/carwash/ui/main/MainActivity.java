package com.srp.carwash.ui.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.srp.carwash.BR;
import com.srp.carwash.R;
import com.srp.carwash.data.model.api.Wallpaper;
import com.srp.carwash.databinding.ActivityMainBinding;
import com.srp.carwash.ui.base.BaseActivity;
import com.srp.carwash.ui.main.wallpaper.WallpaperCatFragment;
import com.srp.carwash.ui.main.wallpaper.categoried_wallpaper.CategoriedWallpaperFragment;
import com.srp.carwash.ui.main.wallpaper.categoried_wallpaper.wallpaper_full_view.WallpaperFullViewFragment;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> implements MainNavigator, HasSupportFragmentInjector {

    @Inject
    public MainViewModel mainViewModel;
    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    public static Intent newIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public MainViewModel getViewModel() {
        return mainViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            Drawable background = getResources().getDrawable(R.drawable.action_bar_bg);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(android.R.color.transparent));
            window.setNavigationBarColor(getResources().getColor(android.R.color.transparent));
            window.setBackgroundDrawable(background);
        }

        super.onCreate(savedInstanceState);
        mainViewModel.setNavigator(this);
        getSupportFragmentManager().registerFragmentLifecycleCallbacks(new FragmentManager.FragmentLifecycleCallbacks() {
            @Override
            public void onFragmentStopped(@NonNull FragmentManager fm, @NonNull Fragment f) {
                if (f.getTag().equals(CategoriedWallpaperFragment.getFragmentTag()))
                    mainViewModel.setIsActionBarVisible(true);
                else if (f.getTag().equals(WallpaperFullViewFragment.getFragmentTag()))
                    mainViewModel.setIsBottomBarVisible(true);
                super.onFragmentStopped(fm, f);
            }
        },false);
    }

    @Override
    public void showWallpaperCatFragment() {
        showFragment(WallpaperCatFragment.newInstance(), R.id.frag_container_main, WallpaperCatFragment.getFragmentTag());
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }

    public void showWallpapersFragment(String categoryId, String categoryName){
        mainViewModel.setIsActionBarVisible(false);
        showFragmentWithBackStack(CategoriedWallpaperFragment.newInstance(categoryId, categoryName), R.id.frag_container_main, CategoriedWallpaperFragment.getFragmentTag());
    }

    public void showWallpaperFullView(Wallpaper wallpaper){
        mainViewModel.setIsActionBarVisible(false);
        mainViewModel.setIsBottomBarVisible(false);
        showFragmentWithBackStack(WallpaperFullViewFragment.newInstance(wallpaper), R.id.frag_container_main, WallpaperFullViewFragment.getFragmentTag());
    }
}
