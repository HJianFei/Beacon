package com.hjianfei.beacon.view.appreciate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.hjianfei.beacon.R;
import com.hjianfei.beacon.adapter.CommonAdapter;
import com.hjianfei.beacon.adapter.ViewHolder;
import com.hjianfei.beacon.bean.Appreciates;
import com.hjianfei.beacon.presenter.appreciate.AppreciatePresenter;
import com.hjianfei.beacon.presenter.appreciate.AppreciatePresenterImpl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class AppreciateActivity extends AppCompatActivity implements AppreciateView {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.appreciate_recyclerView)
    LRecyclerView mAppreciateRecyclerView;
    private AppreciatePresenter mAppreciatePresenter;
    private CommonAdapter<Appreciates.AppreciatesBean> mAdapter;
    private List<Appreciates.AppreciatesBean> listData = new ArrayList<>();
    private LRecyclerViewAdapter mLRecyclerViewAdapter = null;
    //对话框
    private SweetAlertDialog mDialog;
    private String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = getIntent().getStringExtra("appreciate_type");
        setContentView(R.layout.activity_appreciate);
        ButterKnife.bind(this);
        initView();
        mAppreciatePresenter = new AppreciatePresenterImpl(this);
        mAppreciatePresenter.onStart();
    }

    private void initView() {
        mAdapter = new CommonAdapter<Appreciates.AppreciatesBean>(this, R.layout.appreciate_recyclerview_item, listData) {
            @Override
            public void setData(ViewHolder holder, Appreciates.AppreciatesBean appreciatesBean) {
                holder.setImageWithUrl(R.id.appreciate_item_image, appreciatesBean.getImg_url());
                holder.setText(R.id.appreciate_item_content, appreciatesBean.getContent());

            }
        };
        mLRecyclerViewAdapter = new LRecyclerViewAdapter(this, mAdapter);
        mAppreciateRecyclerView.setAdapter(mLRecyclerViewAdapter);
        mAppreciateRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAppreciateRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mAppreciateRecyclerView.setArrowImageView(R.drawable.ic_pulltorefresh_arrow);
        mAppreciateRecyclerView.setLScrollListener(new LRecyclerView.LScrollListener() {
            @Override
            public void onRefresh() {
                mAppreciatePresenter.refreshAppreciates();

            }

            @Override
            public void onScrollUp() {

            }

            @Override
            public void onScrollDown() {

            }

            @Override
            public void onBottom() {
                mAppreciatePresenter.loadMoreAppreciates();

            }

            @Override
            public void onScrolled(int i, int i1) {

            }
        });
        mLRecyclerViewAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
                Toast.makeText(AppreciateActivity.this, "item:" + i, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int i) {

            }
        });

    }

    @Override
    public void initRecyclerView(List<Appreciates.AppreciatesBean> appreciatesBeans) {
        listData.addAll(appreciatesBeans);
        mAppreciateRecyclerView.refreshComplete();
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
        mAppreciateRecyclerView.refreshComplete();
        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void showError() {
        mAppreciateRecyclerView.refreshComplete();
        mAdapter.notifyDataSetChanged();
        mDialog = new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE);
        mDialog.setTitleText("数据加载失败");
        mDialog.show();

    }

    @Override
    public void showEmpty() {
        mAppreciateRecyclerView.refreshComplete();
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
        mAppreciatePresenter.onDestroy();
        super.onDestroy();
    }
}
