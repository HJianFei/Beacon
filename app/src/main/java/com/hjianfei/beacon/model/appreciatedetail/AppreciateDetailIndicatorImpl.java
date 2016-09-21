package com.hjianfei.beacon.model.appreciatedetail;

import com.hjianfei.beacon.bean.AppreciateDetail;
import com.hjianfei.beacon.utils.NetWorkUtils;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by HJianFei on 2016/9/21.
 */

public class AppreciateDetailIndicatorImpl implements AppreciateDetailIndicator {
    @Override
    public void getAppreciateDetail(String detail_url, final onFinishListener listener) {
        NetWorkUtils.getApi().getAppreciateDetails(detail_url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AppreciateDetail>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onError();
                    }

                    @Override
                    public void onNext(AppreciateDetail appreciateDetail) {
                        listener.onFinish(appreciateDetail);

                    }
                });

    }
}
