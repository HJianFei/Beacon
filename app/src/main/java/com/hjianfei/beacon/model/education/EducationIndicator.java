package com.hjianfei.beacon.model.education;

import com.hjianfei.beacon.bean.Educations;

import java.util.List;

/**
 * Created by HJianFei on 2016/8/26.
 */

public interface EducationIndicator {

    interface onFinishListener {

        void onEducationFinish(List<Educations.EducationsBean> educationsBeanList);

        //刷新成功
        void onRefreshSuccess(List<Educations.EducationsBean> educationsBeanList);

        //加载成功
        void onLoadMoreSuccess(List<Educations.EducationsBean> educationsBeanList);


        void onError();
    }

    void getAllEducationByType_0(onFinishListener listener);

    void getAllEducationByType_1(onFinishListener listener);

    void getRefreshAllEducationByType_0(onFinishListener listener);

    void getLoadMoreAllEducationByType_0(onFinishListener listener);
}
