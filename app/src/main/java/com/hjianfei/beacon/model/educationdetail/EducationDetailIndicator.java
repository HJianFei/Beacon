package com.hjianfei.beacon.model.educationdetail;

import com.hjianfei.beacon.bean.EducationDetail;

/**
 * Created by HJianFei on 2016/9/24.
 */

public interface EducationDetailIndicator {

    interface onFinishListener {

        void onFinish(EducationDetail educationDetail);

        void onError();
    }

    void getEducationDetail(String detail_url, onFinishListener listener);
}
