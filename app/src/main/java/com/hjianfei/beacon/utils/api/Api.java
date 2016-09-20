package com.hjianfei.beacon.utils.api;


import com.hjianfei.beacon.bean.Appreciates;
import com.hjianfei.beacon.bean.Educations;
import com.hjianfei.beacon.bean.Exhibition;
import com.hjianfei.beacon.bean.ExhibitionDetail;
import com.hjianfei.beacon.bean.Exhibitions;
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
    @GET(Urls.API_HOME_BLUE_AND_WHITE)
    Observable<Appreciates> getAllAppatesByType_0();

    @GET(Urls.HOME_TREASURE_APPRECIATE)
    Observable<Appreciates> getAllAppatesByType_1();

    @GET(Urls.HOME_NATURE_SPECIMEN)
    Observable<Appreciates> getAllAppatesByType_2();

    @GET(Urls.HOME_SPECIAL_APPRECIATE)
    Observable<Appreciates> getAllAppatesByType_3();

    //获取全部展览信息(展览预告)
    @GET(Urls.ALL_EXHIBITION_BY_TYPE_0)
    Observable<Exhibitions> getAllExhibitionByType_0();

    //获取全部展览信息(展览预告)
    @GET(Urls.ALL_EXHIBITION_BY_TYPE_1)
    Observable<Exhibitions> getAllExhibitionByType_1();

    //获取全部展览信息(展览预告)
    @GET(Urls.ALL_EXHIBITION_BY_TYPE_2)
    Observable<Exhibitions> getAllExhibitionByType_2();

    //获取全部展览信息(展览预告)
    @GET(Urls.ALL_EXHIBITION_BY_TYPE_3)
    Observable<Exhibitions> getAllExhibitionByType_3();

    //获取全部教育信息
    //小知识
    @GET(Urls.ALL_EDUCATION_BY_TYPE_0)
    Observable<Educations> getAllEducationByType_0();

    //广东历史
    @GET(Urls.ALL_EDUCATION_BY_TYPE_1)
    Observable<Educations> getAllEducationByType_1();

    //展览详情
    @GET(Urls.EXHIBITION_DETAIL)
    Observable<ExhibitionDetail> getExhibitionDetails();

}
