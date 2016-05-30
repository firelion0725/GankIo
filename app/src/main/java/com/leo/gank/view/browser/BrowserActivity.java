package com.leo.gank.view.browser;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.leo.gank.R;
import com.leo.gank.comm.utils.DialogUtils;
import com.leo.gank.comm.view.BaseActivity;
import com.leo.gank.comm.widget.ProgressbarWebview;
import com.leo.gank.view.browser.dagger.BrowserComponents;
import com.leo.gank.view.browser.dagger.BrowserModules;
import com.leo.gank.view.browser.dagger.DaggerBrowserComponents;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by leo on 2016/4/25
 * Function
 */
public class BrowserActivity extends BaseActivity implements BrowserImpl {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.webview)
    ProgressbarWebview webview;

    @Inject
    BrowserPresenter presenter;

    private BrowserComponents components;

    private boolean isCollect = false;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);
        ButterKnife.bind(this);
        initData();
        setDataForViews();
    }

    @Override
    protected void initData() {
        components = DaggerBrowserComponents.builder()
                .browserModules(new BrowserModules(this)).build();
        components.inject(this);

        presenter.initData();

    }

    @Override
    protected void setDataForViews() {
    }


    @Override
    public void onBackPressed() {
        if (webview.canBack()) {
            super.onBackPressed();
        }
    }

    @Override
    public void setToolBar(String desc, boolean isCollect) {
        this.isCollect = isCollect;
        toolbar.setNavigationIcon(R.drawable.ic_close_white);
        toolbar.setTitle(desc);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(v -> finish());
    }

    @Override
    public void loadUrl(String url) {
        webview.loadUrl(url);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.i("onCreateOptionsMenu", "isCollect:" + isCollect);
        getMenuInflater().inflate(R.menu.menu_browser, menu);
        MenuItem item = menu.getItem(0);
        if (isCollect) {
            item.setIcon(R.drawable.ic_favorite_red_24dp);
        } else {
            item.setIcon(R.drawable.ic_favorite_border_red_24dp);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_about:
                if (isCollect) {
                    presenter.delete();
                } else {
                    presenter.write();
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
