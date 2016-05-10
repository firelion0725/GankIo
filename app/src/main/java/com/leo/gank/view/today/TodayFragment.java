package com.leo.gank.view.today;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.leo.gank.R;
import com.leo.gank.comm.Constants;
import com.leo.gank.comm.rxjava.RxBus;
import com.leo.gank.comm.utils.Utils;
import com.leo.gank.comm.view.BaseFragment;
import com.leo.gank.data.history.HistoryCache;
import com.leo.gank.model.day.DayModel;
import com.leo.gank.view.main.MainActivity;
import com.leo.gank.view.today.adapter.TodayRecyclerAdapter;
import com.leo.gank.view.today.dagger.DaggerTodayComponents;
import com.leo.gank.view.today.dagger.TodayComponents;
import com.leo.gank.view.today.dagger.TodayModules;
import com.squareup.picasso.Picasso;

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

    TodayRecyclerAdapter adapter;

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
        adapter = new TodayRecyclerAdapter(getContext(), new DayModel());
        recylerview.setAdapter(adapter);
        if (!Utils.ListUtils.isEmpty(HistoryCache.getHistoryCache().getResults())) {
            Date date = HistoryCache.getHistoryCache().getResults().get(0);
            presenter.init(date);
            presenter.initData();
        }
    }

    @Override
    protected void setDataForViews() {
        rxBus.subscribe().subscribe(new Action1<Object>() {
            @Override
            public void call(Object o) {
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
        });
    }

    @Override
    public void updateView(DayModel model) {
        adapter.setDayModel(model);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
