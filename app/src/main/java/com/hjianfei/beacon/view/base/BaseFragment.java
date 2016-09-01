package com.hjianfei.beacon.view.base;


import android.support.v4.app.Fragment;

import rx.Subscription;

/**
 * Created by HJianFei on 2016/8/26.
 */

public class BaseFragment extends Fragment {

    protected Subscription subscription;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unsubscribe();
    }

    protected void unsubscribe() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
