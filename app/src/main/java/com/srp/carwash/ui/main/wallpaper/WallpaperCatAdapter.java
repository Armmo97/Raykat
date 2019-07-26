package com.srp.carwash.ui.main.wallpaper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.srp.carwash.R;
import com.srp.carwash.data.model.api.WallpaperCategory;
import com.srp.carwash.databinding.ItemWallpaperCatBinding;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class WallpaperCatAdapter extends RecyclerView.Adapter<WallpaperCatAdapter.WallpaperCatViewHolder> {

    private List<WallpaperCategory> categoryList;
    private AdapterCallback callback;

    public WallpaperCatAdapter(List<WallpaperCategory> categoryList, AdapterCallback callback) {
        this.categoryList = categoryList;
        this.callback = callback;
    }

    @NonNull
    @Override
    public WallpaperCatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemWallpaperCatBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_wallpaper_cat, parent, false);
        return new WallpaperCatViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull WallpaperCatViewHolder holder, int position) {
        holder.binding.setAdapter(this);
        holder.binding.setItem(categoryList.get(position));
    }

    @Override
    public int getItemCount() {
        if (categoryList != null && categoryList.size() > 0)
            return categoryList.size();
        return 0;
    }

    public void onItemClick(String id, String categoryName){
        callback.onItemClick(id, categoryName);
    }

    public class WallpaperCatViewHolder extends RecyclerView.ViewHolder {

        private ItemWallpaperCatBinding binding;

        public WallpaperCatViewHolder(@NonNull ItemWallpaperCatBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
