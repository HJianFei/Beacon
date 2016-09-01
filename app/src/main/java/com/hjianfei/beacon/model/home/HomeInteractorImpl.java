package com.hjianfei.beacon.model.home;

import android.content.Context;

import com.hjianfei.beacon.bean.ViewPager;
import com.hjianfei.beacon.utils.ACache;
import com.hjianfei.beacon.utils.NetWorkUtils;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by HJianFei on 2016/8/26.
 */

public class HomeInteractorImpl implements HomeInteractor {

    @Override
    public void getViewPagerDatas(final onFinishedListener listener, Context context) {

        final ACache aCache = ACache.get(context);
        ViewPager viewPager = (ViewPager) aCache.getAsObject("viewPager");
        if (viewPager == null) {
            Observer<ViewPager> observer = new Observer<ViewPager>() {
                @Override
                public void onCompleted() {
                    System.out.println("Complete");

                }

                @Override
                public void onError(Throwable e) {
                    System.out.println(e.toString());
                    listener.OnError();

                }

                @Override
                public void onNext(ViewPager viewPager) {
                    aCache.put("viewPager", viewPager, 1000 * 60 * 5);
                    System.out.println("from net");
                    listener.OnFinished(viewPager);

                }
            };
            NetWorkUtils.getApi()
                    .getViewPager()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(observer);
        } else {
            listener.OnFinished(viewPager);
            System.out.println("form cache");

        }
    }
}
