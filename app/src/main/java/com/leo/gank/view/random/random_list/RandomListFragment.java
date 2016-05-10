package com.leo.gank.view.random.random_list;

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
import com.leo.gank.comm.adapter.RandomRecyclerAdapter;
import com.leo.gank.comm.view.BaseFragment;
import com.leo.gank.model.comm.GankModel;
import com.leo.gank.view.random.dagger.DaggerRandomListComponents;
import com.leo.gank.view.random.dagger.RandomListComponents;
import com.leo.gank.view.random.dagger.RandomListModules;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by leo on 2016/4/26
 * Function
 */
public class RandomListFragment extends BaseFragment implements RandomListImpl {

    @Inject
    RandomListPresenter presenter;

    RandomListComponents components;

    @Bind(R.id.recyclerview)
    RecyclerView recyclerview;
    @Bind(R.id.swiperefresh)
    SwipeRefreshLayout swiperefresh;

    RandomRecyclerAdapter adapter;

    public static RandomListFragment getInstance(String type) {
        RandomListFragment fragment = new RandomListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.Argument.TYPE, type);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_random_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void initData() {
        components = DaggerRandomListComponents.builder()
                .randomListModules(new RandomListModules(this)).build();
        components.inject(this);

        reset();
    }

    @Override
    protected void setDataForViews() {
        swiperefresh.setColorSchemeResources(R.color.amber_500, R.color.teal_500
                , R.color.blue_500, R.color.pink_500);
        swiperefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.loadData();
            }
        });
    }

    public void reset() {
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new RandomRecyclerAdapter(getContext(), new ArrayList<GankModel>());
        recyclerview.setAdapter(adapter);

        presenter.setType(getArguments().getString(Constants.Argument.TYPE));
        presenter.initData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void openRefresh() {
        swiperefresh.setRefreshing(true);
    }

    @Override
    public void closeRefresh() {
        if (swiperefresh != null && swiperefresh.isRefreshing()) {
            swiperefresh.setRefreshing(false);
        }
    }

    @Override
    public void refreshRecycler(List<GankModel> list) {
        adapter.setResults(list);
    }
}
