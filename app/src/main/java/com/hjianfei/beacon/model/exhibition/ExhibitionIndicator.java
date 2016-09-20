package com.hjianfei.beacon.model.exhibition;

import com.hjianfei.beacon.bean.Exhibition;

import java.util.List;

/**
 * Created by HJianFei on 2016/9/20.
 */

public interface ExhibitionIndicator {

    interface onFinishListener {

        void onExhibitionFinish(List<Exhibition.ExhibitionBean> exhibitionBeanList);

        //刷新成功
        void onRefreshSuccess(List<Exhibition.ExhibitionBean> exhibitionBeanList);

        //加载成功
        void onLoadMoreSuccess(List<Exhibition.ExhibitionBean> exhibitionBeanList);

        void onError();
    }

    void getAllExhibitions(String type,onFinishListener listener);

    void RefreshExhibitions(onFinishListener listener);

    void LoadMoreExhibitions(onFinishListener listener);

}
