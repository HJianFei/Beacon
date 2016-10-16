package com.hjianfei.beacon.view.navigation;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brtbeacon.sdk.BRTBeacon;
import com.brtbeacon.sdk.BRTBeaconManager;
import com.brtbeacon.sdk.BRTThrowable;
import com.brtbeacon.sdk.callback.BRTBeaconManagerListener;
import com.github.jdsjlzx.interfaces.Closeable;
import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.interfaces.OnSwipeMenuItemClickListener;
import com.github.jdsjlzx.interfaces.SwipeMenuCreator;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.github.jdsjlzx.swipe.SwipeMenu;
import com.github.jdsjlzx.swipe.SwipeMenuItem;
import com.hjianfei.beacon.R;
import com.hjianfei.beacon.adapter.NavMenuAdapter;
import com.hjianfei.beacon.adapter.RecycleViewDivider;
import com.hjianfei.beacon.application.BaseApplication;
import com.hjianfei.beacon.bean.NavigationInfo;
import com.hjianfei.beacon.presenter.navigation.NavigationPresenter;
import com.hjianfei.beacon.presenter.navigation.NavigationPresenterImpl;
import com.hjianfei.beacon.view.appreciatedetail.AppreciateDetailActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;


public class NavigationFragment extends Fragment implements NavigationView, BRTBeaconManagerListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerview_navigation)
    LRecyclerView recyclerviewNavigation;
    private NavMenuAdapter mDataAdapter = null;
    private LRecyclerViewAdapter mLRecyclerViewAdapter = null;
    private List<NavigationInfo> dataList = BaseApplication.getInstance().getNavigationInfos();
    private Set<BRTBeacon> brtBeacons = BaseApplication.getInstance().getBrtBeacons();

    private String mParam1;
    private String mParam2;
    private Context mContext;
    private BRTBeaconManager beaconManager;
    private NavigationPresenter mNavigationPresenter;


    public NavigationFragment() {

    }

    public static NavigationFragment newInstance(String param1, String param2) {
        NavigationFragment fragment = new NavigationFragment();
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
        BaseApplication application = BaseApplication.getInstance();
        beaconManager = application.getBRTBeaconManager();
        beaconManager.setBRTBeaconManagerListener(this);
        mNavigationPresenter = new NavigationPresenterImpl(this);
        View view = inflater.inflate(R.layout.fragment_navigation, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        mDataAdapter = new NavMenuAdapter();
        mDataAdapter.setDataList(dataList);
        recyclerviewNavigation.setLayoutManager(new LinearLayoutManager(mContext));// 布局管理器。
        recyclerviewNavigation.setHasFixedSize(true);// 如果Item够简单，高度是确定的，打开FixSize将提高性能。
        recyclerviewNavigation.setItemAnimator(new DefaultItemAnimator());// 设置Item默认动画，加也行，不加也行。
        recyclerviewNavigation.addItemDecoration(new RecycleViewDivider(mContext));// 添加分割线。
        // 设置菜单创建器。
        recyclerviewNavigation.setSwipeMenuCreator(swipeMenuCreator);
        // 设置菜单Item点击监听。
        recyclerviewNavigation.setSwipeMenuItemClickListener(menuItemClickListener);

        mLRecyclerViewAdapter = new LRecyclerViewAdapter(mContext, mDataAdapter);
        recyclerviewNavigation.setAdapter(mLRecyclerViewAdapter);

        recyclerviewNavigation.setPullRefreshEnabled(false);
        recyclerviewNavigation.setLongPressDragEnabled(false);// 开启拖拽，就这么简单一句话。
//        recyclerviewNavigation.setOnItemMoveListener(onItemMoveListener);// 监听拖拽，更新UI。

        mLRecyclerViewAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(mContext, AppreciateDetailActivity.class);
                intent.putExtra("detail_url", dataList.get(position).getNavigationInfo().getDetail_url());
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int position) {


            }
        });
    }

    /**
     * 当Item移动的时候。
     */
//    private OnItemMoveListener onItemMoveListener = new OnItemMoveListener() {
//        @Override
//        public boolean onItemMove(int fromPosition, int toPosition) {
//            final int adjFromPosition = mLRecyclerViewAdapter.getAdapterPosition(true, fromPosition);
//            final int adjToPosition = mLRecyclerViewAdapter.getAdapterPosition(true, toPosition);
//            // 当Item被拖拽的时候。
//            Collections.swap(mDataAdapter.getDataList(), adjFromPosition, adjToPosition);
//            //Be carefull in here!
//            mLRecyclerViewAdapter.notifyItemMoved(fromPosition, toPosition);
//            return true;// 返回true表示处理了，返回false表示你没有处理。
//        }
//
//        @Override
//        public void onItemDismiss(int position) {
//            // 当Item被滑动删除掉的时候，在这里是无效的，因为这里没有启用这个功能。
//            // 使用Menu时就不用使用这个侧滑删除啦，两个是冲突的。
//        }
//    };
    /**
     * 菜单创建器
     */
    private SwipeMenuCreator swipeMenuCreator = new SwipeMenuCreator() {
        @Override
        public void onCreateMenu(SwipeMenu swipeLeftMenu, SwipeMenu swipeRightMenu, int viewType) {
            int size = getResources().getDimensionPixelSize(R.dimen.item_height);

            SwipeMenuItem deleteItem = new SwipeMenuItem(mContext)
                    .setBackgroundDrawable(R.drawable.selector_red)
                    .setText("收藏")
                    .setWidth(size)
                    .setHeight(size);

            swipeRightMenu.addMenuItem(deleteItem);// 添加一个按钮到右侧菜单。

            SwipeMenuItem wechatItem = new SwipeMenuItem(mContext)
                    .setBackgroundDrawable(R.drawable.selector_green)
                    .setText("删除")
                    .setWidth(size)
                    .setHeight(size);

            swipeRightMenu.addMenuItem(wechatItem);// 添加一个按钮到右侧菜单。
        }
    };

    /**
     * 菜单点击监听。
     */
    private OnSwipeMenuItemClickListener menuItemClickListener = new OnSwipeMenuItemClickListener() {
        /**
         * Item的菜单被点击的时候调用。
         * @param closeable       closeable. 用来关闭菜单。
         * @param adapterPosition adapterPosition. 这个菜单所在的item在Adapter中position。
         * @param menuPosition    menuPosition. 这个菜单的position。比如你为某个Item创建了2个MenuItem，那么这个position可能是是 0、1，
         * @param direction       如果是左侧菜单，值是：SwipeMenuRecyclerView#LEFT_DIRECTION，如果是右侧菜单，值是：SwipeMenuRecyclerView#RIGHT_DIRECTION.
         */
        @Override
        public void onItemClick(Closeable closeable, int adapterPosition, int menuPosition, int direction) {
            closeable.smoothCloseMenu();// 关闭被点击的菜单。

            if (menuPosition == 0) {
            } else if (menuPosition == 1) {
                mDataAdapter.remove(adapterPosition);
            }
        }
    };

    @Override
    public void onUpdateBeacon(ArrayList<BRTBeacon> arrayList) {

    }

    @Override
    public void onNewBeacon(BRTBeacon brtBeacon) {

        boolean contains = brtBeacons.contains(brtBeacon);
        if (!contains) {
            brtBeacons.add(brtBeacon);
            mNavigationPresenter.initData(brtBeacon.getMinor() + "");
        }


    }

    @Override
    public void onGoneBeacon(BRTBeacon brtBeacon) {

    }

    @Override
    public void onError(BRTThrowable brtThrowable) {

    }

    @Override
    public void onResume() {
        beaconManager.startRanging();
        super.onResume();
    }

    @Override
    public void onPause() {
        beaconManager.stopRanging();
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void initNavigationInfo(NavigationInfo navigationInfo) {
        System.out.println(navigationInfo.getNavigationInfo().getMinor());
        System.out.println(navigationInfo.getNavigationInfo().getContent());
        System.out.println(navigationInfo.getNavigationInfo().getImg_url());
        dataList.add(navigationInfo);
        mDataAdapter.setDataList(dataList);
        mLRecyclerViewAdapter.notifyDataSetChanged();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showEmpty() {

    }
}
