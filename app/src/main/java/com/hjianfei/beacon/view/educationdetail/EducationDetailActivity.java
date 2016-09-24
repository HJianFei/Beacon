package com.hjianfei.beacon.view.educationdetail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.hjianfei.beacon.R;
import com.hjianfei.beacon.bean.EducationDetail;
import com.hjianfei.beacon.presenter.educationdetail.EducationDetailPresenter;
import com.hjianfei.beacon.presenter.educationdetail.EducationDetailPresenterImpl;
import com.hjianfei.beacon.utils.richtextutils.ImageTextUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class EducationDetailActivity extends AppCompatActivity implements EducationDetailView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.detail_content)
    TextView detailContent;

    private SweetAlertDialog mDialog;
    private EducationDetailPresenter mEducationDetailPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String detail_url = getIntent().getStringExtra("detail_url");
        setContentView(R.layout.activity_education_detail);
        ButterKnife.bind(this);
        mEducationDetailPresenter = new EducationDetailPresenterImpl(this);
        mEducationDetailPresenter.onStart(detail_url);

    }

    @Override
    public void initData(EducationDetail educationDetail) {
        ImageTextUtil.setImageText(detailContent, educationDetail.getEducationDetail().getContent());

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
        mEducationDetailPresenter.onDestroy();
        super.onDestroy();
    }
}
