package com.leo.gank.view.history.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.leo.gank.R;
import com.leo.gank.comm.Constants;
import com.leo.gank.comm.utils.Utils;
import com.leo.gank.comm.widget.RatioImageView;
import com.leo.gank.model.comm.GankModel;
import com.leo.gank.model.day.DayModel;
import com.leo.gank.view.history.day.HistoryDataActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by leo on 2016/5/3
 * Function
 */
public class HistoryRecyclerAdapter extends RecyclerView.Adapter<HistoryRecyclerAdapter.ViewHolder> {

    private Context context;
    private Picasso picasso;
    private Glide glide;
    private List<GankModel> girls;
    RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT);

    public HistoryRecyclerAdapter(Context context, List<GankModel> girls) {
        this.context = context;
        this.girls = girls;
        picasso = Picasso.with(context);
        glide = Glide.get(context);
    }

    public void setData(List<GankModel> girls) {
        this.girls = girls;
        notifyDataSetChanged();
    }

    public void addData(List<GankModel> girls) {
        this.girls.addAll(girls);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_history_recycler, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        GankModel girlModel1 = girls.get(position);
        Glide.with(context).load(girlModel1.getUrl()).centerCrop().into(holder.imageview1);
        holder.text1.setText(girlModel1.getDesc());

        if (position == 0) {
            layoutParams.setMargins(0, Utils.dp2px(context, 16),
                    Utils.dp2px(context, 8), Utils.dp2px(context, 8));
            holder.cardView.setLayoutParams(layoutParams);
        } else if (position == 1) {
            layoutParams.setMargins(Utils.dp2px(context, 8), Utils.dp2px(context, 16),
                    0, Utils.dp2px(context, 8));
            holder.cardView.setLayoutParams(layoutParams);
        } else if (position == getItemCount() - 1) {
            layoutParams.setMargins(Utils.dp2px(context, 8), Utils.dp2px(context, 8),
                    0, Utils.dp2px(context, 16));
            holder.cardView.setLayoutParams(layoutParams);
        } else if (position == getItemCount() - 2) {
            layoutParams.setMargins(0, Utils.dp2px(context, 8),
                    Utils.dp2px(context, 8), Utils.dp2px(context, 16));
            holder.cardView.setLayoutParams(layoutParams);
        } else {
            if (position % 2 == 0) {
                layoutParams.setMargins(0, Utils.dp2px(context, 8),
                        Utils.dp2px(context, 8), Utils.dp2px(context, 8));
                holder.cardView.setLayoutParams(layoutParams);
            } else {
                layoutParams.setMargins(Utils.dp2px(context, 8), Utils.dp2px(context, 8),
                        0, Utils.dp2px(context, 8));
                holder.cardView.setLayoutParams(layoutParams);
            }
        }

        holder.cardView.setOnClickListener(new ItemClick(position));

    }

    @Override
    public int getItemCount() {
        return girls.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.imageview1)
        RatioImageView imageview1;
        @Bind(R.id.text1)
        TextView text1;
        @Bind(R.id.cardview)
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            imageview1.setOriginalSize(50, 50);
        }
    }

    private void gotoHistory(int position) {
        Intent intent = new Intent(context, HistoryDataActivity.class);
        intent.putExtra(Constants.Argument.POSITION, position);
        intent.putExtra(Constants.Argument.TITLE, girls.get(position).getDesc());
        intent.putExtra(Constants.Argument.TIME, girls.get(position).getPublishedAt());
        context.startActivity(intent);
    }

    class ItemClick implements View.OnClickListener {

        private int position;

        public ItemClick(int position) {
            this.position = position;
        }

        @Override
        public void onClick(View v) {
            gotoHistory(position);
        }
    }
}
