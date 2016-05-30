package com.leo.gank.view.about;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.leo.gank.R;
import com.leo.gank.comm.view.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by leo on 2016/4/26
 * Function
 */
public class AboutActivity extends BaseActivity {

    @Bind(R.id.nav_view)
    NavigationView navView;
    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.introduction_text)
    TextView introductionText;
    @Bind(R.id.daimajia_layout)
    LinearLayout daimajiaLayout;
    @Bind(R.id.leo_layout)
    LinearLayout leoLayout;
    @Bind(R.id.appbar_layout)
    AppBarLayout appbarLayout;
    @Bind(R.id.dagger2_text)
    TextView dagger2Text;
    @Bind(R.id.BottomNavigationBar_text)
    TextView BottomNavigationBarText;
    @Bind(R.id.retrofit2_text)
    TextView retrofit2Text;
    @Bind(R.id.butterknife_text)
    TextView butterknifeText;
    @Bind(R.id.picasso_text)
    TextView picassoText;
    @Bind(R.id.glide_text)
    TextView glideText;
    @Bind(R.id.rxjava_text)
    TextView rxjavaText;
    @Bind(R.id.gson_text)
    TextView gsonText;
    @Bind(R.id.realm_text)
    TextView realmText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);

        initData();
        setDataForViews();
    }

    @Override
    protected void initData() {
        StringBuilder stringBuilder = new StringBuilder("干货集中营");
        stringBuilder.append("\n\n");
        stringBuilder.append("每日分享妹子图 和 技术干货，还有供大家中午休息的休闲视频");
        introductionText.setText(stringBuilder.toString());
    }

    @Override
    protected void setDataForViews() {
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.action_about, R.string.action_about);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navView.setNavigationItemSelectedListener(item -> {
            drawerLayout.closeDrawer(GravityCompat.START);
            int id = item.getItemId();
            switch (id) {
                case R.id.nav_go_to_gank:
                    String url = "http://gank.io/";
                    browser(url);
                    break;
                case R.id.nav_back:
                    finish();
                    break;
            }
            return true;
        });
    }

    private void browser(String url) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        Uri content_url = Uri.parse(url);
        intent.setData(content_url);
        startActivity(intent);
    }

    @OnClick({R.id.daimajia_layout, R.id.leo_layout, R.id.dagger2_text
            , R.id.BottomNavigationBar_text, R.id.retrofit2_text
            , R.id.butterknife_text, R.id.picasso_text, R.id.glide_text
            , R.id.rxjava_text, R.id.gson_text, R.id.realm_text})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.daimajia_layout:
                browser("https://github.com/daimajia");
                break;
            case R.id.leo_layout:
                browser("https://github.com/firelion0725");
                break;
            case R.id.dagger2_text:
                browser("https://github.com/google/dagger");
                break;
            case R.id.BottomNavigationBar_text:
                browser("https://github.com/RoyWallace/BottomNavigationBar");
                break;
            case R.id.retrofit2_text:
                browser("https://github.com/square/retrofit");
                break;
            case R.id.butterknife_text:
                browser("https://github.com/JakeWharton/butterknife");
                break;
            case R.id.picasso_text:
                browser("https://github.com/square/picasso");
                break;
            case R.id.glide_text:
                browser("https://github.com/bumptech/glide");
                break;
            case R.id.rxjava_text:
                browser("https://github.com/ReactiveX/RxJava");
                break;
            case R.id.gson_text:
                browser("https://github.com/google/gson");
                break;
            case R.id.realm_text:
                browser("https://github.com/realm/realm-java");
                break;
        }
    }


}
