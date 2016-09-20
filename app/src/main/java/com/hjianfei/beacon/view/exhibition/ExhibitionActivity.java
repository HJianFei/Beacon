package com.hjianfei.beacon.view.exhibition;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.hjianfei.beacon.R;
import com.hjianfei.beacon.adapter.CommonAdapter;
import com.hjianfei.beacon.adapter.ViewHolder;
import com.hjianfei.beacon.bean.Exhibitions;
import com.hjianfei.beacon.presenter.exhibition.ExhibitionPresenter;
import com.hjianfei.beacon.presenter.exhibition.ExhibitionPresenterImpl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class ExhibitionActivity extends AppCompatActivity implements ExhibitionView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.exhibition_recyclerView)
    LRecyclerView exhibitionRecyclerView;
    private ExhibitionPresenter mExhibitionPresenter;
    private CommonAdapter<Exhibitions.ExhibitionsBean> mAdapter;
    private List<Exhibitions.ExhibitionsBean> listData = new ArrayList<>();
    private LRecyclerViewAdapter mLRecyclerViewAdapter = null;
    //对话框
    private SweetAlertDialog mDialog;
    private String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        type = getIntent().getStringExtra("type");
        setContentView(R.layout.activity_exhibition);
        ButterKnife.bind(this);
        mExhibitionPresenter = new ExhibitionPresenterImpl(this);
        mExhibitionPresenter.onStart(type);
        initView();
    }

    private void initView() {
        mAdapter = new CommonAdapter<Exhibitions.ExhibitionsBean>(this, R.layout.exhibition_recyclerview_item, listData) {
            @Override
            public void setData(ViewHolder holder, Exhibitions.ExhibitionsBean exhibitionBeans) {
                holder.setImageWithUrl(R.id.iv_exhibition, exhibitionBeans.getImg_url());
                holder.setText(R.id.tv_content, exhibitionBeans.getContent());
            }
        };
        mLRecyclerViewAdapter = new LRecyclerViewAdapter(this, mAdapter);
        exhibitionRecyclerView.setAdapter(mLRecyclerViewAdapter);
        exhibitionRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        exhibitionRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        exhibitionRecyclerView.setArrowImageView(R.drawable.ic_pulltorefresh_arrow);
        exhibitionRecyclerView.setLScrollListener(new LRecyclerView.LScrollListener() {
            @Override
            public void onRefresh() {
                mExhibitionPresenter.refreshExhibitions();
            }

            @Override
            public void onScrollUp() {

            }

            @Override
            public void onScrollDown() {

            }

            @Override
            public void onBottom() {
                mExhibitionPresenter.loadMoreExhibitions();

            }

            @Override
            public void onScrolled(int i, int i1) {

            }
        });
        mLRecyclerViewAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {

            }

            @Override
            public void onItemLongClick(View view, int i) {

            }
        });

    }

    @Override
    public void initRecyclerView(List<Exhibitions.ExhibitionsBean> exhibitionBeansList) {
        listData.addAll(exhibitionBeansList);
        exhibitionRecyclerView.refreshComplete();
        mAdapter.notifyDataSetChanged();
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
        exhibitionRecyclerView.refreshComplete();
        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void showError() {
        exhibitionRecyclerView.refreshComplete();
        mAdapter.notifyDataSetChanged();
        mDialog = new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE);
        mDialog.setTitleText("数据加载失败");
        mDialog.show();

    }

    @Override
    public void showEmpty() {
        exhibitionRecyclerView.refreshComplete();
        mAdapter.notifyDataSetChanged();
        mDialog = new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE);
        mDialog.setTitleText("没有数据");
        mDialog.show();

    }

    @Override
    protected void onDestroy() {
        if (null != mDialog) {
            mDialog.dismiss();
        }
        mExhibitionPresenter.onDestroy();
        super.onDestroy();
    }
}
