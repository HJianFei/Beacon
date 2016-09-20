package com.hjianfei.beacon.model.exhibitiondetail;

import com.hjianfei.beacon.bean.ExhibitionDetail;
import com.hjianfei.beacon.utils.NetWorkUtils;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by HJianFei on 2016/9/20.
 */

public class ExhibitionDetailIndicatorImpl implements ExhibitionDetailIndicator {

    @Override
    public void getExhibitionDetail(final onFinishListener listener) {
        NetWorkUtils.getApi().getExhibitionDetails()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ExhibitionDetail>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onError();


                    }

                    @Override
                    public void onNext(ExhibitionDetail exhibitionDetail) {
                        listener.onFinish(exhibitionDetail);

                    }
                });
    }
}
