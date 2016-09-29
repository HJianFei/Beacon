package com.hjianfei.beacon.model.navigation;

import com.hjianfei.beacon.bean.NavigationInfo;
import com.hjianfei.beacon.utils.NetWorkUtils;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by HJianFei on 2016/9/27.
 */

public class NavigationIndicatorImpl implements NavigationIndicator {
    @Override
    public void getNavigationInfo(String minor, final onFinishListener listener) {
        NetWorkUtils.getApi().getNavigationInfo(minor)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NavigationInfo>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onError();

                    }

                    @Override
                    public void onNext(NavigationInfo navigationInfo) {
                        listener.onFinish(navigationInfo);

                    }
                });

    }
}
