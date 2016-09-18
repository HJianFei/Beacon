package com.hjianfei.beacon.view.base;

/**
 * Created by HJianFei on 2016/8/26.
 */

public interface BaseView {

    //显示进度条
    void showProgress();

    //隐藏进度条
    void hideProgress();

    //显示加载错误
    void showError();

    //显示数据为空
    void showEmpty();
}
