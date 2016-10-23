package com.hjianfei.beacon.view.appreciatedetail;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.hjianfei.beacon.R;
import com.hjianfei.beacon.adapter.ExhibitionDetailViewPagerAdapter;
import com.hjianfei.beacon.bean.AppreciateDetail;
import com.hjianfei.beacon.presenter.appreciatedetail.AppreciateDetailPresenter;
import com.hjianfei.beacon.presenter.appreciatedetail.AppreciateDetailPresenterImpl;
import com.hjianfei.beacon.utils.L;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.hintview.ColorPointHintView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class AppreciateDetailActivity extends AppCompatActivity implements AppreciateDetailView {

    @BindView(R.id.appreciate_detail_view_pager)
    RollPagerView appreciateDetailViewPager;
    @BindView(R.id.content)
    TextView content;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    private SweetAlertDialog mDialog;
    private AppreciateDetailPresenter mAppreciateDetailPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String detail_url = getIntent().getStringExtra("detail_url");
        setContentView(R.layout.activity_appreciate_detail);
        ButterKnife.bind(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//5.0及以上
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//4.4到5.0
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        mAppreciateDetailPresenter = new AppreciateDetailPresenterImpl(this);
        mAppreciateDetailPresenter.onStart(detail_url);
    }

    @Override
    public void initAppreciateDetailData(AppreciateDetail appreciateDetail) {
        collapsingToolbar.setTitle(appreciateDetail.getAppreciateDetail().getTitle());
        title.setText( appreciateDetail.getAppreciateDetail().getTitle());
        L.d("TAG",appreciateDetail.getAppreciateDetail().getContent());
        content.setText( appreciateDetail.getAppreciateDetail().getContent());
        String img_url = appreciateDetail.getAppreciateDetail().getImg_url();
        img_url = img_url.substring(1, img_url.length() - 1);
        String[] img_urls = img_url.split(",");
        appreciateDetailViewPager.setPlayDelay(3000);
        appreciateDetailViewPager.setAdapter(new ExhibitionDetailViewPagerAdapter(img_urls));
        appreciateDetailViewPager.setHintView(new ColorPointHintView(this, Color.YELLOW, Color.WHITE));

    }

    @Override
    public void showProgress() {
        mDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
        mDialog.setTitleText("数据加载中");
        mDialog.show();

    }

    @Override
    public void hideProgress() {
        if (null != mDialog) {
            mDialog.dismiss();
        }
    }

    @Override
    public void showError() {
        mDialog = new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE);
        mDialog.show();

    }

    @Override
    public void showEmpty() {

    }

    @Override
    protected void onDestroy() {
        mAppreciateDetailPresenter.onDestroy();
        super.onDestroy();
    }
}
