package com.hjianfei.beacon.view.education;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.hjianfei.beacon.R;
import com.hjianfei.beacon.adapter.CommonAdapter;
import com.hjianfei.beacon.adapter.ViewHolder;
import com.hjianfei.beacon.bean.Educations;
import com.hjianfei.beacon.presenter.education.EducationPresenter;
import com.hjianfei.beacon.presenter.education.EducationPresenterImpl;
import com.hjianfei.beacon.view.base.BaseFragment;
import com.hjianfei.beacon.view.educationdetail.EducationDetailActivity;
import com.sevenheaven.segmentcontrol.SegmentControl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;


public class EducationFragment extends BaseFragment implements EducationView {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.segment_control)
    SegmentControl segmentControl;
    @BindView(R.id.education_recyclerView)
    LRecyclerView educationRecyclerView;
    private CommonAdapter<Educations.EducationsBean> mAdapter;
    private List<Educations.EducationsBean> listData = new ArrayList<>();
    private LRecyclerViewAdapter mLRecyclerViewAdapter = null;
    private SweetAlertDialog mDialog;
    private String mParam1;
    private String mParam2;
    private Context mContext;
    private EducationPresenter mEducationPresenter;


    public EducationFragment() {
        // Required empty public constructor
    }


    public static EducationFragment newInstance(String param1, String param2) {
        EducationFragment fragment = new EducationFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        this.mContext = context;
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_education, container, false);
        ButterKnife.bind(this, view);
        mEducationPresenter = new EducationPresenterImpl(this);
        mEducationPresenter.onStart("0");
        segmentControl.setOnSegmentControlClickListener(new SegmentControl.OnSegmentControlClickListener() {
            @Override
            public void onSegmentControlClick(int index) {
                switch (index) {
                    case 0:
                        listData.clear();
                        mEducationPresenter.onStart("0");
                        break;
                    case 1:
                        listData.clear();
                        mEducationPresenter.onStart("1");
                        break;
                }
            }
        });
        initView();
        return view;
    }

    private void initView() {
        mAdapter = new CommonAdapter<Educations.EducationsBean>(mContext, R.layout.education_recyclerview_item, listData) {
            @Override
            public void setData(ViewHolder holder, Educations.EducationsBean educationsBean) {
                holder.setText(R.id.education_item_content, educationsBean.getContent());
                holder.setText(R.id.education_item_content_time, educationsBean.getContent_time());

            }
        };
        mLRecyclerViewAdapter = new LRecyclerViewAdapter(mContext, mAdapter);
        educationRecyclerView.setAdapter(mLRecyclerViewAdapter);
        educationRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        educationRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        educationRecyclerView.setArrowImageView(R.drawable.ic_pulltorefresh_arrow);
        educationRecyclerView.setLScrollListener(new LRecyclerView.LScrollListener() {
            @Override
            public void onRefresh() {
                mEducationPresenter.refreshEducations();
            }

            @Override
            public void onScrollUp() {

            }

            @Override
            public void onScrollDown() {

            }

            @Override
            public void onBottom() {
                mEducationPresenter.loadMoreEducations();

            }

            @Override
            public void onScrolled(int i, int i1) {

            }
        });
        mLRecyclerViewAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
                Intent intent = new Intent(mContext, EducationDetailActivity.class);
                intent.putExtra("detail_url", listData.get(i).getDetail_url());
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int i) {

            }
        });

    }

    @Override
    public void initRecyclerView(List<Educations.EducationsBean> educationsBeans) {
        listData.addAll(educationsBeans);
        educationRecyclerView.refreshComplete();
        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void showProgress() {
        mDialog = new SweetAlertDialog(mContext, SweetAlertDialog.PROGRESS_TYPE);
        mDialog.setTitleText("加载中");
        mDialog.show();

    }

    @Override
    public void hideProgress() {
        if (null != mDialog) {
            mDialog.dismiss();
        }
        educationRecyclerView.refreshComplete();
        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void showError() {
        educationRecyclerView.refreshComplete();
        mAdapter.notifyDataSetChanged();
        mDialog = new SweetAlertDialog(mContext, SweetAlertDialog.ERROR_TYPE);
        mDialog.setTitleText("数据加载失败");
        mDialog.show();
    }

    @Override
    public void showEmpty() {
        educationRecyclerView.refreshComplete();
        mAdapter.notifyDataSetChanged();
        mDialog = new SweetAlertDialog(mContext, SweetAlertDialog.ERROR_TYPE);
        mDialog.setTitleText("没有数据");
        mDialog.show();

    }

    @Override
    public void onDestroy() {
        if (null != mDialog) {
            mDialog.dismiss();
        }
        mEducationPresenter.onDestroy();
        super.onDestroy();
    }
}
