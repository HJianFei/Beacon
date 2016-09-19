package com.hjianfei.beacon.constants;

/**
 * Created by HJianFei on 2016/8/26.
 * <p>
 * Description: 接口 API 的URL
 */

public class Urls {

    //服务器地址
    public static final String API_SERVER = "http://192.168.1.14:8080/BeaconSys/";
    //首页ViewPager数据地址
    public static final String API_VIEWPAGER = "viewPager!getAllViewPager";
    //获取全部青花瓷之约的信息
    public static final String API_HOME_BLUE_AND_WHITE = "appreciate!getAllAppreciate?type=青花瓷之约";
    //获取全部珍品鉴赏的信息
    public static final String HOME_TREASURE_APPRECIATE = "appreciate!getAllAppreciate?type=珍品鉴赏";
    //获取全部专题鉴赏的信息
    public static final String HOME_NATURE_SPECIMEN = "appreciate!getAllAppreciate?type=专题鉴赏";
    //获取全部自然标本的信息
    public static final String HOME_SPECIAL_APPRECIATE = "appreciate!getAllAppreciate?type=自然标本";
    //获取展览预告的信息
    public static final String IV_FORECAST_MORE = "exhibition!getFirstExhibition?type=0";
    //获取常设展览的信息
    public static final String IV_OFTEN_MORE = "exhibition!getFirstExhibition?type=1";
    //获取临时展览的信息
    public static final String IV_TEMP_MORE = "exhibition!getFirstExhibition?type=2";
    //获取展览回顾的信息
    public static final String IV_BACK_MORE = "exhibition!getFirstExhibition?type=3";
    //获取全部展览的信息type=0,1,2,3代表展览预告，常设展览，临时展厅，展览回顾
//    public static final String ALL_EXHIBITION_BY_TYPE_0 = "exhibition!getAllExhibition";
    //展览预告
    public static final String ALL_EXHIBITION_BY_TYPE_0 = "exhibition!getAllExhibition?type=0";
    //常设展览
    public static final String ALL_EXHIBITION_BY_TYPE_1 = "exhibition!getAllExhibition?type=1";
    //临时展厅
    public static final String ALL_EXHIBITION_BY_TYPE_2 = "exhibition!getAllExhibition?type=2";
    //展览回顾
    public static final String ALL_EXHIBITION_BY_TYPE_3 = "exhibition!getAllExhibition?type=3";
    //获取全部教育数据
    //小知识
    public static final String ALL_EDUCATION_BY_TYPE_0 = "education!getAllEducation?type=0";
    //广东历史
    public static final String ALL_EDUCATION_BY_TYPE_1 = "education!getAllEducation?type=1";

}

