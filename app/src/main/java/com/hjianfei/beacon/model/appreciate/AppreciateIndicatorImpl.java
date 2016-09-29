package com.hjianfei.beacon.model.appreciate;

import com.hjianfei.beacon.bean.Appreciates;
import com.hjianfei.beacon.utils.NetWorkUtils;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 创建时间： 2016/9/19.
 * 作者：HJianFei
 * 功能描述：
 */

public class AppreciateIndicatorImpl implements AppreciateIndicator {
    @Override
    public void getAllAppreciateByType(String tag,final onFinishListener listener) {
        NetWorkUtils.getApi().getAllAppreciatesByType(tag)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Appreciates>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println(e.toString());

                    }

                    @Override
                    public void onNext(Appreciates appreciates) {
                        listener.onAppreciateFinish(appreciates.getAppreciates());


                    }
                });
    }

    @Override
    public void getRefreshAllAppreciateByType_0(onFinishListener listener) {


    }

    @Override
    public void getLoadMoreAllAppreciateByType_0(onFinishListener listener) {

    }
}
