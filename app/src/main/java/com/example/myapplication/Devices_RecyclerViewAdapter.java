package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Devices_RecyclerViewAdapter extends RecyclerView.Adapter<Devices_RecyclerViewAdapter.MyViewHolder> {
    Context context;
    ArrayList<DevicesModel> devicesModels;

    public Devices_RecyclerViewAdapter(Context context, ArrayList<DevicesModel> devicesModels){
        this.context = context;
        this.devicesModels = devicesModels;
    }
    @NonNull
    @Override
    public Devices_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_kitchen, parent, false);
        return new Devices_RecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Devices_RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.tvDeviceName.setText(devicesModels.get(position).getDevice());
        holder.switchDevice.setChecked(devicesModels.get(position).isSwitchOn());
    }

    @Override
    public int getItemCount() {

        return devicesModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{


        TextView tvDeviceName;
        Switch switchDevice;
        CardView cardView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvDeviceName = itemView.findViewById(R.id.device_name);
            cardView = itemView.findViewById(R.id.row_item_card);
            switchDevice = itemView.findViewById(R.id.device_switch);

        }

            /*for(CardView cardView : cardViewList){
                cardView.setBackgroundResource(R.drawable.gradient1);
            }
            cardView.setBackgroundResource(R.drawable.gradient2);*/

        }
    }
