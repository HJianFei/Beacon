package com.hjianfei.beacon.view.appreciate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hjianfei.beacon.R;
import com.hjianfei.beacon.bean.Appreciates;

import java.util.List;

public class AppreciateActivity extends AppCompatActivity implements AppreciateView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appreciate);
    }

    @Override
    public void initRecyclerView(List<Appreciates> appreciates) {

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
