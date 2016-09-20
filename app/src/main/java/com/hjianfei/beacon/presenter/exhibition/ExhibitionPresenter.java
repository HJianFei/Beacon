package com.hjianfei.beacon.presenter.exhibition;

/**
 * Created by HJianFei on 2016/9/20.
 */

public interface ExhibitionPresenter {

    void onStart(String type);

    //下拉刷新页面
    void refreshExhibitions();

    //上拉加载更多
    void loadMoreExhibitions();

    void onDestroy();
}
