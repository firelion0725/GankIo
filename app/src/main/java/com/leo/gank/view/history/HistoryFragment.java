package com.leo.gank.view.history;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leo.gank.R;
import com.leo.gank.comm.view.BaseFragment;
import com.leo.gank.model.comm.GankModel;
import com.leo.gank.view.history.adapter.HistoryRecyclerAdapter;
import com.leo.gank.view.history.dagger.DaggerHistoryComponents;
import com.leo.gank.view.history.dagger.HistoryComponents;
import com.leo.gank.view.history.dagger.HistoryModules;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by leo on 2016/4/25
 * Function
 */
public class HistoryFragment extends BaseFragment implements HistoryImpl {

    @Inject
    HistoryPresenter presenter;

    HistoryComponents components;

    @Bind(R.id.recyclerview)
    RecyclerView recyclerview;

    private HistoryRecyclerAdapter adapter;

    private boolean loading = true;
    private int pastVisiblesItems, visibleItemCount, totalItemCount;
    private GridLayoutManager gridLayoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void initData() {
        components = DaggerHistoryComponents.builder()
                .historyModules(new HistoryModules(this)).build();
        components.inject(this);

        gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerview.setLayoutManager(gridLayoutManager);
        adapter = new HistoryRecyclerAdapter(getContext(), new ArrayList<GankModel>());
        recyclerview.setAdapter(adapter);

        presenter.initData();
    }

    @Override
    protected void setDataForViews() {
        recyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                visibleItemCount = gridLayoutManager.getChildCount();
                totalItemCount = gridLayoutManager.getItemCount();
                pastVisiblesItems = gridLayoutManager.findFirstVisibleItemPosition();
                if (dy > 0) //check for scroll down
                {
                    if (loading) {
                        if ((visibleItemCount + pastVisiblesItems) >= totalItemCount) {
                            loading = false;
                            presenter.initData();
                        }
                    }
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void refresh(List<GankModel> girls) {
        if (adapter != null) {
            adapter.addData(girls);
        }
        loading = true;
    }

    @Override
    public void reSet(List<GankModel> girls) {
        adapter = new HistoryRecyclerAdapter(getContext(), girls);
        recyclerview.setAdapter(adapter);
        loading = true;
    }


}
