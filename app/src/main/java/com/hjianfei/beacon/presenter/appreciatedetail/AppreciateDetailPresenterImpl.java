package com.hjianfei.beacon.presenter.appreciatedetail;

import com.hjianfei.beacon.bean.AppreciateDetail;
import com.hjianfei.beacon.model.appreciatedetail.AppreciateDetailIndicator;
import com.hjianfei.beacon.model.appreciatedetail.AppreciateDetailIndicatorImpl;
import com.hjianfei.beacon.view.appreciatedetail.AppreciateDetailView;

/**
 * Created by HJianFei on 2016/9/21.
 */

public class AppreciateDetailPresenterImpl implements AppreciateDetailPresenter, AppreciateDetailIndicator.onFinishListener {

    private AppreciateDetailView mAppreciateDetailView;
    private AppreciateDetailIndicator mAppreciateDetailIndicator;

    public AppreciateDetailPresenterImpl(AppreciateDetailView mAppreciateDetailView) {
        this.mAppreciateDetailView = mAppreciateDetailView;
        mAppreciateDetailIndicator = new AppreciateDetailIndicatorImpl();
    }

    @Override
    public void onFinish(AppreciateDetail appreciateDetail) {
        if (null != mAppreciateDetailView) {
            mAppreciateDetailView.hideProgress();
        }
        mAppreciateDetailView.initAppreciateDetailData(appreciateDetail);

    }

    @Override
    public void onError() {
        if (null != mAppreciateDetailView) {
            mAppreciateDetailView.showError();
        }

    }

    @Override
    public void onStart(String detail_url) {
        if (null != mAppreciateDetailView) {
            mAppreciateDetailView.showProgress();
        }
        mAppreciateDetailIndicator.getAppreciateDetail(detail_url, this);

    }

    @Override
    public void onDestroy() {
        if (null != mAppreciateDetailView) {
            mAppreciateDetailView = null;
        }

    }
}
