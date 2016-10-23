package com.hjianfei.beacon.model.exhibition;

import com.hjianfei.beacon.bean.Exhibitions;
import com.hjianfei.beacon.utils.L;
import com.hjianfei.beacon.utils.NetWorkUtils;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by HJianFei on 2016/9/20.
 */

public class ExhibitionIndicatorImpl implements ExhibitionIndicator {

    @Override
    public void getAllExhibitions(String type,final onFinishListener listener) {
        NetWorkUtils.getApi().getAllExhibitionByType(type)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Exhibitions>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Exhibitions exhibitions) {
                        L.d("TAG",exhibitions.getExhibitions().toString());
                        listener.onExhibitionFinish(exhibitions.getExhibitions());

                    }
                });

    }

    @Override
    public void RefreshExhibitions(onFinishListener listener) {

    }

    @Override
    public void LoadMoreExhibitions(onFinishListener listener) {

    }
}
