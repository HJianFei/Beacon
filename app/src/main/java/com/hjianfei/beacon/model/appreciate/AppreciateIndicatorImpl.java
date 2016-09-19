package com.hjianfei.beacon.model.appreciate;

import com.hjianfei.beacon.bean.Appreciates;
import com.hjianfei.beacon.utils.NetWorkUtils;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 创建时间： 2016/9/19.
 * 作者：HJianFei
 * 功能描述：
 */

public class AppreciateIndicatorImpl implements AppreciateIndicator {
    @Override
    public void getAllAppreciateByType(final onFinishListener listener) {
        NetWorkUtils.getApi().getAllAppreciatesByType()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Appreciates>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Appreciates appreciates) {
                        listener.onAppreciateFinish(appreciates.getAppreciates());

                    }
                });
    }

    @Override
    public void getRefreshAllAppreciateByType(onFinishListener listener) {

    }

    @Override
    public void getLoadMoreAllAppreciateByType(onFinishListener listener) {

    }
}
