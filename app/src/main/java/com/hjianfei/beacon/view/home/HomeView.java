package com.hjianfei.beacon.view.home;

import com.hjianfei.beacon.bean.Exhibition;
import com.hjianfei.beacon.bean.ViewPager;
import com.hjianfei.beacon.view.base.BaseView;

/**
 * Created by HJianFei on 2016/8/26.
 */

public interface HomeView extends BaseView {

    //初始化数据(ViewPager)
    void initHomeViewPager(ViewPager viewPager);

    //初始化展览预告
    void initForecastExhibition(Exhibition exhibition);

    //初始化常设展厅
    void initOftenExhibition(Exhibition exhibition);

    //初始化临时展厅
    void initTempExhibition(Exhibition exhibition);

    //初始化展厅回顾
    void initBackExhibition(Exhibition exhibition);

}
