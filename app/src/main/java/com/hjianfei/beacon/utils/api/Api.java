package com.hjianfei.beacon.utils.api;


import com.hjianfei.beacon.bean.AppreciateDetail;
import com.hjianfei.beacon.bean.Appreciates;
import com.hjianfei.beacon.bean.EducationDetail;
import com.hjianfei.beacon.bean.Educations;
import com.hjianfei.beacon.bean.Exhibition;
import com.hjianfei.beacon.bean.ExhibitionDetail;
import com.hjianfei.beacon.bean.Exhibitions;
import com.hjianfei.beacon.bean.NavigationInfo;
import com.hjianfei.beacon.bean.ViewPager;
import com.hjianfei.beacon.constants.Urls;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by HJianFei on 2016/8/29.
 */

public interface Api {
    //获取HomeFragment中ViewPager的数据
    @GET(Urls.API_VIEWPAGER)
    Observable<ViewPager> getViewPager();

    //获取Home页面展览预告的信息
    @GET(Urls.IV_FORECAST_MORE)
    Observable<Exhibition> getForecast();

    //获取Home页面常设展厅的信息
    @GET(Urls.IV_OFTEN_MORE)
    Observable<Exhibition> getOften();

    //获取Home页面临时展厅的信息
    @GET(Urls.IV_TEMP_MORE)
    Observable<Exhibition> getTemp();

    //获取Home页面展览回顾的信息
    @GET(Urls.IV_BACK_MORE)
    Observable<Exhibition> getBack();

    //获取全部青花瓷之约的信息
    @GET(Urls.API_HOME_APPRECIATES_BY_TYPE)
    Observable<Appreciates> getAllAppreciatesByType(@Query("type") String type);

    //展览详情
    @GET(Urls.APPRECIATE_DETAIL)
    Observable<AppreciateDetail> getAppreciateDetails(@Query("detail_url") String detail_url);

    //获取全部展览信息(展览预告)
    @GET(Urls.ALL_EXHIBITION_BY_TYPE)
    Observable<Exhibitions> getAllExhibitionByType(@Query("type") String type);

    //获取全部教育信息
    //小知识
    @GET(Urls.ALL_EDUCATION_BY_TYPE)
    Observable<Educations> getAllEducationByType(@Query("type") String type);

    //获取教育详情信息
    @GET(Urls.EDUCATION_DETAIL)
    Observable<EducationDetail> getEducationDetails(@Query("detail_url") String detail_url);

    //展览详情
    @GET(Urls.EXHIBITION_DETAIL)
    Observable<ExhibitionDetail> getExhibitionDetails(@Query("detail_url") String detail_url);

    //导游
    @GET(Urls.NAVIGATION_ITEM)
    Observable<NavigationInfo> getNavigationInfo(@Query("minor") String minor);

}
