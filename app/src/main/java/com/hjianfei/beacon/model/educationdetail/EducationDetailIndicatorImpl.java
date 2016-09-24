package com.hjianfei.beacon.model.educationdetail;

import com.hjianfei.beacon.bean.EducationDetail;
import com.hjianfei.beacon.utils.NetWorkUtils;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by HJianFei on 2016/9/24.
 */

public class EducationDetailIndicatorImpl implements EducationDetailIndicator {
    @Override
    public void getEducationDetail(String detail_url, final onFinishListener listener) {
        NetWorkUtils.getApi().getEducationDetails(detail_url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<EducationDetail>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onError();

                    }

                    @Override
                    public void onNext(EducationDetail educationDetail) {
                        listener.onFinish(educationDetail);

                    }
                });

    }
}
