package com.leo.gank.view.history.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.leo.gank.R;
import com.leo.gank.comm.Constants;
import com.leo.gank.comm.utils.TimeUtils;
import com.leo.gank.comm.utils.Utils;
import com.leo.gank.model.comm.GankModel;
import com.leo.gank.model.day.DayModel;
import com.leo.gank.view.browser.BrowserActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by leo on 2016/4/28
 * Function
 */
public class HistoryDataRecyclerAdapter extends RecyclerView.Adapter<HistoryDataRecyclerAdapter.ViewHolder> {

    private Context context;
    private Resources res;
    private DayModel dayModel;
    private Picasso picasso;

    private List<GankModel> list;

    public void setDayModel(DayModel dayModel) {
        this.dayModel = dayModel;
        this.list = new ArrayList<>();
        if (dayModel.getResults() != null) {
            if (!Utils.ListUtils.isEmpty(dayModel.getResults().getAndroid())) {
                list.addAll(dayModel.getResults().getAndroid());
            }
            if (!Utils.ListUtils.isEmpty(dayModel.getResults().getIOS())) {
                list.addAll(dayModel.getResults().getIOS());
            }
            if (!Utils.ListUtils.isEmpty(dayModel.getResults().getApp())) {
                list.addAll(dayModel.getResults().getApp());
            }
            if (!Utils.ListUtils.isEmpty(dayModel.getResults().get前端())) {
                list.addAll(dayModel.getResults().get前端());
            }
            if (!Utils.ListUtils.isEmpty(dayModel.getResults().get拓展资源())) {
                list.addAll(dayModel.getResults().get拓展资源());
            }
            if (!Utils.ListUtils.isEmpty(dayModel.getResults().get瞎推荐())) {
                list.addAll(dayModel.getResults().get瞎推荐());
            }
            if (!Utils.ListUtils.isEmpty(dayModel.getResults().get休息视频())) {
                list.addAll(dayModel.getResults().get休息视频());
            }
        }

        notifyDataSetChanged();
    }

    public HistoryDataRecyclerAdapter(Context context, DayModel dayModel) {
        this.context = context;
        this.res = context.getResources();
        this.picasso = Picasso.with(context);
        this.dayModel = dayModel;
        this.list = new ArrayList<>();
        if (dayModel.getResults() != null) {
            if (!Utils.ListUtils.isEmpty(dayModel.getResults().getAndroid())) {
                list.addAll(dayModel.getResults().getAndroid());
            }
            if (!Utils.ListUtils.isEmpty(dayModel.getResults().getIOS())) {
                list.addAll(dayModel.getResults().getIOS());
            }
            if (!Utils.ListUtils.isEmpty(dayModel.getResults().getApp())) {
                list.addAll(dayModel.getResults().getApp());
            }
            if (!Utils.ListUtils.isEmpty(dayModel.getResults().get前端())) {
                list.addAll(dayModel.getResults().get前端());
            }
            if (!Utils.ListUtils.isEmpty(dayModel.getResults().get拓展资源())) {
                list.addAll(dayModel.getResults().get拓展资源());
            }
            if (!Utils.ListUtils.isEmpty(dayModel.getResults().get瞎推荐())) {
                list.addAll(dayModel.getResults().get瞎推荐());
            }
            if (!Utils.ListUtils.isEmpty(dayModel.getResults().get休息视频())) {
                list.addAll(dayModel.getResults().get休息视频());
            }
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_today_recycler, parent, false);
        return new ViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (position == 0) {
            if (dayModel.getResults() != null) {
                if (!Utils.ListUtils.isEmpty(dayModel.getResults().get福利())) {
                    picasso.load(dayModel.getResults().get福利().get(0).getUrl()).into(holder.imageView);
                }
                holder.imageView.setVisibility(View.VISIBLE);

                holder.categoryText.setVisibility(View.GONE);
                holder.itemLayout.setVisibility(View.GONE);
            }

        } else {
            GankModel model = list.get(position - 1);
            holder.imageView.setBackgroundColor(Color.TRANSPARENT);
            holder.imageView.setVisibility(View.GONE);

            if (position == 1) {
                holder.categoryText.setText(model.getType());
                holder.categoryText.setVisibility(View.VISIBLE);
            } else {
                if (TextUtils.equals(model.getType(), list.get(position - 2).getType())) {
                    holder.categoryText.setVisibility(View.GONE);
                } else {
                    holder.categoryText.setText(model.getType());
                    holder.categoryText.setVisibility(View.VISIBLE);
                }
            }

            holder.descText.setText(model.getDesc());
            if (TextUtils.isEmpty(model.getWho())) {
                holder.nameText.setText(res.getText(R.string.NONE));
            } else {
                holder.nameText.setText(model.getWho());
            }
            holder.timeText.setText(TimeUtils.formatDateAndTime(model.getPublishedAt()));
            holder.itemLayout.setOnClickListener(new ItemClick(model.getUrl(), model.getDesc()));
        }

    }

    @Override
    public int getItemCount() {
        return list.size() + 1;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.imageview)
        ImageView imageView;
        @Bind(R.id.category_text)
        TextView categoryText;
        @Bind(R.id.desc_text)
        TextView descText;
        @Bind(R.id.name_text)
        TextView nameText;
        @Bind(R.id.time_text)
        TextView timeText;
        @Bind(R.id.item_layout)
        RelativeLayout itemLayout;

        ViewHolder(View view, Context context) {
            super(view);
            ButterKnife.bind(this, view);

            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.selectableItemBackground, typedValue, true);
            itemLayout.setBackgroundResource(typedValue.resourceId);
        }
    }

    class ItemClick implements View.OnClickListener {

        String url;
        String desc;

        public ItemClick(String url, String desc) {
            this.url = url;
            this.desc = desc;
        }

        @Override
        public void onClick(View v) {
            gotoBrowser(url, desc);
        }
    }

    private void gotoBrowser(String url, String title) {
        Intent intent = new Intent(context, BrowserActivity.class);
        intent.putExtra(Constants.Argument.URL, url);
        intent.putExtra(Constants.Argument.TITLE, title);
        context.startActivity(intent);
    }
}
