package com.hjianfei.beacon.view.education;

import com.hjianfei.beacon.bean.Educations;
import com.hjianfei.beacon.view.base.BaseView;

import java.util.List;

/**
 * Created by HJianFei on 2016/9/19.
 */

public interface EducationView extends BaseView{

    //页面可见时，第一次加载页面数据
    void initRecyclerView(List<Educations.EducationsBean> educationsBeans);
}
