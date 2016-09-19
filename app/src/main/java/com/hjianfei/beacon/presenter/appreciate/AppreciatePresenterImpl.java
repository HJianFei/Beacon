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
    public void onStart() {
        if (null != mAppreciateView) {
            mAppreciateView.showProgress();
        }
        mAppreciateIndicator.getAllAppreciateByType(this);

    }

    @Override
    public void refreshAppreciates() {
        if (null != mAppreciateView) {
            mAppreciateView.showProgress();
        }
        mAppreciateIndicator.getRefreshAllAppreciateByType(this);

    }

    @Override
    public void loadMoreAppreciates() {
        if (null != mAppreciateView) {
            mAppreciateView.showProgress();
        }
        mAppreciateIndicator.getLoadMoreAllAppreciateByType(this);

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
