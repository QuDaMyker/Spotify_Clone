package com.example.spotify_clone.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.spotify_clone.OOP.Photo;
import com.example.spotify_clone.R;

import java.util.List;

public class PhotoAdapter extends PagerAdapter {
    private Context mContext;
    private List<Photo> mListPhoto;

    public PhotoAdapter(Context mContext, List<Photo> mListPhoto) {
        this.mContext = mContext;
        this.mListPhoto = mListPhoto;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_photo, container, false);

        ImageView imgPhoto = view.findViewById(R.id.image_photo);

        Photo photo = mListPhoto.get(position);
        if(photo != null) {
            Glide.with(mContext)
                    .load(photo.getResourceId())
                    .transform(new RoundedCorners(100))
                    .into(imgPhoto);
        }
        // add to viewgroup
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        if(mListPhoto!= null) {
            return mListPhoto.size();
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        // remove view
        container.removeView((View)object);
    }
}
