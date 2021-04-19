package com.example.verticaltickets.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.verticaltickets.R;
import com.example.verticaltickets.model.RecentsData;

import java.util.List;


public class RecentsAdapter  extends RecyclerView.Adapter<RecentsAdapter.RecebtsViewHolder> {

    Context context;
    List<RecentsData> recentsDataList;

    public RecentsAdapter(Context context, List<RecentsData> recentsDataList) {
        this.context = context;
        this.recentsDataList = recentsDataList;
    }

    @NonNull
    @Override
    public RecebtsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recents_row_items,parent,false);
        return new RecebtsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecebtsViewHolder holder, int position) {

        holder.countryName.setText(recentsDataList.get(position).getCountryName());
        holder.price.setText(recentsDataList.get(position).getPrice());
        holder.placeImage.setImageResource(recentsDataList.get(position).getImageUrl());


    }

    @Override
    public int getItemCount() {
        return recentsDataList.size();
    }


    public static final class RecebtsViewHolder extends RecyclerView.ViewHolder{

        ImageView placeImage;
        TextView countryName, price;



        public RecebtsViewHolder(@NonNull View itemView) {
            super(itemView);

            placeImage = itemView.findViewById(R.id.place_image);
            countryName = itemView.findViewById(R.id.country_name);
            price = itemView.findViewById(R.id.price);

        }
    }
}
