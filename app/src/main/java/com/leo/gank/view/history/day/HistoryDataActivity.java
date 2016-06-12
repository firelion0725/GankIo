package com.leo.gank.view.history.day;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.leo.gank.R;
import com.leo.gank.comm.adapter.DayRecyclerAdapter;
import com.leo.gank.comm.view.BaseActivity;
import com.leo.gank.model.day.DayModel;
import com.leo.gank.view.history.dagger.DaggerHistoryDataComponents;
import com.leo.gank.view.history.dagger.HistoryDataComponents;
import com.leo.gank.view.history.dagger.HistoryDataModules;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by leo on 2016/5/4
 * Function
 */
public class HistoryDataActivity extends BaseActivity implements HistoryDataImpl {

    @Inject
    HistoryDataPresenter presenter;

    HistoryDataComponents components;

    DayRecyclerAdapter adapter;
    @Bind(R.id.appbar_layout)
    AppBarLayout appbarLayout;

    String title;
    @Bind(R.id.recylerview)
    RecyclerView recylerview;
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_data);
        ButterKnife.bind(this);

        initData();
        setDataForViews();
    }

    @Override
    protected void initData() {
        components = DaggerHistoryDataComponents.builder()
                .historyDataModules(new HistoryDataModules(this))
                .build();
        components.inject(this);

        adapter = new DayRecyclerAdapter(this, new DayModel());
        recylerview.setLayoutManager(new LinearLayoutManager(this));
        recylerview.setAdapter(adapter);

        presenter.init();
        presenter.initData();
    }

    @Override
    protected void setDataForViews() {
        toolbar.setNavigationIcon(R.drawable.ic_back_white);
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(v -> finish());
    }

    @Override
    public void updateView(DayModel model) {
        adapter.setDayModel(model);
    }
}
