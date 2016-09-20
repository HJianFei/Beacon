package com.hjianfei.beacon.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.hjianfei.beacon.R;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;

/**
 * Created by HJianFei on 2016/9/20.
 */

public class ExhibitionDetailViewPagerAdapter extends StaticPagerAdapter {

    private String[] imgUrl;

    public ExhibitionDetailViewPagerAdapter(String[] imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public View getView(ViewGroup container, int position) {
        ImageView item_iv = new ImageView(container.getContext());
        item_iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Glide.with(container.getContext())
                .load(imgUrl[position].trim())
                .placeholder(R.drawable.photo)
                .error(R.drawable.photo)
                .into(item_iv);
        return item_iv;
    }

    @Override
    public int getCount() {
        return imgUrl.length;
    }
}
