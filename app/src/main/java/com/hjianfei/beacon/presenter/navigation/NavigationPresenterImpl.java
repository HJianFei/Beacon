package com.hjianfei.beacon.presenter.navigation;

import com.hjianfei.beacon.bean.NavigationInfo;
import com.hjianfei.beacon.model.navigation.NavigationIndicator;
import com.hjianfei.beacon.model.navigation.NavigationIndicatorImpl;
import com.hjianfei.beacon.view.navigation.NavigationView;

/**
 * Created by HJianFei on 2016/9/27.
 */

public class NavigationPresenterImpl implements NavigationPresenter, NavigationIndicator.onFinishListener {
    private NavigationIndicator mNavigationIndicator;
    private NavigationView mNavigationView;

    public NavigationPresenterImpl(NavigationView mNavigationView) {
        this.mNavigationView = mNavigationView;
        mNavigationIndicator = new NavigationIndicatorImpl();

    }

    @Override
    public void initData(String tag) {
        mNavigationIndicator.getNavigationInfo(tag, this);

    }

    @Override
    public void onFinish(NavigationInfo navigationInfo) {
        if (null != mNavigationView) {
            mNavigationView.initNavigationInfo(navigationInfo);
        }

    }

    @Override
    public void onError() {
        if (null != mNavigationView) {
            mNavigationView.showError();
        }

    }
}
