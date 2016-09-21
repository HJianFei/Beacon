package com.hjianfei.beacon.model.education;

import com.hjianfei.beacon.bean.Educations;
import com.hjianfei.beacon.utils.NetWorkUtils;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by HJianFei on 2016/9/19.
 */

public class EducationIndicatorImpl implements EducationIndicator {

    @Override
    public void getAllEducationByType(String type, final onFinishListener listener) {
        NetWorkUtils.getApi().getAllEducationByType(type)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Educations>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Educations educations) {
                        listener.onEducationFinish(educations.getEducations());

                    }
                });

    }

    @Override
    public void getRefreshAllEducationByType_0(onFinishListener listener) {

    }

    @Override
    public void getLoadMoreAllEducationByType_0(onFinishListener listener) {

    }
}
