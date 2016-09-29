package com.hjianfei.beacon.model.navigation;

import com.hjianfei.beacon.bean.NavigationInfo;

/**
 * Created by HJianFei on 2016/9/27.
 */

public interface NavigationIndicator {

    interface onFinishListener {

        void onFinish(NavigationInfo navigationInfo);

        void onError();
    }

    void getNavigationInfo(String minor, onFinishListener listener);
}
