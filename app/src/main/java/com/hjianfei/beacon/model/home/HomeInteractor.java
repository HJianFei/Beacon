package com.hjianfei.beacon.model.home;

import android.content.Context;

import com.hjianfei.beacon.bean.ViewPager;

/**
 * Created by HJianFei on 2016/8/26.
 */

public interface HomeInteractor {


    interface onFinishedListener {
        void OnFinished(ViewPager viewPager);
        void OnError();
    }

    void getViewPagerDatas(onFinishedListener listener, Context context);
}
