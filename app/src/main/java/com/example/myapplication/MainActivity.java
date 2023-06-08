package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<RoomsModel> roomsModels = new ArrayList<>();

    int[] roomsImages = {R.drawable.ic_kitchen, R.drawable.ic_bedroom, R.drawable.ic_living_room, R.drawable.ic_hall};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.roomsRecyclerView);

        setUpRoomsModels();

        Rooms_RecyclerViewAdapter adapter = new Rooms_RecyclerViewAdapter(this, roomsModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setUpRoomsModels(){
        String[] roomsNames = getResources().getStringArray(R.array.rooms_list);
        int[] devicesCount = {getResources().getStringArray(R.array.kitchen_devices).length,
                getResources().getStringArray(R.array.bedroom_devices).length,
                getResources().getStringArray(R.array.living_room_devices).length,
                getResources().getStringArray(R.array.hall_devices).length};
        String roomsDevices = getResources().getString(R.string.rooms_devices_string);

        for(int i = 0; i<roomsNames.length; i++)
            roomsModels.add(new RoomsModel(roomsNames[i],roomsDevices, roomsImages[i], devicesCount[i]));
    }

}