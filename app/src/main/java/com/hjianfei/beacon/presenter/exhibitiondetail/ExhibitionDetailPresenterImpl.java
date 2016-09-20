package com.hjianfei.beacon.presenter.exhibitiondetail;

import com.hjianfei.beacon.bean.ExhibitionDetail;
import com.hjianfei.beacon.model.exhibitiondetail.ExhibitionDetailIndicator;
import com.hjianfei.beacon.model.exhibitiondetail.ExhibitionDetailIndicatorImpl;
import com.hjianfei.beacon.view.exhibitiondetail.ExhibitionDetailView;

/**
 * Created by HJianFei on 2016/9/20.
 */

public class ExhibitionDetailPresenterImpl implements ExhibitionDetailPresenter, ExhibitionDetailIndicator.onFinishListener {

    private ExhibitionDetailView mExhibitionDetailView;
    private ExhibitionDetailIndicator mExhibitionDetailIndicator;

    public ExhibitionDetailPresenterImpl(ExhibitionDetailView mExhibitionDetailView) {
        this.mExhibitionDetailView = mExhibitionDetailView;
        mExhibitionDetailIndicator = new ExhibitionDetailIndicatorImpl();
    }

    @Override
    public void onFinish(ExhibitionDetail exhibitionDetail) {
        if (null != mExhibitionDetailView) {
            mExhibitionDetailView.hideProgress();
        }
        mExhibitionDetailView.initData(exhibitionDetail);

    }

    @Override
    public void onError() {
        if (null != mExhibitionDetailView) {
            mExhibitionDetailView.showError();
        }

    }

    @Override
    public void onStart(String detail_url) {
        if (null != mExhibitionDetailView) {
            mExhibitionDetailView.showProgress();
        }
        mExhibitionDetailIndicator.getExhibitionDetail(detail_url,this);
    }

    @Override
    public void onDestroy() {
        if (null != mExhibitionDetailView) {
            mExhibitionDetailView = null;
        }


    }
}
