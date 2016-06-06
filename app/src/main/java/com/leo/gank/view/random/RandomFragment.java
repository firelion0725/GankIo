package com.leo.gank.view.random;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leo.gank.R;
import com.leo.gank.comm.view.BaseFragment;
import com.leo.gank.data.history.HistoryCache;
import com.leo.gank.view.random.adapter.RandomViewPagerAdapter;
import com.leo.gank.view.random.dagger.DaggerRandomComponents;
import com.leo.gank.view.random.dagger.RandomComponents;
import com.leo.gank.view.random.dagger.RandomModules;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by leo on 2016/4/25
 * Function
 */
public class RandomFragment extends BaseFragment implements RandomImpl {

    @Inject
    RandomPresenter presenter;

    private RandomComponents components;

    @Bind(R.id.tablayout)
    TabLayout tabLayout;
    @Bind(R.id.viewpager)
    ViewPager viewpager;

    private RandomViewPagerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_random, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void initData() {
        components = DaggerRandomComponents.builder()
                .randomModules(new RandomModules(this)).build();
        components.inject(this);

        String[] strs = getResources().getStringArray(R.array.random_array);
        adapter = new RandomViewPagerAdapter(getFragmentManager(), strs);
        viewpager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewpager);
    }

    @Override
    protected void setDataForViews() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
