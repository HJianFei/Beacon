package com.hjianfei.beacon.presenter.education;

import com.hjianfei.beacon.bean.Educations;
import com.hjianfei.beacon.model.education.EducationIndicator;
import com.hjianfei.beacon.model.education.EducationIndicatorImpl;
import com.hjianfei.beacon.view.education.EducationView;

import java.util.List;

/**
 * Created by HJianFei on 2016/9/19.
 */

public class EducationPresenterImpl implements EducationPresenter, EducationIndicator.onFinishListener {
    private EducationView mEducationView;
    private EducationIndicator mEducationIndicator;

    public EducationPresenterImpl(EducationView mEducationView) {
        this.mEducationView = mEducationView;
        mEducationIndicator = new EducationIndicatorImpl();
    }

    @Override
    public void onStart(String tag) {
        if (null != mEducationView) {
            mEducationView.showProgress();
        }
        mEducationIndicator.getAllEducationByType_0(this);

    }

    @Override
    public void refreshEducations() {
        if (null != mEducationView) {
            mEducationView.showProgress();
        }
        mEducationIndicator.getRefreshAllEducationByType_0(this);

    }

    @Override
    public void loadMoreEducations() {
        if (null != mEducationView) {
            mEducationView.showProgress();
        }
        mEducationIndicator.getLoadMoreAllEducationByType_0(this);

    }


    @Override
    public void onDestroy() {
        if (null != mEducationView) {
            mEducationView.hideProgress();
        }

    }

    @Override
    public void onEducationFinish(List<Educations.EducationsBean> educationsBeanList) {
        if (null != mEducationView) {
            mEducationView.hideProgress();
        }
        mEducationView.initRecyclerView(educationsBeanList);

    }

    @Override
    public void onRefreshSuccess(List<Educations.EducationsBean> educationsBeanList) {
        if (null != mEducationView) {
            mEducationView.hideProgress();
        }
        mEducationView.initRecyclerView(educationsBeanList);

    }

    @Override
    public void onLoadMoreSuccess(List<Educations.EducationsBean> educationsBeanList) {
        if (null != mEducationView) {
            mEducationView.hideProgress();
        }
        mEducationView.initRecyclerView(educationsBeanList);

    }

    @Override
    public void onError() {
        if (null != mEducationView) {
            mEducationView.showError();
        }

    }
}
