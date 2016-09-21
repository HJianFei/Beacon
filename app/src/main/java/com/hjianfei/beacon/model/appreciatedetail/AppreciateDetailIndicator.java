package com.hjianfei.beacon.model.appreciatedetail;

import com.hjianfei.beacon.bean.AppreciateDetail;

/**
 * Created by HJianFei on 2016/9/21.
 */

public interface AppreciateDetailIndicator {

    interface onFinishListener {

        void onFinish(AppreciateDetail appreciateDetail);

        void onError();
    }

    void getAppreciateDetail(String detail_url,onFinishListener listener);
}
