package com.hjianfei.beacon.view.base;

import android.view.View;

/**
 * Created by HJianFei on 2016/8/26.
 */

public interface BaseView {

    //显示进度条
    void showProgress();

    //隐藏进度条
    void hideProgress( boolean flag);

    //显示加载错误
    void showError(String msg, View.OnClickListener onClickListener);

    //显示数据为空
    void showEmpty(String msg, View.OnClickListener onClickListener);
}
