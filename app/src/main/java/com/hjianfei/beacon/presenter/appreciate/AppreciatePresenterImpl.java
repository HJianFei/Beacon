package com.hjianfei.beacon.presenter.appreciate;

import com.hjianfei.beacon.bean.Appreciates;
import com.hjianfei.beacon.model.appreciate.AppreciateIndicator;
import com.hjianfei.beacon.model.appreciate.AppreciateIndicatorImpl;
import com.hjianfei.beacon.view.appreciate.AppreciateView;

import java.util.List;

/**
 * 创建时间： 2016/9/19.
 * 作者：HJianFei
 * 功能描述：
 */

public class AppreciatePresenterImpl implements AppreciatePresenter, AppreciateIndicator.onFinishListener {

    private AppreciateView mAppreciateView;
    private AppreciateIndicator mAppreciateIndicator;

    public AppreciatePresenterImpl(AppreciateView appreciateView) {
        this.mAppreciateView = appreciateView;
        mAppreciateIndicator = new AppreciateIndicatorImpl();
    }

    @Override
    public void onStart(String tag) {
        if (null != mAppreciateView) {
            mAppreciateView.showProgress();
        }
        if ("青花瓷之约".equals(tag)) {
            mAppreciateIndicator.getAllAppreciateByType_0(this);
        } else if ("珍品鉴赏".equals(tag)) {
            mAppreciateIndicator.getAllAppreciateByType_1(this);
        } else if ("自然标本".equals(tag)) {
            mAppreciateIndicator.getAllAppreciateByType_2(this);
        } else if ("专题鉴赏".equals(tag)) {
            mAppreciateIndicator.getAllAppreciateByType_3(this);
        }

    }

    @Override
    public void refreshAppreciates() {
        if (null != mAppreciateView) {
            mAppreciateView.showProgress();
        }
        mAppreciateIndicator.getRefreshAllAppreciateByType_0(this);

    }

    @Override
    public void loadMoreAppreciates() {
        if (null != mAppreciateView) {
            mAppreciateView.showProgress();
        }
        mAppreciateIndicator.getLoadMoreAllAppreciateByType_0(this);

    }

    @Override
    public void onDestroy() {
        if (null != mAppreciateView) {
            mAppreciateView = null;
        }

    }

    @Override
    public void onAppreciateFinish(List<Appreciates.AppreciatesBean> appreciatesBeans) {
        if (null != mAppreciateView) {
            mAppreciateView.hideProgress();
        }
        mAppreciateView.initRecyclerView(appreciatesBeans);
    }

    @Override
    public void onRefreshSuccess(List<Appreciates.AppreciatesBean> appreciatesBeans) {
        if (null != mAppreciateView) {
            mAppreciateView.hideProgress();
        }
        mAppreciateView.initRecyclerView(appreciatesBeans);
    }

    @Override
    public void onLoadMoreSuccess(List<Appreciates.AppreciatesBean> appreciatesBeans) {
        if (null != mAppreciateView) {
            mAppreciateView.hideProgress();
        }
        mAppreciateView.initRecyclerView(appreciatesBeans);
    }

    @Override
    public void onError() {
        if (null != mAppreciateView) {
            mAppreciateView.showError();
        }

    }
}
