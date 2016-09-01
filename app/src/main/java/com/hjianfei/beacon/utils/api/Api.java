package com.hjianfei.beacon.utils.api;


import com.hjianfei.beacon.bean.ViewPager;
import com.hjianfei.beacon.constants.Urls;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by HJianFei on 2016/8/29.
 */

public interface Api {
    //获取HomeFragment中ViewPager的数据
    @GET(Urls.API_VIEWPAGER)
    Observable<ViewPager> getViewPager();

}
