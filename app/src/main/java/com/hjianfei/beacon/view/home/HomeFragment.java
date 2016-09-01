package com.hjianfei.beacon.view.home;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hjianfei.beacon.R;
import com.hjianfei.beacon.bean.ViewPager;
import com.hjianfei.beacon.presenter.home.HomePresenter;
import com.hjianfei.beacon.presenter.home.HomePresenterImpl;
import com.hjianfei.beacon.view.base.BaseFragment;

import net.steamcrafted.loadtoast.LoadToast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.wangyuwei.banner.BannerEntity;
import me.wangyuwei.banner.BannerView;
import me.wangyuwei.banner.OnBannerClickListener;

public class HomeFragment extends BaseFragment implements HomeView {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private Context mContext;
    private HomePresenter homePresenter;
    //进度条
    private LoadToast lt;
    @BindView(R.id.banner_view)
    BannerView mBannerView;
    private List<BannerEntity> entities;
    private List<ViewPager.ViewPagersBean> viewPagers;

    public HomeFragment() {
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {

        lt = new LoadToast(mContext).setProgressColor(Color.RED).setText("").setTranslationY(100);
        homePresenter = new HomePresenterImpl(this, mContext);
        homePresenter.onStart();
        //初始化ViewPager

    }

    @Override
    public void initDatas(ViewPager viewPager) {
        entities = new ArrayList<>();
        viewPagers = viewPager.getViewPagers();
        for (ViewPager.ViewPagersBean viewPagersBean : viewPagers) {
            BannerEntity bannerEntity = new BannerEntity();
            bannerEntity.imageUrl = viewPagersBean.getImg_url();
            bannerEntity.title = viewPagersBean.getContent();
            entities.add(bannerEntity);
        }
        mBannerView.setEntities(entities);
        mBannerView.setDrawingCacheEnabled(true);
        mBannerView.setOnBannerClickListener(new OnBannerClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(mContext, position + "=> " + viewPagers.get(position).getDetail_url(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void showProgress() {
        lt.show();

    }

    @Override
    public void hideProgress(boolean flag) {
        if (flag) {
            lt.success();
        } else {
            lt.error();
        }

    }

    @Override
    public void showError(String msg, View.OnClickListener onClickListener) {

    }

    @Override
    public void showEmpty(String msg, View.OnClickListener onClickListener) {

    }

    @Override
    public void onDestroy() {
        homePresenter.onDestroy();
        super.onDestroy();
    }
}
