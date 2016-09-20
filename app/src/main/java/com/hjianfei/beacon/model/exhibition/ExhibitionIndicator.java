package com.hjianfei.beacon.model.exhibition;

import com.hjianfei.beacon.bean.Exhibitions;

import java.util.List;

/**
 * Created by HJianFei on 2016/9/20.
 */

public interface ExhibitionIndicator {

    interface onFinishListener {

        void onExhibitionFinish(List<Exhibitions.ExhibitionsBean> exhibitionBeansList);

        //刷新成功
        void onRefreshSuccess(List<Exhibitions.ExhibitionsBean> exhibitionBeansList);

        //加载成功
        void onLoadMoreSuccess(List<Exhibitions.ExhibitionsBean> exhibitionBeansList);

        void onError();
    }

    void getAllExhibitions(String type,onFinishListener listener);

    void RefreshExhibitions(onFinishListener listener);

    void LoadMoreExhibitions(onFinishListener listener);

}
