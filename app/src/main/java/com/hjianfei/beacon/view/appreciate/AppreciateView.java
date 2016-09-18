package com.hjianfei.beacon.view.appreciate;

import com.hjianfei.beacon.bean.Appreciates;
import com.hjianfei.beacon.view.base.BaseView;

import java.util.List;

/**
 * 创建时间： 2016/9/17.
 * 作者：HJianFei
 * 功能描述：
 */

public interface AppreciateView extends BaseView {

    //页面可见时，第一次加载页面数据
    void initRecyclerView(List<Appreciates> appreciates);

}
