package com.hjianfei.beacon.application;

import android.app.Application;

import com.brtbeacon.sdk.BRTBeacon;
import com.brtbeacon.sdk.BRTBeaconManager;
import com.hjianfei.beacon.bean.NavigationInfo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by HJianFei on 2016/8/26.
 */

public class BaseApplication extends Application {

    private static BaseApplication instance;
    private BRTBeaconManager beaconManager;
    private Set<BRTBeacon> brtBeacons;
    private ArrayList<NavigationInfo> navigationInfos;

    @Override
    public void onCreate() {
        super.onCreate();
        this.instance = this;
        //获取单例
        beaconManager = BRTBeaconManager.getInstance(this);
        // 开启Beacon扫描服务
        beaconManager.startService();
        brtBeacons = new HashSet<>();
        navigationInfos = new ArrayList<>();

    }

    public static BaseApplication getInstance() {
        return instance;
    }

    /**
     * 获取Beacon管理对象
     *
     * @return BRTBeaconManager
     */
    public BRTBeaconManager getBRTBeaconManager() {
        return beaconManager;
    }

    /**
     * 全局管理Navigation
     *
     * @return
     */
    public Set<BRTBeacon> getBrtBeacons() {
        return brtBeacons;
    }

    /**
     * 全局管理NavigationInfo
     *
     * @return
     */
    public ArrayList<NavigationInfo> getNavigationInfos() {
        return navigationInfos;
    }
}
