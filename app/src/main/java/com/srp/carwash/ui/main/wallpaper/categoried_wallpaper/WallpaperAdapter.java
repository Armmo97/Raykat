package com.srp.carwash.ui.main.wallpaper.categoried_wallpaper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.srp.carwash.R;
import com.srp.carwash.data.model.api.Wallpaper;
import com.srp.carwash.databinding.ItemWallpaperBinding;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class WallpaperAdapter extends RecyclerView.Adapter<WallpaperAdapter.WallpaperViewHolder> {

    private List<Wallpaper> wallpaperList;
    private WallpaperAdapterCallback callback;

    public WallpaperAdapter(List<Wallpaper> wallpaperList, WallpaperAdapterCallback callback) {
        this.wallpaperList = wallpaperList;
        this.callback = callback;
    }

    @NonNull
    @Override
    public WallpaperViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemWallpaperBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_wallpaper, parent, false);
        return new WallpaperViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull WallpaperViewHolder holder, int position) {
        holder.binding.setAdapter(this);
        holder.binding.setItem(wallpaperList.get(position));
    }

    @Override
    public int getItemCount() {
        if (wallpaperList != null && wallpaperList.size() > 0)
            return wallpaperList.size();
        return 0;
    }

    public void onItemClick(Wallpaper wallpaper){
        callback.onItemClick(wallpaper);
    }

    public class WallpaperViewHolder extends RecyclerView.ViewHolder {

        private ItemWallpaperBinding binding;

        public WallpaperViewHolder(@NonNull ItemWallpaperBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
