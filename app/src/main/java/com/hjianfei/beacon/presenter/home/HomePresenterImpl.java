package com.hjianfei.beacon.presenter.home;

import com.hjianfei.beacon.bean.Exhibition;
import com.hjianfei.beacon.bean.ViewPager;
import com.hjianfei.beacon.model.home.HomeIndicator;
import com.hjianfei.beacon.model.home.HomeIndicatorImpl;
import com.hjianfei.beacon.view.home.HomeView;

/**
 * Created by HJianFei on 2016/8/26.
 */

public class HomePresenterImpl implements HomePresenter, HomeIndicator.onFinishedListener {

    private HomeView homeView;
    private HomeIndicator mHomeIndicator;

    public HomePresenterImpl(HomeView homeView) {
        this.homeView = homeView;
        mHomeIndicator = new HomeIndicatorImpl();
    }

    @Override
    public void onStart() {
        if (homeView != null) {
            homeView.showProgress();
        }
        mHomeIndicator.getViewPagerDatas(this);
    }


    @Override
    public void onDestroy() {
        if (homeView != null) {
            homeView = null;
        }
    }

    @Override
    public void OnViewPagerFinished(ViewPager viewPager) {
        if (homeView != null) {
            if (null == viewPager) {
                homeView.hideProgress();
                homeView.showError();
            } else {
                homeView.hideProgress();
            }
            homeView.initHomeViewPager(viewPager);
        }
    }

    @Override
    public void onForecastFinished(Exhibition exhibition) {
        homeView.initForecastExhibition(exhibition);

    }

    @Override
    public void onOftenFinished(Exhibition exhibition) {
        homeView.initOftenExhibition(exhibition);

    }

    @Override
    public void onTempFinished(Exhibition exhibition) {
        homeView.initTempExhibition(exhibition);

    }

    @Override
    public void onBackFinished(Exhibition exhibition) {
        homeView.initBackExhibition(exhibition);

    }

    @Override
    public void OnError() {
        if (homeView != null) {
            homeView.hideProgress();
        }
    }
}
