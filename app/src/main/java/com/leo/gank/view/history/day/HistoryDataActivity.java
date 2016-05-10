package com.leo.gank.view.history.day;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.leo.gank.R;
import com.leo.gank.comm.Constants;
import com.leo.gank.comm.view.BaseActivity;
import com.leo.gank.model.day.DayModel;
import com.leo.gank.view.history.adapter.HistoryDataRecyclerAdapter;
import com.leo.gank.view.history.dagger.DaggerHistoryDataComponents;
import com.leo.gank.view.history.dagger.HistoryDataComponents;
import com.leo.gank.view.history.dagger.HistoryDataModules;

import java.util.Calendar;
import java.util.Date;

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

    HistoryDataRecyclerAdapter adapter;
    @Bind(R.id.appbar_layout)
    AppBarLayout appbarLayout;

//    private Calendar calendar;

    String title;
    int position = 0;
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

        position = getIntent().getIntExtra(Constants.Argument.POSITION, 0);
        title = getIntent().getStringExtra(Constants.Argument.TITLE);

        Date date = (Date) getIntent().getSerializableExtra(Constants.Argument.TIME);

//        String[] sourceStrArray = title.split("\\.");
//
//        calendar.set(Calendar.MONTH, Integer.parseInt(sourceStrArray[0]) - 1);
//        calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(sourceStrArray[1]));

        adapter = new HistoryDataRecyclerAdapter(this, new DayModel());
        recylerview.setLayoutManager(new LinearLayoutManager(this));
        recylerview.setAdapter(adapter);

        presenter.init(date);
        presenter.initData();
    }

    @Override
    protected void setDataForViews() {
        toolbar.setNavigationIcon(R.drawable.ic_arrow_white);
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void updateView(DayModel model) {
        adapter.setDayModel(model);
    }
}
