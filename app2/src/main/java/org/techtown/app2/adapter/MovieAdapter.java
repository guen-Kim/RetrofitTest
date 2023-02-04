package org.techtown.app2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.techtown.app2.R;
import org.techtown.app2.model.DailyBoxOfficeList;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.scrollViewHolder> {

    private List<DailyBoxOfficeList> data;
    private Context ctx;

    public MovieAdapter(Context ctx)
    {
        this.data = new  ArrayList<DailyBoxOfficeList>();
        this.ctx = ctx;
    }

    public void datasetChanged(List<DailyBoxOfficeList> data)
    {
        this.data = data;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public MovieAdapter.scrollViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,parent,false);
        scrollViewHolder holder = new scrollViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull scrollViewHolder holder, int position) {
        holder.setTitle(data.get(position).getMovieNm());
        holder.setRank( data.get(position).getRank());
        holder.setCoun("누적관객 수: " +data.get(position).getAudiCnt());

    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public class scrollViewHolder extends RecyclerView.ViewHolder{
        private TextView tvRank;
        private TextView tvTitle;
        private TextView tvauCoun;

        public scrollViewHolder(@NonNull View itemView) {
            super(itemView);
            tvRank = itemView.findViewById(R.id.tvRank);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvauCoun = itemView.findViewById(R.id.tvauCoun);
        }
        public void setRank(String title)
        {
            tvRank.setText(title);
        }

        public void setTitle(String rank)
        {
            tvTitle.setText(rank);
        }

        public void setCoun(String coun)
        {
            tvauCoun.setText(coun);
        }


    }



}
