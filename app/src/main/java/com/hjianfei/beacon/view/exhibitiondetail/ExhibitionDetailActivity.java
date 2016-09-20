package com.hjianfei.beacon.view.exhibitiondetail;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.hjianfei.beacon.R;
import com.hjianfei.beacon.adapter.ExhibitionDetailViewPagerAdapter;
import com.hjianfei.beacon.bean.ExhibitionDetail;
import com.hjianfei.beacon.presenter.exhibitiondetail.ExhibitionDetailPresenter;
import com.hjianfei.beacon.presenter.exhibitiondetail.ExhibitionDetailPresenterImpl;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.hintview.ColorPointHintView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class ExhibitionDetailActivity extends AppCompatActivity implements ExhibitionDetailView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.detail_view_pager)
    RollPagerView detailViewPager;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.address)
    TextView address;
    @BindView(R.id.time)
    TextView time;
    @BindView(R.id.content)
    TextView content;
    private SweetAlertDialog mDialog;

    private ExhibitionDetailPresenter mExhibitionDetailPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String detail_url=getIntent().getStringExtra("detail_url");
        setContentView(R.layout.activity_exhibition_detail);
        ButterKnife.bind(this);
        mExhibitionDetailPresenter = new ExhibitionDetailPresenterImpl(this);
        mExhibitionDetailPresenter.onStart(detail_url);
    }

    @Override
    public void initData(ExhibitionDetail exhibitionDetail) {
        title.setText(exhibitionDetail.getExhibitionDetail().getTitle());
        address.setText(exhibitionDetail.getExhibitionDetail().getAddress());
        time.setText(exhibitionDetail.getExhibitionDetail().getShow_time());
        content.setText(exhibitionDetail.getExhibitionDetail().getContent());
        String img_url = exhibitionDetail.getExhibitionDetail().getImg_url();
        img_url = img_url.substring(1, img_url.length() - 1);
        String[] img_urls = img_url.split(",");
        detailViewPager.setPlayDelay(3000);
        detailViewPager.setAdapter(new ExhibitionDetailViewPagerAdapter(img_urls));
        detailViewPager.setHintView(new ColorPointHintView(this, Color.YELLOW, Color.WHITE));
    }

    @Override
    public void showProgress() {
        mDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
        mDialog.setTitleText("加载中");
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
        mExhibitionDetailPresenter.onDestroy();
        super.onDestroy();
    }
}
