package com.leo.gank.comm.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.leo.gank.R;
import com.leo.gank.comm.Constants;
import com.leo.gank.comm.utils.TimeUtils;
import com.leo.gank.model.comm.GankModel;
import com.leo.gank.view.browser.BrowserActivity;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by leo on 2016/4/27
 * Function
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private Context context;
    private List<GankModel> results;

    public RecyclerAdapter(Context context, List<GankModel> results) {
        this.context = context;
        this.results = results;
    }

    public void setResults(List<GankModel> results) {
        this.results = results;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_random_recycler, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final GankModel resultsEntity = results.get(position);
        holder.descText.setText(resultsEntity.getDesc());
        holder.nameText.setText(resultsEntity.getWho());
        holder.timeText.setText(TimeUtils.formatDateAndTime(resultsEntity.getPublishedAt()));
        holder.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoBrowser(resultsEntity);
            }
        });
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    private void gotoBrowser(GankModel model) {
        Intent intent = new Intent(context, BrowserActivity.class);
        intent.putExtra(Constants.Argument.MODEL, model);
        context.startActivity(intent);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.desc_text)
        TextView descText;
        @Bind(R.id.name_text)
        TextView nameText;
        @Bind(R.id.time_text)
        TextView timeText;
        @Bind(R.id.item_layout)
        RelativeLayout itemLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.selectableItemBackground, typedValue, true);
            itemView.setBackgroundResource(typedValue.resourceId);
        }
    }

}
