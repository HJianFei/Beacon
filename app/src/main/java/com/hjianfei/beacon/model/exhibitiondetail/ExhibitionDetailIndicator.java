package com.hjianfei.beacon.model.exhibitiondetail;

import com.hjianfei.beacon.bean.ExhibitionDetail;

/**
 * Created by HJianFei on 2016/9/20.
 */

public interface ExhibitionDetailIndicator {

    interface onFinishListener {

        void onFinish(ExhibitionDetail exhibitionDetail);

        void onError();
    }

    void getExhibitionDetail(String detail_url,onFinishListener listener);
}
