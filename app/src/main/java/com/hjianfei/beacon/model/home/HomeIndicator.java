package com.hjianfei.beacon.model.home;

import com.hjianfei.beacon.bean.Exhibition;
import com.hjianfei.beacon.bean.ViewPager;

/**
 * Created by HJianFei on 2016/8/26.
 */

public interface HomeIndicator {


    interface onFinishedListener {
        void OnViewPagerFinished(ViewPager viewPager);
        void onForecastFinished(Exhibition exhibition);
        void onOftenFinished(Exhibition exhibition);
        void onTempFinished(Exhibition exhibition);
        void onBackFinished(Exhibition exhibition);
        void OnError();
    }

    void getViewPagerDatas(onFinishedListener listener);
}
