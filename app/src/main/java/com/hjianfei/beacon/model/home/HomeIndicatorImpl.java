package com.hjianfei.beacon.model.home;

import com.hjianfei.beacon.bean.Exhibition;
import com.hjianfei.beacon.utils.NetWorkUtils;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by HJianFei on 2016/8/26.
 */

public class HomeIndicatorImpl implements HomeIndicator {

    @Override
    public void getViewPagerDatas(final onFinishedListener listener) {

        NetWorkUtils.getApi().getViewPager()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<com.hjianfei.beacon.bean.ViewPager>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.OnError();

                    }

                    @Override
                    public void onNext(com.hjianfei.beacon.bean.ViewPager viewPager) {
                        listener.OnViewPagerFinished(viewPager);

                    }
                });
        NetWorkUtils.getApi().getForecast()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Exhibition>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.OnError();
                    }

                    @Override
                    public void onNext(Exhibition exhibition) {
                        listener.onForecastFinished(exhibition);

                    }
                });
        NetWorkUtils.getApi().getOften()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Exhibition>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.OnError();

                    }

                    @Override
                    public void onNext(Exhibition exhibition) {
                        listener.onOftenFinished(exhibition);

                    }
                });
        NetWorkUtils.getApi().getTemp()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Exhibition>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.OnError();

                    }

                    @Override
                    public void onNext(Exhibition exhibition) {
                        listener.onTempFinished(exhibition);

                    }
                });
        NetWorkUtils.getApi().getBack()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Exhibition>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.OnError();

                    }

                    @Override
                    public void onNext(Exhibition exhibition) {
                        listener.onBackFinished(exhibition);

                    }
                });
    }
}
