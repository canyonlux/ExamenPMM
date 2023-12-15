package com.example.examenfinal;


import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;


public class Data { // Clase para cargar las imagenes

    @BindingAdapter("paletteImage")
    public static void bindLoadImagePalette(ImageView view, String url) { // Metodo para cargar las imagenes
        Glide.with(view.getContext())
                .load(url)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(view);
    }
}
