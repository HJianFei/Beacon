package com.hjianfei.beacon.presenter.home;

import android.content.Context;

import com.hjianfei.beacon.bean.ViewPager;
import com.hjianfei.beacon.model.home.HomeInteractor;
import com.hjianfei.beacon.model.home.HomeInteractorImpl;
import com.hjianfei.beacon.view.home.HomeView;

/**
 * Created by HJianFei on 2016/8/26.
 */

public class HomePresenterImpl implements HomePresenter, HomeInteractor.onFinishedListener {

    private HomeView homeView;
    private HomeInteractor homeInteractor;
    private Context mContext;

    public HomePresenterImpl(HomeView homeView, Context context) {
        this.homeView = homeView;
        this.mContext = context;
        homeInteractor = new HomeInteractorImpl();
    }

    @Override
    public void onStart() {
        if (homeView != null) {
            homeView.showProgress();
        }
        homeInteractor.getViewPagerDatas(this,mContext);
    }


    @Override
    public void onDestroy() {
        if (homeView != null) {
            homeView = null;
        }
    }

    @Override
    public void OnFinished(ViewPager viewPager) {
        if (homeView != null) {
            if (viewPager != null) {
                homeView.hideProgress(true);
            } else {
                homeView.hideProgress(false);
            }
            homeView.initDatas(viewPager);
        }
    }

    @Override
    public void OnError() {
        if (homeView != null) {
            homeView.hideProgress(false);
        }
    }
}
