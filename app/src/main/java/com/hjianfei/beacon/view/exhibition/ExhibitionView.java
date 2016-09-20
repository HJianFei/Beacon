package com.hjianfei.beacon.view.exhibition;

import com.hjianfei.beacon.bean.Exhibition;
import com.hjianfei.beacon.view.base.BaseView;

import java.util.List;

/**
 * Created by HJianFei on 2016/9/20.
 */

public interface ExhibitionView extends BaseView {

    //页面可见时，第一次加载页面数据
    void initRecyclerView(List<Exhibition.ExhibitionBean> exhibitionBeanList);
}
