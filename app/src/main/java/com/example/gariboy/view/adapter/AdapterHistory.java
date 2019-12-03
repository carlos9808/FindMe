package com.example.gariboy.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gariboy.R;
import com.example.gariboy.data.LocationPing;

import java.util.List;

public class AdapterHistory extends RecyclerView.Adapter<AdapterHistory.ViewHolderHistory> {

    Context mContext;
    List<LocationPing> locationPings;


    public AdapterHistory(Context mContext, List<LocationPing> locationPings) {
        this.mContext = mContext;
        this.locationPings = locationPings;

    }

    @Override
    public ViewHolderHistory onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.location_item, parent, false);
        ViewHolderHistory vHolder = new ViewHolderHistory(v);
        return vHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolderHistory holder, int position) {
        final LocationPing currentLocation =locationPings.get(position);
        holder.location.setText(currentLocation.getLocation());

    }

    @Override
    public int getItemCount() {
        return locationPings.size();
    }

    public static class ViewHolderHistory extends RecyclerView.ViewHolder {
        public TextView location;

        public ViewHolderHistory(View itemView) {
            super(itemView);
            location = itemView.findViewById(R.id.text_location);
        }
    }
}
