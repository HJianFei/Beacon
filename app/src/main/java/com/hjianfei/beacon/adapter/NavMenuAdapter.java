package com.hjianfei.beacon.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.jdsjlzx.swipe.SwipeMenuAdapter;
import com.hjianfei.beacon.R;
import com.hjianfei.beacon.application.BaseApplication;
import com.hjianfei.beacon.bean.NavigationInfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class NavMenuAdapter extends SwipeMenuAdapter<NavMenuAdapter.DefaultViewHolder> {

    protected List<NavigationInfo> mDataList = new ArrayList<>();

    public NavMenuAdapter() {
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public List<NavigationInfo> getDataList() {
        return mDataList;
    }

    public void setDataList(Collection<NavigationInfo> list) {
        this.mDataList.clear();
        this.mDataList.addAll(list);
        notifyDataSetChanged();
    }

    public void addAll(Collection<NavigationInfo> list) {
        int lastIndex = this.mDataList.size();
        if (this.mDataList.addAll(list)) {
            notifyItemRangeInserted(lastIndex, list.size());
        }
    }

    public void remove(int position) {
        mDataList.remove(position);
        BaseApplication.getInstance().getNavigationInfos().remove(position);
        notifyItemRemoved(position);
        if (position != mDataList.size()) { // 如果移除的是最后一个，忽略
            notifyItemRangeChanged(position, mDataList.size() - position);
        }

    }

    public void clear() {
        mDataList.clear();
        notifyDataSetChanged();
    }

    @Override
    public View onCreateContentView(ViewGroup parent, int viewType) {
        return LayoutInflater.from(parent.getContext()).inflate(R.layout.navigation_item, parent, false);
    }

    @Override
    public NavMenuAdapter.DefaultViewHolder onCompatCreateViewHolder(View realContentView, int viewType) {
        return new DefaultViewHolder(realContentView);
    }

    @Override
    public void onBindViewHolder(NavMenuAdapter.DefaultViewHolder holder, int position) {
        NavigationInfo info = mDataList.get(position);

        DefaultViewHolder viewHolder = holder;
        viewHolder.tv_title.setText(info.getNavigationInfo().getContent());
        Glide.with(BaseApplication.getInstance().getApplicationContext())
                .load(info.getNavigationInfo().getImg_url())
                .centerCrop()
                .crossFade()
                .placeholder(R.drawable.pic_loading)
                .error(R.drawable.pic_loading)
                .into(viewHolder.iv_img);

    }

    static class DefaultViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_img;
        TextView tv_title;

        public DefaultViewHolder(View itemView) {
            super(itemView);
            iv_img = (ImageView) itemView.findViewById(R.id.navigation_item_img);
            tv_title = (TextView) itemView.findViewById(R.id.navigation_item_title);
        }

    }

}
