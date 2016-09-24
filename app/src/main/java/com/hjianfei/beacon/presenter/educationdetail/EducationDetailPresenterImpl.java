package com.hjianfei.beacon.presenter.educationdetail;

import com.hjianfei.beacon.bean.EducationDetail;
import com.hjianfei.beacon.model.educationdetail.EducationDetailIndicator;
import com.hjianfei.beacon.model.educationdetail.EducationDetailIndicatorImpl;
import com.hjianfei.beacon.view.educationdetail.EducationDetailView;

/**
 * Created by HJianFei on 2016/9/24.
 */

public class EducationDetailPresenterImpl implements EducationDetailPresenter, EducationDetailIndicator.onFinishListener {

    private EducationDetailView mEducationDetailView;
    private EducationDetailIndicator mEducationDetailIndicator;

    public EducationDetailPresenterImpl(EducationDetailView mEducationDetailView) {
        this.mEducationDetailView = mEducationDetailView;
        mEducationDetailIndicator = new EducationDetailIndicatorImpl();
    }

    @Override
    public void onStart(String detail_url) {
        if (null != mEducationDetailView) {
            mEducationDetailView.showProgress();
        }
        mEducationDetailIndicator.getEducationDetail(detail_url, this);

    }

    @Override
    public void onDestroy() {
        if (null != mEducationDetailView) {
            mEducationDetailView = null;
        }

    }

    @Override
    public void onFinish(EducationDetail educationDetail) {
        if (null != mEducationDetailView) {
            mEducationDetailView.hideProgress();
        }
        mEducationDetailView.initData(educationDetail);

    }

    @Override
    public void onError() {
        if (null != mEducationDetailView) {
            mEducationDetailView.showError();
        }

    }
}
