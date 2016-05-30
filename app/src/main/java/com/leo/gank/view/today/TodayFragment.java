package com.leo.gank.view.today;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leo.gank.R;
import com.leo.gank.comm.Constants;
import com.leo.gank.comm.adapter.DayRecyclerAdapter;
import com.leo.gank.comm.rxjava.RxBus;
import com.leo.gank.comm.utils.Utils;
import com.leo.gank.comm.view.BaseFragment;
import com.leo.gank.data.history.HistoryCache;
import com.leo.gank.model.day.DayModel;
import com.leo.gank.view.main.MainActivity;
import com.leo.gank.view.today.dagger.DaggerTodayComponents;
import com.leo.gank.view.today.dagger.TodayComponents;
import com.leo.gank.view.today.dagger.TodayModules;

import java.util.Date;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.functions.Action1;

/**
 * Created by leo on 2016/4/25
 * Function
 */
public class TodayFragment extends BaseFragment implements TodayImpl {

    RxBus rxBus;

    @Inject
    TodayPresenter presenter;

    TodayComponents components;

    @Bind(R.id.recylerview)
    RecyclerView recylerview;

    DayRecyclerAdapter adapter;
    @Bind(R.id.swiperefresh)
    SwipeRefreshLayout swiperefresh;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_today, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void initData() {
        rxBus = ((MainActivity) getActivity()).rxBus;
        components = DaggerTodayComponents.builder()
                .todayModules(new TodayModules(this)).build();
        components.inject(this);

        recylerview.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new DayRecyclerAdapter(getContext(), new DayModel());
        recylerview.setAdapter(adapter);
        if (!Utils.ListUtils.isEmpty(HistoryCache.getHistoryCache().getResults())) {
            Date date = HistoryCache.getHistoryCache().getResults().get(0);
            presenter.init(date);
            presenter.initData();
        }
    }

    @Override
    protected void setDataForViews() {
        rxBus.subscribe().subscribe(o -> {
                    if (o instanceof String) {
                        String str = (String) o;
                        switch (str) {
                            case Constants.Notice.HISTORY:
                                presenter.init(HistoryCache.getHistoryCache().getResults().get(0));
                                presenter.loadData();
                                break;
                        }
                    }
                }
        );

        swiperefresh.setOnRefreshListener(() -> presenter.loadDataFromNet());
    }

    @Override
    public void updateView(DayModel model) {
        adapter.setDayModel(model);
    }

    @Override
    public void openRefresh() {
        swiperefresh.setRefreshing(true);
    }

    @Override
    public void closeRefresh() {
        swiperefresh.setRefreshing(false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
