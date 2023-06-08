package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Rooms_RecyclerViewAdapter extends RecyclerView.Adapter<Rooms_RecyclerViewAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<RoomsModel> roomsModels;

    public Rooms_RecyclerViewAdapter(Context context, ArrayList<RoomsModel> roomsModels){
        this.context = context;
        this.roomsModels = roomsModels;
    }
    @NonNull
    @Override
    public Rooms_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_room, parent, false);
        return new Rooms_RecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Rooms_RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.tvRoomName.setText(roomsModels.get(position).getRoom());
        holder.icon.setImageResource(roomsModels.get(position).getImage());
        String devicesWcount =  roomsModels.get(position).getRoomDevices() + " " + roomsModels.get(position).getDevicesCount();
        holder.tvDevices.setText(devicesWcount);

    }

    @Override
    public int getItemCount() {

        return roomsModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{

        private Context context;
        ImageView icon;
        TextView tvRoomName, tvDevices;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.context = itemView.getContext();
            icon = itemView.findViewById(R.id.room_image);
            tvRoomName = itemView.findViewById(R.id.device_name);
            tvDevices  = itemView.findViewById(R.id.room_devices);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent;
            switch(getAdapterPosition()){
                case 0:
                    intent = new Intent(this.context, KitchenActivity.class);
                    context.startActivity(intent);
                    break;
                case 1:
                    intent = new Intent(this.context, BedroomActivity.class);
                    context.startActivity(intent);
                    break;
                case 2:
                    intent = new Intent(this.context, LivingRoomActivity.class);
                    context.startActivity(intent);
                    break;
                case 3:
                    intent = new Intent(this.context, HallActivity.class);
                    context.startActivity(intent);
                    break;
                default:
                    break;
            }

        }
    }
}
