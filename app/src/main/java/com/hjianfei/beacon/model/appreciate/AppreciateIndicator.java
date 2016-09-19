package com.hjianfei.beacon.model.appreciate;

import com.hjianfei.beacon.bean.Appreciates;

import java.util.List;

/**
 * 创建时间： 2016/9/19.
 * 作者：HJianFei
 * 功能描述：
 */

public interface AppreciateIndicator {
    interface onFinishListener {

        void onAppreciateFinish(List<Appreciates.AppreciatesBean> appreciatesBeans);

        //刷新成功
        void onRefreshSuccess(List<Appreciates.AppreciatesBean> appreciatesBeans);

        //加载成功
        void onLoadMoreSuccess(List<Appreciates.AppreciatesBean> appreciatesBeans);


        void onError();
    }

    void getAllAppreciateByType(onFinishListener listener);

    void getRefreshAllAppreciateByType(onFinishListener listener);

    void getLoadMoreAllAppreciateByType(onFinishListener listener);
}
