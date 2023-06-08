package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HallActivity extends AppCompatActivity {

    ArrayList<DevicesModel> devicesModels = new ArrayList<>();
    ImageButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hall_layout);

        RecyclerView recyclerView = findViewById(R.id.devicesRecyclerView);

        setUpDevicesModels();

        Devices_RecyclerViewAdapter adapter = new Devices_RecyclerViewAdapter(this, devicesModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        button = findViewById(R.id.imageButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });
    }

    private void setUpDevicesModels(){
        String[] devicesNames = getResources().getStringArray(R.array.hall_devices);
        int[] switchStates = getResources().getIntArray(R.array.hall_switches);
        for(int i = 0; i<devicesNames.length; i++)
            devicesModels.add(new DevicesModel(devicesNames[i], switchStates[i]));
    }
    public void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}