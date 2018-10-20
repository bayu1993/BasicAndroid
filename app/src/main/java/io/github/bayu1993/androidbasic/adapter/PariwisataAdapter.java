package io.github.bayu1993.androidbasic.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import io.github.bayu1993.androidbasic.R;
import io.github.bayu1993.androidbasic.data.model.PariwisataModel;
import io.github.bayu1993.androidbasic.view.OnPariwisataClick;

/**
 * Created by Bayu teguh pamuji on 10/20/18.
 * email : bayuteguhpamuji@gmail.com.
 */
public class PariwisataAdapter extends RecyclerView.Adapter<PariwisataAdapter.ViewHolder> {
    private List<PariwisataModel> pariwisataModelList;
    private Context context;
    private OnPariwisataClick onPariwisataClick;

    public PariwisataAdapter(Context context, OnPariwisataClick onPariwisataClick) {
        pariwisataModelList = new ArrayList<>();
        this.context = context;
        this.onPariwisataClick = onPariwisataClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_pariwisata, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.bind(pariwisataModelList.get(position));
        holder.imgCover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onPariwisataClick.onCLick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (null != pariwisataModelList ? pariwisataModelList.size() : 0);
    }

    public void updatePariwisata(List<PariwisataModel> pariwisataModelList) {
        this.pariwisataModelList.clear();
        this.pariwisataModelList.addAll(pariwisataModelList);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgCover;
        private TextView tvTitle;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title_pariwisata);
            imgCover = itemView.findViewById(R.id.img_pariwisata);
        }

        void bind(PariwisataModel pariwisataModel) {
            tvTitle.setText(pariwisataModel.getNama_pariwisata());
            Glide.with(context)
                    .load(pariwisataModel.getGambar_pariwisata())
                    .into(imgCover);
        }

    }
}
