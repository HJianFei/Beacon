package com.hjianfei.beacon.view.home;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hjianfei.beacon.R;
import com.hjianfei.beacon.adapter.HomeViewPagerAdapter;
import com.hjianfei.beacon.bean.Exhibition;
import com.hjianfei.beacon.bean.ViewPager;
import com.hjianfei.beacon.presenter.home.HomePresenter;
import com.hjianfei.beacon.presenter.home.HomePresenterImpl;
import com.hjianfei.beacon.view.appreciate.AppreciateActivity;
import com.hjianfei.beacon.view.base.BaseFragment;
import com.hjianfei.beacon.view.exhibition.ExhibitionActivity;
import com.hjianfei.beacon.view.exhibitiondetail.ExhibitionDetailActivity;
import com.jude.rollviewpager.OnItemClickListener;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.hintview.TextHintView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.pedant.SweetAlert.SweetAlertDialog;

import static com.hjianfei.beacon.R.id.forecast_more;
import static com.hjianfei.beacon.R.id.home_treasure_appreciate;

public class HomeFragment extends BaseFragment implements HomeView {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = "appreciate_type";
    @BindView(R.id.home_view_pager)
    RollPagerView mHomeViewPager;
    @BindView(R.id.home_blue_and_white)
    Button mHomeBlueAndWhite;
    @BindView(home_treasure_appreciate)
    Button mHomeTreasureAppreciate;
    @BindView(R.id.home_nature_specimen)
    Button mHomeNatureSpecimen;
    @BindView(R.id.home_special_appreciate)
    Button mHomeSpecialAppreciate;
    @BindView(forecast_more)
    TextView mForecastMore;
    @BindView(R.id.iv_forecast_more)
    ImageView mIvForecastMore;
    @BindView(R.id.forecast_title)
    TextView mForecastTitle;
    @BindView(R.id.often_more)
    TextView mOftenMore;
    @BindView(R.id.textView)
    TextView mTextView;
    @BindView(R.id.iv_often_more)
    ImageView mIvOftenMore;
    @BindView(R.id.often_title)
    TextView mOftenTitle;
    @BindView(R.id.temp_more)
    TextView mTempMore;
    @BindView(R.id.iv_temp_more)
    ImageView mIvTempMore;
    @BindView(R.id.temp_title)
    TextView mTempTitle;
    @BindView(R.id.back_more)
    TextView mBackMore;
    @BindView(R.id.iv_back_more)
    ImageView mIvBackMore;
    @BindView(R.id.back_title)
    TextView mBackTitle;

    private String mParam1;
    private String mParam2;

    private Context mContext;
    private HomePresenter homePresenter;
    private SweetAlertDialog mDialog;
    private Intent mIntent;

    public HomeFragment() {
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//5.0及以上
            View decorView = getActivity().getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getActivity().getWindow().setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//4.4到5.0
            WindowManager.LayoutParams localLayoutParams = getActivity().getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
        initView();
        return view;
    }

    private void initView() {
        homePresenter = new HomePresenterImpl(this);
        homePresenter.onStart();

    }

    @Override
    public void initHomeViewPager(final ViewPager viewPager) {
        //初始化ViewPager
        mHomeViewPager.setPlayDelay(3000);
        mHomeViewPager.setAdapter(new HomeViewPagerAdapter(viewPager.getViewPagers()));
//        mHomeViewPager.setHintView(new ColorPointHintView(mContext, Color.YELLOW, Color.WHITE));
        mHomeViewPager.setHintView(new TextHintView(mContext, null));

        mHomeViewPager.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                mIntent = new Intent(mContext, ExhibitionDetailActivity.class);
                mIntent.putExtra("detail_url", viewPager.getViewPagers().get(position).getDetail_url());
                startActivity(mIntent);

            }
        });
    }

    @Override
    public void initForecastExhibition(final Exhibition exhibition) {
        Glide.with(mContext)
                .load(exhibition.getExhibition().getImg_url())
                .placeholder(R.drawable.photo)
                .error(R.drawable.photo)
                .into(mIvForecastMore);
        mForecastTitle.setText(exhibition.getExhibition().getContent());
        mForecastMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent = new Intent(mContext, ExhibitionActivity.class);
                mIntent.putExtra("type", "0");
                startActivity(mIntent);

            }
        });
        mIvForecastMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent = new Intent(mContext, ExhibitionDetailActivity.class);
                mIntent.putExtra("detail_url", exhibition.getExhibition().getDetail_url());
                startActivity(mIntent);
            }
        });


    }

    @Override
    public void initOftenExhibition(final Exhibition exhibition) {
        Glide.with(mContext)
                .load(exhibition.getExhibition().getImg_url())
                .placeholder(R.drawable.photo)
                .error(R.drawable.photo)
                .into(mIvOftenMore);
        mOftenTitle.setText(exhibition.getExhibition().getContent());
        mOftenMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent = new Intent(mContext, ExhibitionActivity.class);
                mIntent.putExtra("type", "1");
                startActivity(mIntent);

            }
        });
        mIvOftenMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent = new Intent(mContext, ExhibitionDetailActivity.class);
                mIntent.putExtra("detail_url", exhibition.getExhibition().getDetail_url());
                startActivity(mIntent);
            }
        });
    }

    @Override
    public void initTempExhibition(final Exhibition exhibition) {
        Glide.with(mContext)
                .load(exhibition.getExhibition().getImg_url())
                .placeholder(R.drawable.photo)
                .error(R.drawable.photo)
                .into(mIvTempMore);
        mTempTitle.setText(exhibition.getExhibition().getContent());
        mTempMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent = new Intent(mContext, ExhibitionActivity.class);
                mIntent.putExtra("type", "2");
                startActivity(mIntent);

            }
        });
        mIvTempMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent = new Intent(mContext, ExhibitionDetailActivity.class);
                mIntent.putExtra("detail_url", exhibition.getExhibition().getDetail_url());
                startActivity(mIntent);
            }
        });

    }

    @Override
    public void initBackExhibition(final Exhibition exhibition) {
        Glide.with(mContext)
                .load(exhibition.getExhibition().getImg_url())
                .placeholder(R.drawable.photo)
                .error(R.drawable.photo)
                .into(mIvBackMore);
        mBackTitle.setText(exhibition.getExhibition().getContent());
        mBackMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent = new Intent(mContext, ExhibitionActivity.class);
                mIntent.putExtra("type", "3");
                startActivity(mIntent);

            }
        });
        mIvBackMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntent = new Intent(mContext, ExhibitionDetailActivity.class);
                mIntent.putExtra("detail_url", exhibition.getExhibition().getDetail_url());
                startActivity(mIntent);
            }
        });

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
    }

    @Override
    public void showError() {
        mDialog = new SweetAlertDialog(mContext, SweetAlertDialog.ERROR_TYPE);
        mDialog.show();

    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void onDestroy() {
        homePresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onStop() {
        if (null != mDialog) {
            mDialog.dismiss();
        }
        super.onStop();
    }

    @OnClick({R.id.home_blue_and_white, R.id.home_treasure_appreciate,
            R.id.home_nature_specimen, R.id.home_special_appreciate})
    public void onClickListener(View view) {
        switch (view.getId()) {
            case R.id.home_blue_and_white:
                mIntent = new Intent(mContext, AppreciateActivity.class);
                mIntent.putExtra(TAG, "青花瓷之约");
                startActivity(mIntent);
                break;
            case R.id.home_treasure_appreciate:
                mIntent = new Intent(mContext, AppreciateActivity.class);
                mIntent.putExtra(TAG, "珍品鉴赏");
                startActivity(mIntent);

                break;
            case R.id.home_nature_specimen:
                mIntent = new Intent(mContext, AppreciateActivity.class);
                mIntent.putExtra(TAG, "自然标本");
                startActivity(mIntent);

                break;
            case R.id.home_special_appreciate:
                mIntent = new Intent(mContext, AppreciateActivity.class);
                mIntent.putExtra(TAG, "专题鉴赏");
                startActivity(mIntent);

                break;

        }

    }
}
