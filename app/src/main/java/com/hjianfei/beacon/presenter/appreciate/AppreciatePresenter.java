package com.hjianfei.beacon.presenter.appreciate;

/**
 * 创建时间： 2016/9/19.
 * 作者：HJianFei
 * 功能描述：
 */

public interface AppreciatePresenter {

    void onStart(String tag);

    //下拉刷新页面
    void refreshAppreciates();

    //上拉加载更多
    void loadMoreAppreciates();

    void onDestroy();

}
