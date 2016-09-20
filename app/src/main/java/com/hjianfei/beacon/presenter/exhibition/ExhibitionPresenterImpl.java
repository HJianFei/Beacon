package com.hjianfei.beacon.presenter.exhibition;

import com.hjianfei.beacon.bean.Exhibition;
import com.hjianfei.beacon.model.exhibition.ExhibitionIndicator;
import com.hjianfei.beacon.model.exhibition.ExhibitionIndicatorImpl;
import com.hjianfei.beacon.view.exhibition.ExhibitionView;

import java.util.List;

/**
 * Created by HJianFei on 2016/9/20.
 */

public class ExhibitionPresenterImpl implements ExhibitionPresenter, ExhibitionIndicator.onFinishListener {
    private ExhibitionView mExhibitionView;
    private ExhibitionIndicator mExhibitionIndicator;

    public ExhibitionPresenterImpl(ExhibitionView mExhibitionView) {
        this.mExhibitionView = mExhibitionView;
        mExhibitionIndicator = new ExhibitionIndicatorImpl();
    }

    @Override
    public void onStart(String type) {
        if (null != mExhibitionView) {
            mExhibitionView.showProgress();
        }
        mExhibitionIndicator.getAllExhibitions(type,this);
    }

    @Override
    public void refreshExhibitions() {
        if (null != mExhibitionView) {
            mExhibitionView.showProgress();
        }
        mExhibitionIndicator.RefreshExhibitions(this);

    }

    @Override
    public void loadMoreExhibitions() {
        if (null != mExhibitionView) {
            mExhibitionView.showProgress();
        }
        mExhibitionIndicator.LoadMoreExhibitions(this);

    }

    @Override
    public void onDestroy() {
        if (null != mExhibitionView) {
            mExhibitionView = null;
        }

    }

    @Override
    public void onExhibitionFinish(List<Exhibition.ExhibitionBean> exhibitionBeanList) {
        if (null != mExhibitionView) {
            mExhibitionView.hideProgress();
        }
        mExhibitionView.initRecyclerView(exhibitionBeanList);
    }

    @Override
    public void onRefreshSuccess(List<Exhibition.ExhibitionBean> exhibitionBeanList) {
        if (null != mExhibitionView) {
            mExhibitionView.hideProgress();
        }
        mExhibitionView.initRecyclerView(exhibitionBeanList);
    }

    @Override
    public void onLoadMoreSuccess(List<Exhibition.ExhibitionBean> exhibitionBeanList) {
        if (null != mExhibitionView) {
            mExhibitionView.hideProgress();
        }
        mExhibitionView.initRecyclerView(exhibitionBeanList);

    }

    @Override
    public void onError() {
        if (null != mExhibitionView) {
            mExhibitionView.showError();
        }
    }

}
