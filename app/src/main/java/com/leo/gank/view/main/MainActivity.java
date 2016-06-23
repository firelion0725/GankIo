package com.leo.gank.view.main;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.DatePicker;
import android.widget.FrameLayout;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.leo.gank.R;
import com.leo.gank.comm.Constants;
import com.leo.gank.comm.firebase.FireBaseUtils;
import com.leo.gank.comm.rxjava.RxBus;
import com.leo.gank.comm.view.BaseActivity;
import com.leo.gank.comm.view.BaseFragment;
import com.leo.gank.model.day.DayModel;
import com.leo.gank.view.about.AboutActivity;
import com.leo.gank.view.history.day.HistoryDataActivity;
import com.leo.gank.view.main.dagger.DaggerMainComponents;
import com.leo.gank.view.main.dagger.MainComponents;
import com.leo.gank.view.main.dagger.MainModules;

import java.util.Calendar;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import etong.bottomnavigation.lib.BottomNavigationBar;

public class MainActivity extends BaseActivity implements MainImpl {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.container_layout)
    FrameLayout containerLayout;
    @Bind(R.id.bottom_layout)
    BottomNavigationBar bottomLayout;

    private DatePickerDialog datePickerDialog;
    private Calendar calendar;

    private FragmentManager manager;

    public RxBus rxBus;

    @Inject
    MainPresenter presenter;

    MainComponents components;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initData();
        setDataForViews();
    }

    @Override
    public void initData() {
        FireBaseUtils.initAnalytics(this);

        manager = getSupportFragmentManager();

        components = DaggerMainComponents.builder()
                .mainModules(new MainModules(this)).build();
        components.inject(this);
        rxBus = new RxBus();
        presenter.initData();

        calendar = Calendar.getInstance();
    }

    @Override
    public void setDataForViews() {
        setSupportActionBar(toolbar);
        presenter.setFragment(0);
        //初始化bottomNavi
        bottomLayout.addTab(R.drawable.ic_event_note_white, getString(R.string.today_select), ContextCompat.getColor(this, R.color.indigo_300));
        bottomLayout.addTab(R.drawable.ic_gesture_white, getString(R.string.random_select), ContextCompat.getColor(this, R.color.blue_300));
        bottomLayout.addTab(R.drawable.ic_date_range_white, getString(R.string.history_select), ContextCompat.getColor(this, R.color.light_blue_300));
        bottomLayout.addTab(R.drawable.ic_perm_contact_calendar_white, getString(R.string.me_status), ContextCompat.getColor(this, R.color.cyan_300));
        bottomLayout.setOnTabListener(i -> {
            switch (i) {
                case 0:
                    toolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.indigo_300));
                    setSupportActionBar(toolbar);
                    break;
                case 1:
                    toolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.blue_300));
                    setSupportActionBar(toolbar);
                    break;
                case 2:
                    toolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.light_blue_300));
                    setSupportActionBar(toolbar);
                    break;
                case 3:
                    toolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.cyan_300));
                    setSupportActionBar(toolbar);
                    break;
            }
            presenter.setFragment(i);
            selectDay();
        });
    }

    void setCurrentFragment(BaseFragment fragment) {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container_layout, fragment);
        transaction.commit();
    }

    private void gotoAbout() {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

    private void selectDay() {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        datePickerDialog = new DatePickerDialog(this, (view, yearOfDate, monthOfYear, dayOfMonth) ->
                goDayActivity(yearOfDate, monthOfYear, dayOfMonth)
                , year, month, day);
    }

    @Override
    public void sendHistoryData() {
        rxBus.send(Constants.Notice.HISTORY);
    }

    private void goDayActivity(int year, int month, int day) {
        Intent intent = new Intent(this, HistoryDataActivity.class);
        calendar.set(year, month, day);
        intent.putExtra(Constants.Argument.YEAR, String.valueOf(calendar.get(Calendar.YEAR)));
        intent.putExtra(Constants.Argument.MONTH, String.valueOf(calendar.get(Calendar.MONTH) + 1));
        intent.putExtra(Constants.Argument.DAY, String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_about:
                gotoAbout();
                break;
            case R.id.action_day:
                if (datePickerDialog == null) {
                    selectDay();
                }
                datePickerDialog.show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
