package com.hjianfei.beacon.presenter.education;

/**
 * Created by HJianFei on 2016/8/26.
 */

public interface EducationPresenter {
    void onStart(String tag);

    //下拉刷新页面
    void refreshEducations();

    //上拉加载更多
    void loadMoreEducations();

    void onDestroy();
}
